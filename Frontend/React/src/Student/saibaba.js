import { Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import { useState, useContext, createContext } from 'react'
import 'react-toastify/dist/ReactToastify.css'
import SignIn from '../SignupLogin/SignIn'
import SignUp from '../SignupLogin/StudentSignUp'
import MainPage from '../SignupLogin/MainPage'
import TeacherSignUp from '../SignupLogin/TeacherSignUp'
import StudentSignUp from '../SignupLogin/StudentSignUp'
import Content from '../Teacher Content/Content'
import App from "../App"
import Home from '../Home'
import Addcourse from '../Addcourse'
import Allcourse from '../Allcourses'
import Student from '../Students'
import TeacherMainPage from "../Teacher Content/TeacherMainPage"
import Addcontent from '../Teacher Content/AddContent'
import FetchStudents from '../Teacher Content/MyStudents'

function SaiBaba() {
 

  return (
    <div className='container-fluid'>
      <Routes>
        <Route index element={<SignIn />} />
        <Route path='/' Component={SignIn} />
        <Route path='/Home' Component={Home} />
        <Route path='/Mystudents' Component={FetchStudents} />
        <Route path="/MainPage" Component={MainPage} exact />
        <Route path="/App" Component={App} exact />
        <Route path="/Content" Component={Content} exact />
        <Route path="/SignIn" Component={SignIn} exact />
        <Route path="/TeacherSignup" Component={TeacherSignUp} exact />
        <Route path="/StudentSignup" Component={StudentSignUp} exact />
        <Route path = "Today" Component={App} />
        {/* <Route path="/addcourse" Component={Addcourse} exact /> */}
        <Route path="/viewcourse" Component={Allcourse} exact />
       <Route path="/students" Component={Student} exact />
       <Route path="/TeacherMainPage" Component={TeacherMainPage} exact />
       <Route path="/contents" Component={Content} exact />
       <Route path="/AddContent" Component={Addcontent} exact />
      </Routes>
      <ToastContainer />
    </div>
   
  )
}

export default SaiBaba
