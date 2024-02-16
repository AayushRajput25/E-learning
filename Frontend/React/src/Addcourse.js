import React, { useState } from "react";
import { Button, Form, FormGroup, Label, Input, FormText, Container } from 'reactstrap';
import axios from "axios";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
const Addcourse = () => 
{
    const [Course , changeCourse] = useState({ courseName: "", description : ""})
    const [refValue, setRefValue] = useState("");
    
    const email = sessionStorage["email"]
    const navigate = useNavigate();
useEffect(() => {
    console.log(Course)}, [Course]
  )

  useEffect(() => {
    axios.get("http://localhost:8080/home/" + email).then((Response) => {setRefValue(Response.data)})
    }, [email])

    const serverUrl = `http://localhost:8080/teacher/course/${refValue.id}`

const CourseSubmit = (event) => 
{
    event.preventDefault()
    axios.post(serverUrl, Course).then((response) => { console.log("Success")
    }).catch((error) => {console.log(error)});
   // navigate("/SignIn");
}

const handleChange = (event, property) => {
    changeCourse({...Course, [property]:event.target.value})
      } 

return(
<div>
    <h1 className="text-center my-3">Add Course</h1>
<Form onSubmit={CourseSubmit}>

    <FormGroup>
        <label for="title">Course Name</label>
        <Input type = "text" placeholder="Enter Title here" id="title"
        onChange={(e) => handleChange(e, "courseName")}
        value={Course.courseName}/>
    </FormGroup>

    <FormGroup>
        <label for="description">Course Description</label>
        <Input type = "textarea" placeholder="Enter Description here" id="description"
        style={{height:170}}
        onChange={(e) => handleChange(e, "description")}
        value={Course.description}
        />
    </FormGroup>

    <Container className="text-center">
    <Button color="success">Add Course</Button>
    <Button color="warning ml-2">clear</Button>
    </Container>
</Form>
</div>
);
}

export default Addcourse;