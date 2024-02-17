import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';  // Import react-toastify CSS
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import Navbar from './components/Navbar';
import Content from './components/Content';
import Home from './Pages/Home';
import About from './Pages/About';
import LoginPage from './Pages/LoginPage';
import StudentSignUpPage from './Pages/StudentSignUpPage';
import TeacherSignUpPage from './Pages/TeacherSignUpPage';
import LoginForm from './components/LoginForm';
import TeacherSignUp from './components/TeacherSignUp';
import StudentSignup from './components/StudentSignUp';
import StudentDashboard from './Pages/StudentPages/StudentDashboard';
import Logout from './components/Logout';
import StudentCourses from './Pages/StudentPages/StudentCourses';
import EditStudent from './Pages/StudentPages/EditStudent';


function App() {
  return (
    <div>
      <div>
        <Router>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/home" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/student_signup" element={<StudentSignUpPage />} />
            <Route path="/teacher_signup" element={<TeacherSignUpPage />} />
            <Route path="/student_dashboard" element={<StudentDashboard />} />
            <Route path="/logout" element={<Logout />} />
            <Route path="/my_courses" element={<StudentCourses />} />
            <Route path="/edit_student" element={<EditStudent />} />
          </Routes> 
        </Router>
      </div>
    </div>
  );
}

export default App;
