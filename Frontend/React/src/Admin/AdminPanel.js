import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    NavbarText,
    Row,
    Col,
    Button
  } from 'reactstrap';
  import { useNavigate } from "react-router-dom";
import AllStudents from "./AllStudents"
import AllTeacher from "./AllTeachers"

const AdminPanel = () => {
    const email = sessionStorage["email"]
    const [refValue, setRefValue] = useState("");
    const [isOpen, setIsOpen] = useState(false);
    const [conditionn, setCondition] = useState("-1");
    useEffect(() => {
        axios.get("http://localhost:8080/home/"+ email).then((Response) => {setRefValue(Response.data)})
        }, [email])


  const toggle = () => setIsOpen(!isOpen);
  const navigate = useNavigate() 

  const OnLogOut = () => {
    sessionStorage.removeItem('Authenticate')
    navigate('/')
  }

  function YourComponent() {
    if (conditionn === "0") {
     return <AllStudents/>
    } else if (conditionn === "1"){
      return <AllTeacher/>
    }
    else if (conditionn === "2")
      {
//return <FetchStudents/>
      }
    }

    const ChangePage = (pageno) => {
        setCondition(pageno)
      }
        
    return (<div>
<Navbar color="dark" dark expand="md" className='container-fluid'>
        <NavbarBrand href="/">E-Learning</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="mr-auto" navbar>
          <NavItem>
            <Link className="nav-link" onClick={()=>ChangePage("0")}>View All Students</Link>
            </NavItem>
            <NavItem>
            <Link className="nav-link" onClick={()=>ChangePage("1")}>View All Teachers</Link>
            </NavItem>
            <NavItem>
            <Link className="nav-link" to="/" onClick={OnLogOut}>Logout</Link>
            </NavItem>
            <UncontrolledDropdown nav inNavbar>
              {/* <DropdownToggle nav caret>
                Options
              </DropdownToggle> */}
              <DropdownMenu right>
                <DropdownItem>
                  Option 1
                </DropdownItem>
                <DropdownItem>
                  Option 2
                </DropdownItem>
                <DropdownItem divider />
                <DropdownItem>
                  Reset
                </DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <NavbarText>ADMIN PANEL</NavbarText>
        </Collapse>
      </Navbar>

      <Row>
      <Col md={2}>

      </Col>
      <Col md={10}>
        {YourComponent()}
      </Col>
      </Row>
    </div>) ;
}
export default AdminPanel