import React from "react";
import { Col, Container, Row } from "react-bootstrap";

const purl = "./Pictures/nModi.jpg";
const linkedinUrl = "https://www.linkedin.com/in/example";
const githubUrl = "https://github.com/example";

const AshishPurl = "./Pictures/contactPics/ashCP.jpeg";
const AshishLinkedinUrl = "https://www.linkedin.com/in/example";
const AshishGithubUrl = "https://github.com/example";

const AyushPurl = "./Pictures/contactPics/ayushCP.jpeg";
const AyushLinkedinUrl = "https://www.linkedin.com/in/example";
const AyushGithubUrl = "https://github.com/example";

const UtkarshPurl = "./Pictures/contactPics/utkarshCP.jpeg";
const UtkarshLinkedinUrl = "https://www.linkedin.com/in/example";
const UtkarshGithubUrl = "https://github.com/example";

const HarshPurl = "./Pictures/contactPics/harshCP.jpeg";
const HarshLinkedinUrl = "https://www.linkedin.com/in/example";
const HarshGithubUrl = "https://github.com/example";





function Contact() {
  return (
    <div style={{ backgroundImage: `url(./Pictures/backKliye.png)`, backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '100vh' }}>
      <div className="ContactHeading" style={{ display: "flex", justifyContent: "center", fontSize: "24px", fontWeight: "bold" }}> 
        Contacts
      </div>
      <div>
        <Container style={{ border: "1px solid #ccc", boxShadow: "2px 2px 5px rgba(0, 0, 0, 0.1)", padding: "20px", borderRadius: "5px", maxWidth: "400px", marginBottom: "20px" }}>
          <Row>
            <Col xs={12} md={6}>
              <div>
                <div>Email: ayush25rajput@gmail.com</div>
              </div>
              <div>
                <a href={linkedinUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/LinkedIn_icon.png" alt="LinkedIn" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  LinkedIn Profile
                </a>
              </div>
              <div>
                <a href={githubUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/GitHub_icon.png" alt="GitHub" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  GitHub Profile
                </a>
              </div>
            </Col>
            <Col xs={12} md={6}>
              <Row className="align-items-end">
                <Col xs={6} md={12} className="text-md-right mb-3 mb-md-0">
                  <label></label>
                </Col>
                <Col xs={6} md={12} className="text-center">
                  <img src={AyushPurl} alt="Photo" className="img-fluid" style={{ width: '100px', height: '100px' }} />
                </Col>
              </Row>
            </Col>
          </Row>
        </Container>
        <Container style={{ border: "1px solid #ccc", boxShadow: "2px 2px 5px rgba(0, 0, 0, 0.1)", padding: "20px", borderRadius: "5px", maxWidth: "400px", marginBottom: "20px" }}>
          <Row>
            <Col xs={12} md={6}>
              <div>
                <div>Email: ashsharma612@gmail.com</div>
              </div>
              <div>
                <a href={linkedinUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/LinkedIn_icon.png" alt="LinkedIn" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  LinkedIn Profile
                </a>
              </div>
              <div>
                <a href={githubUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/GitHub_icon.png" alt="GitHub" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  GitHub Profile
                </a>
              </div>
            </Col>
            <Col xs={12} md={6}>
              <Row className="align-items-end">
                <Col xs={6} md={12} className="text-md-right mb-3 mb-md-0">
                  <label></label>
                </Col>
                <Col xs={6} md={12} className="text-center">
                  <img src={AshishPurl} alt="Photo" className="img-fluid" style={{ width: '100px', height: '100px' }} />
                </Col>
              </Row>
            </Col>
          </Row>
        </Container>
        <Container style={{ border: "1px solid #ccc", boxShadow: "2px 2px 5px rgba(0, 0, 0, 0.1)", padding: "20px", borderRadius: "5px", maxWidth: "400px", marginBottom: "20px" }}>
          <Row>
            <Col xs={12} md={6}>
              <div>
                <div>Email: harshrathore493@gmail.com</div>
              </div>
              <div>
                <a href={linkedinUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/LinkedIn_icon.png" alt="LinkedIn" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  LinkedIn Profile
                </a>
              </div>
              <div>
                <a href={githubUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/GitHub_icon.png" alt="GitHub" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  GitHub Profile
                </a>
              </div>
            </Col>
            <Col xs={12} md={6}>
              <Row className="align-items-end">
                <Col xs={6} md={12} className="text-md-right mb-3 mb-md-0">
                  <label></label>
                </Col>
                <Col xs={6} md={12} className="text-center">
                  <img src={HarshPurl} alt="Photo" className="img-fluid" style={{ width: '100px', height: '100px' }} />
                </Col>
              </Row>
            </Col>
          </Row>
        </Container>
        <Container style={{ border: "1px solid #ccc", boxShadow: "2px 2px 5px rgba(0, 0, 0, 0.1)", padding: "20px", borderRadius: "5px", maxWidth: "400px", marginBottom: "20px" }}>
          <Row>
            <Col xs={12} md={6}>
              <div>
                <div>Email: utkarsh217s@gmail.com</div>
              </div>
              <div>
                <a href={linkedinUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/LinkedIn_icon.png" alt="LinkedIn" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  LinkedIn Profile
                </a>
              </div>
              <div>
                <a href={githubUrl} target="_blank" rel="noopener noreferrer">
                  <img src="./Pictures/GitHub_icon.png" alt="GitHub" style={{ width: '20px', height: '20px', marginRight: '5px' }} />
                  GitHub Profile
                </a>
              </div>
            </Col>
            <Col xs={12} md={6}>
              <Row className="align-items-end">
                <Col xs={6} md={12} className="text-md-right mb-3 mb-md-0">
                  <label></label>
                </Col>
                <Col xs={6} md={12} className="text-center">
                  <img src={UtkarshPurl} alt="Photo" className="img-fluid" style={{ width: '100px', height: '100px' }} />
                </Col>
              </Row>
            </Col>
          </Row>
        </Container>
              </div>
    </div>
  );
}

export default Contact;
