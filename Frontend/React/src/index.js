import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './Home';
import SignUp from './SignupLogin/StudentSignUp';
import SignIn from './SignupLogin/SignIn';
import MainPage from './SignupLogin/MainPage';
import { BrowserRouter } from 'react-router-dom';
import Try from './SignupLogin/try';
import SaiBaba from './Student/saibaba';
import ImageUpload from './imageUploadTest';
import ImageDisplay from './ImageDisplayTest';
import Content from './Teacher Content/Content';
import Course from './Course';
import TeacherSignUp from './SignupLogin/TeacherSignUp';
import StudentSignUp from "./SignupLogin/StudentSignUp"
import Allcourse from './Allcourses';
import Student from './Students';
import HomeSign from './SignupLogin/HomeSign';
import VideoUpload from './SignupLogin/try';
import FetchStudents from './Teacher Content/MyStudents';
import AdminPanel from './Admin/AdminPanel';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

  <BrowserRouter>
    <SaiBaba/>
  </BrowserRouter>
  
  

);
