import React, { useEffect } from 'react';
import axios from 'axios';

const GetStudentTestAPI = () => {
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/admin/admin/student');
        console.log(response.data);
      } catch (error) {
        console.error('Error fetching student data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      {/* You can render any UI elements here */}
    </div>
  );
};

export default GetStudentTestAPI;
