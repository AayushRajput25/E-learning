// import React, { useState, useEffect } from "react";
// import Navbar from "../../components/Navbar";
// import CourseCard from "../../components/CourseCard";
// import Background from "../../components/Background";
// import axios from "axios";

// const imageUrl = sessionStorage.getItem('imgUrl');
// const StudentCourses = () => {
//   const [courseData, setCourseData] = useState([]);

//   useEffect(() => {
//     const studentId = sessionStorage.getItem('student_id');
//     axios.get(`http://localhost:8080/student/enroll/${studentId}`)
//       .then(response => setCourseData(response.data))
//       .catch(error => console.error('Error fetching data:', error));
//   }, []);

//   return (
//     <Background imageUrl={imageUrl}>
//       <Navbar />
//       <div className="container">
//         <div className="row">
//           {courseData.map((course, index) => (
//             <div key={index} className="col-md-3 mb-3">
//               <CourseCard
//                 title={course.cname}
//                 description={course.des}
//                 courseId={course.eid}
//                 kaam={"View Contents"}
//               />
//             </div>
//           ))}
//         </div>
//       </div>
//     </Background>
//   );
// };

//  My work
import React, { useEffect, useState } from "react";
import axios from "axios";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  Card, CardBody, CardSubtitle, CardText, Button, Container
} from 'reactstrap';
import { useNavigate } from 'react-router-dom'

const StudentCourses = () => {
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
          const response = await axios.get(`http://localhost:8080/student/enroll/${refValue.id}`);
          setCourses(response.data);
        }
      } catch (error) {
        notify();
      }
    };

    fetchData();
  }, [refValue]);

  useEffect(() => {
    console.log(Courses)
  }, [Courses])

  const ViewContent = (Courseid) => {
    console.log(Courseid)
     sessionStorage['Course'] = Courseid
     navigate('/Studentcontents')
  }
  
  return (

    <div>
      <h1 className="text-center">All Courses</h1>
      <p>List of Courses are as follows</p>

      {Courses.length > 0 ? Courses.map((item) => (
        <div key={item.eid}>
          <Card className="text-center ml-3">
            <CardBody>
              <CardSubtitle className="font-weight-bold">{item.cname}</CardSubtitle>
              <CardText>{item.des}</CardText>
              <Container className="text-center">
                <Button color="warning" onClick={() => ViewContent(item.id)}>View Content</Button>
                <Button color="danger ml-3" >Unenroll</Button>
              </Container>
            </CardBody>
          </Card>
        </div>
      )) : "No courses"}
    </div>
   
  );
}

export default StudentCourses;
