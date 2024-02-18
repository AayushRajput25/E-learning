
import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Button } from "reactstrap";

const AllStudents = () => {
    const [refValue, setRefValue] = useState("");
    const [Students, setStudents] = useState([]);
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
        fetchStudents()
    }, []);
  
    const fetchStudents = () => {
      axios.get(`http://localhost:8080/admin/student`)
        .then((response) => {
          setStudents(response.data);
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
        <h1 className="text-center mr-4">All Students</h1>
        <br></br>
        <br></br>
        <div>
          <Table hover>
            <thead>
              <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>PhoneNo</th>
                <th>Address</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody>
              {Students.map((item) => (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.name}</td>
                  <td>{item.age}</td>
                  <td>{item.gender}</td>
                  <td>{item.phoneNo}</td>
                  <td>{item.Address}</td>
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
    export default AllStudents
