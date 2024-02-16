import React from 'react';
import { Col, Button, Form, FormGroup, Label, Input, FormText, Container, CardHeader, CardBody, Card, Row } from 'reactstrap';
import { useState } from 'react';
import axios from 'axios';
import { useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { redirect } from "react-router-dom";
import MainPage from './MainPage';
import { useNavigate , Link} from "react-router-dom";
import TeacherSignUp from "./TeacherSignUp"
const SignIn = (props) => {

  const[data, setdata] = useState({
    email : "",   password : ""
  })

useEffect(() => {
  console.log(data)}, [data]
)
const navigate = useNavigate();
  
  const serverUrl = "http://localhost:8080/users/signin";

  const handleChange = (event, property) => {
    setdata({...data, [property]:event.target.value})
      } 

  const login = async (event) => {
  event.preventDefault()
 const result = await axios.post(serverUrl, data)
 console.log(result.data.message)
  if (result.data.message == "Successful Authentication!!") {

    const token = result['data']['jwt']
    sessionStorage['email'] = data.email
    sessionStorage['Authorization'] = "Bearer " + token
    toast.success(result.data.message)

    const rolee = axios.get("http://localhost:8080/home/" + data.email)
    console.log((await rolee).data)
    if((await rolee).data.role == "TEACHER")
    {
      navigate("/TeacherMainPage");
    }
  } 
else
  {
    toast.error(result.data.message)
  }
}


  return (
    <div>
        <br/>
        <br/>
      <Container>
        <Row>
            
            <Col
            sm = {{size:8, offset:2}}>
          <Card>
          <CardHeader> <h1 className='text-center my-2'>Sign In Page</h1></CardHeader>
     
     <CardBody>
    <Form onSubmit={login}> 

      <FormGroup row>
        <Label for="exampleEmail" sm={2}>Email</Label>
        <Col sm={10}>
          <Input type="email" name="email" id="exampleEmail" placeholder="Enter your Email here" 
           onChange={(e)=>handleChange(e, 'email')} value={data.email}/>
        </Col>
      </FormGroup>
      <FormGroup row>
        <Label for="examplePassword" sm={2}>Password</Label>
        <Col sm={10}>
          <Input type="password" name="password" id="examplePassword" placeholder="Enter your Password here" 
           onChange={(e)=>handleChange(e, 'password')} value={data.password}/>
        </Col>
      </FormGroup>
      <Button color='success' outline>Sign In</Button>
    </Form>
    </CardBody>
    </Card>
    </Col>
    </Row>
    </Container>
    <br></br>
    <div className='text-center'  style={{marginLeft:190 ,marginRight:190}}><h3>New Here??</h3>
    <Link className="list-group-item list-group-item-action" tag="A" to="/StudentSignup"><h4>Register as Student</h4></Link>
    <Link className="list-group-item list-group-item-action" tag="A" to="/TeacherSignUP"><h4>Register as Teacher</h4></Link>
</div>


    <ToastContainer/>
    </div>
  );
}

export default SignIn;
