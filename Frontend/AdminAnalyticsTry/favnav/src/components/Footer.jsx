import React from 'react';
import { Link } from 'react-router-dom';
import { Container, Row, Col } from 'reactstrap'; // Import Reactstrap components
import 'bootstrap/dist/css/bootstrap.min.css';

const Footer = () => {
  return (
    <footer className="bg-dark text-light mt-5 py-4">
      <Container>
        <Row>
          <Col md={6}>
            <div className="mb-4">
              <h5>E-Learning</h5>
              <p>A platform for online learning</p>
              <p>&copy; {new Date().getFullYear()} E-Learning. All rights reserved.</p>
              <p><Link to="/privacy-policy" className="text-light">Privacy Policy</Link> | <Link to="/terms-of-service" className="text-light">Terms of Service</Link></p>
            </div>
          </Col>
          <Col md={3}>
            <div className="mb-4">
              <h5>Quick Links</h5>
              <ul className="list-unstyled">
                <li><Link to="/" className="text-light">Home</Link></li>
                <li><Link to="/about" className="text-light">About</Link></li>
                <li><Link to="/login" className="text-light">Login</Link></li>
                <li><Link to="/contact" className="text-light">Contact</Link></li>
              </ul>
            </div>
          </Col>
          <Col md={3}>
            <div className="mb-4">
              <h5>Contact Us</h5>
              <p>123 E-Learning St.</p>
              <p>City, Country</p>
              <p>Email: info@example.com</p>
              <p>Phone: +1234567890</p>
            </div>
          </Col>
        </Row>
        <Row>
          <Col>
            <h5>FAQ</h5>
            <ul className="list-unstyled">
              <li><Link to="/faq" className="text-light">Frequently Asked Questions</Link></li>
            </ul>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default Footer;
