import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const StudentDashboard = () => {
  const [student, setStudent] = useState(null);
  const { studentId } = useParams();
  console.log(studentId);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchStudentDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/student/4`);
        setStudent(response.data);
      } catch (error) {
        console.error('Error fetching student details:', error);
      }
    };

    fetchStudentDetails();
  }, [studentId]); //id mangta

  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8080/student/${student.studentId}`);
      navigate('/'); // Redirect 
    } catch (error) {
      console.error('Error deleting student:', error);
    }
  };

  return (
    <div>
      <h1>Student Dashboard</h1>
      {student ? (
        <div>
          <p>Name: {student.name}</p>
          <p>Age: {student.age}</p>
          <p>Gender: {student.gender}</p>
          <p>Phone Number: {student.phoneNo}</p>
          <p>Address: {student.address}</p>
          <p>ID: {student.id}</p>
          <button onClick={handleDelete}>Delete</button>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default StudentDashboard;
