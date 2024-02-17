import React, { useState, useEffect } from "react";
import Navbar from "../../components/Navbar";
import CourseCard from "../../components/CourseCard";
import Background from "../../components/Background";
import axios from "axios";

const imageUrl = sessionStorage.getItem('imgUrl');
const StudentCourses = () => {
  const [courseData, setCourseData] = useState([]);

  useEffect(() => {
    const studentId = sessionStorage.getItem('student_id');
    axios.get(`http://localhost:8080/student/enroll/${studentId}`)
      .then(response => setCourseData(response.data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <Background imageUrl={imageUrl}>
      <Navbar />
      <div className="container">
        <div className="row">
          {courseData.map((course, index) => (
            <div key={index} className="col-md-3 mb-3">
              <CourseCard
                title={course.cname}
                description={course.des}
                courseId={course.eid}
                kaam={"View Contents"}
              />
            </div>
          ))}
        </div>
      </div>
    </Background>
  );
};

export default StudentCourses;
