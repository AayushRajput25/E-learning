
import React, { useState, useEffect } from "react";
import Navbar from "../../components/Navbar";
import ContentCard from "../../components/ContentCard";
import Background from "../../components/Background";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import './StudentCourses.css'; // Import a separate CSS file for styling

const StudentCourses = () => {
  const [courseData, setCourseData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const studentId = sessionStorage.getItem('student_id');
    axios.get(`http://localhost:8080/student/enroll/${studentId}`)
      .then(response => setCourseData(response.data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <Background imageUrl={sessionStorage.getItem('bgimg')}>
      <Navbar />
      <div className="container">
        {courseData.length === 0 ? (
          <div className="empty-courses-container text-center mt-5">
            <p className="empty-courses-text">You Are Not Enrolled In Any Courses</p>
            <button className="btn btn-primary explore-courses-btn" onClick={() => navigate('/home')}>Explore Courses</button>
          </div>
        ) : (
          <div className="row">
            {courseData.map((course, index) => (
              <div key={index} className="col-md-3 mb-3">
                <ContentCard
                  title={course.cname}
                  description={course.des}
                  courseId={course.id}
                  eid={course.eid}
                  kaam={"View Contents"}
                />
              </div>
            ))}
          </div>
        )}
      </div>
    </Background>
  );
};

export default StudentCourses;
