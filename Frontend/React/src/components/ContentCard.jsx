import React from 'react';
import './css/CourseCard.css'; // Import the external CSS file
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Button } from 'bootstrap';
import { useState } from 'react';


const ContentCard = ({ title, description, courseId, kaam, eid }) => {
    
    const [showDeletePrompt, setShowDeletePrompt] = useState(false);
    
    const handleDelete = async () => {
        try{
            const response = await axios.delete(`http://localhost:8080/student/enroll/${eid}`);
            if (response.status === 200){
                toast.success("Successfully Unenrolled!", {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "colored",
                })
                console.log("Delete ho gaya");    
            }
        }
        catch(e){
            console.log("Some error: " + e);
        }
    }

  const handleEnroll = async () => {
    const studentId = sessionStorage.getItem('student_id');
    if (studentId != null || sessionStorage.getItem('jwt') != null) {
      try {
        await axios.post(`http://localhost:8080/student/enroll/${studentId}/${courseId}`);
        // show a message to the user
        toast.success("Successfully Enrolled!", {
        position: "top-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "colored"
        })
        console.log(`Enrolled in course ${courseId}`);
      } catch (error) {
        toast.error('Something Went Wrong!', {
          position: "top-right",
          autoClose: 5000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          theme: "colored",
        });
        console.error('Error enrolling in the course:', error);
        // Handle the error, e.g., show an error message to the user
      }
    }
  };


  return (
    <>
    <div className="card m-3 custom-card">
      <div className="card-body">
        <h5 className="card-title">{title}</h5>
        <p className="card-text">{description}</p>
        <div className="d-flex justify-content-between align-items-center">
          <button className="btn btn-success" onClick={handleEnroll}>
            {kaam}
          </button>
          <button className="btn btn-primary" onClick={handleDelete}>Unenroll</button>
    
        </div>
      </div>
    </div>
    <ToastContainer
      position="top-right"
      autoClose={5000}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick
      rtl={false}
      pauseOnFocusLoss
      draggable
      pauseOnHover
      theme="colored"/>
    </>
  );
};

export default ContentCard;
