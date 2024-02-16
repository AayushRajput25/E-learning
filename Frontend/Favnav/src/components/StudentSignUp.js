import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // Import useNavigate

function StudentSignUp() {
  const navigate = useNavigate(); // Initialize useNavigate

  const [userData, setUserData] = useState({
    name: "",
    age: 20,
    gender: "Male",
    phoneNo: "3215588954",
    email: "@gmail.com",
    password: "12345",
    address: "korba",
    joiningDate: "2024-02-11"
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/users/student_signup', userData);
      console.log(response.data);
      
      navigate('/login');
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (    
    <div className="container mt-4" style={{ maxWidth: '700px' }}>
      <div className="card p-3 shadow">
        <h2 className="mb-3 text-center">Student SignUp</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
        <label className="form-label">Name:</label>
        <input
            type="text"
            name="name"
            value={userData.name}
            onChange={handleChange}
            className="form-control"
            required
            placeholder='Name'
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Age:</label>
        <input
            type="number"
            name="age"
            value={userData.age}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Gender:</label>
        <input
            type="text"
            name="gender"
            value={userData.gender}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Phone Number:</label>
        <input
            type="text"
            name="phoneNo"
            value={userData.phoneNo}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Email:</label>
        <input
            type="email"
            name="email"
            value={userData.email}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Password:</label>
        <input
            type="password"
            name="password"
            value={userData.password}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Address:</label>
        <input
            type="text"
            name="address"
            value={userData.address}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>
        <div className="mb-3">
        <label className="form-label">Joining Date:</label>
        <input
            type="text"
            name="joiningDate"
            value={userData.joiningDate}
            onChange={handleChange}
            className="form-control"
            required
        />
        </div>

          <button type="submit" className="btn btn-primary mb-3">Submit</button>
        </form>

        <p className="mb-0">Are you a Teacher? <a href='/teacher_signup'>Sign Up</a></p>
      </div>
    </div>
  );
}

export default StudentSignUp;