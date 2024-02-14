import React, { useState } from 'react';
import LoginForm from './components/LoginForm';
import TeacherSignUp from './components/TeacherSignUp';
import StudentSignup from './components/StudentSignUp';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import Navbar from './components/Navbar';
import Content from './components/Content';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import About from './Pages/About';
import LoginPage from './Pages/LoginPage';
import StudentSignUpPage from './Pages/StudentSignUpPage';
import TeacherSignUpPage from './Pages/TeacherSignUpPage';
import CourseCard from './components/CourseCard';
import ContactPage from './Pages/ContactPage';


function App() {
 
  return (
    <div>
      <div>
        <Router>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/student_signup" element={<StudentSignUpPage />} />
            <Route path="/teacher_signup" element={<TeacherSignUpPage />} />
            <Route path="/contact" element={<ContactPage/>} />

          </Routes> 
        </Router>
      </div>
    
    </div>
  );
}

export default App;
