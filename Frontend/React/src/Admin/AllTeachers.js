
import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Button } from "reactstrap";

const AllTeachers = () => {
    const [refValue, setRefValue] = useState("");
    const [Teachers, setTeachers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
  
 //   const email = sessionStorage["email"];
  
    // useEffect(() => {
    //   axios.get("http://localhost:8080/home/" + email)
    //     .then((response) => {
    //       setRefValue(response.data);
    //     })
    //     .catch((error) => {
    //       setError(error);
    //     });
    // }, [email]);
  
    useEffect(() => {
        fetchTeachers()
    }, []);
  
    const fetchTeachers = () => {
      axios.get(`http://localhost:8080/admin/admin/teacher`)
        .then((response) => {
          setTeachers(response.data);
        })
        .catch((error) => {
          setError(error);
        })
        .finally(() => {
          setLoading(false);
        });
    };

return(<div>
      <br></br>
      <h1 className="text-center mr-4">All Teachers</h1>
      <br></br>
      <br></br>
      <div>
        <Table hover>
          <thead>
            <tr>
              <th>Teacher ID</th>
              <th>Teacher Name</th>
              <th>Age</th>
              <th>Gender</th>
              <th>PhoneNo</th>
              <th>degree</th>
              <th>specialization</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {Teachers.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.age}</td>
                <td>{item.gender}</td>
                <td>{item.phoneNo}</td>
                <td>{item.degree}</td>
                <td>{item.specialization}</td>
                <td>
                  <Button color="danger" size="sm" className="ml-4">delete</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </div>)
}
export default AllTeachers