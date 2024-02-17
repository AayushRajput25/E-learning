import React from 'react';
import './css/CourseCard.css'; // Import the external CSS file
import axios from 'axios';

const CourseCard = ({ title, description, courseId, kaam }) => {
  const handleEnroll = async () => {
    const studentId = sessionStorage.getItem('student_id');
    if (studentId != null || sessionStorage.getItem('jwt') != null) {
      try {
        await axios.post(`http://localhost:8080/student/enroll/${studentId}/${courseId}`);
        // Add logic for successful enrollment, e.g., show a message to the user
        console.log(`Enrolled in course ${courseId}`);
      } catch (error) {
        console.error('Error enrolling in the course:', error);
        // Handle the error, e.g., show an error message to the user
      }
    }
  };

  return (
    <div className="card m-3 custom-card">
      <div className="card-body">
        <h5 className="card-title">{title}</h5>
        <p className="card-text">{description}</p>
        <div className="d-flex justify-content-between align-items-center">
          <button className="btn btn-success" onClick={handleEnroll}>
            {kaam}
          </button>
          <span className="badge bg-info text-white">Free</span>
        </div>
      </div>
    </div>
  );
};

export default CourseCard;
