import React, { useEffect, useState } from "react";
import axios from "axios";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  Card, CardBody, CardSubtitle, CardText, Button, Container
} from 'reactstrap';
import { useNavigate } from 'react-router-dom'
import { useContext } from "react";
import MyContext from "./Student/MyContext";
import context from "react-bootstrap/esm/AccordionContext";
import { Routes, Route } from "react-router-dom";
import Content from "./Teacher Content/Content";
const Allcourse = () => {
  const navigate = useNavigate()  
  const notify = () => toast.error('Fetching Unsuccessful', {
    position: "top-right",
    autoClose: 2000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
    draggable: true,
    progress: undefined,
    theme: "light",
  });

  const email = sessionStorage["email"];
  const [Courses, setCourses] = useState([]);
  const [refValue, setRefValue] = useState("");
 

  useEffect(() => {
    axios.get("http://localhost:8080/home/" + email).then((Response) => {setRefValue(Response.data)});
  }, [email]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Check if refValue is truthy before making the request
        if (refValue) {
          const response = await axios.get(`http://localhost:8080/teacher/course/${refValue.id}`);
          setCourses(response.data);
        }
      } catch (error) {
        notify();
      }
    };

    fetchData();
  }, [refValue]);

  const deleteCourse = (id) => {
    const serverUrl = `http://localhost:8080/teacher/course/${id}`;
    axios.delete(serverUrl).then(() => {
      // Filter out the deleted course from the state
      setCourses(prevCourses => prevCourses.filter(course => course.id !== id));
    }).catch((error) => {
      console.log(error);
    });
  }

  const Addcontent = (Courseid) => {
    sessionStorage['Course'] = Courseid
  //const nextState = { courseData: Courseid, refValue }; // yahi pe problem aayipk
  navigate('/contents')
  
  }

  return (

    <div>
      <h1 className="text-center">All Courses</h1>
      <p>List of Courses are as follows</p>

      {Courses.length > 0 ? Courses.map((item) => (
        <div key={item.id}>
          <Card className="text-center ml-3">
            <CardBody>
              <CardSubtitle className="font-weight-bold">{item.courseName}</CardSubtitle>
              <CardText>{item.description}</CardText>
              <Container className="text-center">
                <Button color="warning" onClick={() => Addcontent(item.id)}>Add content</Button>
                <Button color="danger ml-3" onClick={() => deleteCourse(item.id)}>Delete</Button>
              </Container>
            </CardBody>
          </Card>
        </div>
      )) : "No courses"}
    </div>
   
  );
}

export default Allcourse;
