import React from "react";
import Navbar from "../components/Navbar";
import CourseCard from "../components/CourseCard";
import Background from "../components/Background";
import Footer from "../components/Footer";

const CourseData = [
  {"name": "Java", "description": "It is also possible to insert multip"},
  {"name": "Python", "description": "Python is a versatile programming language"},
  {"name": "JavaScript", "description": "JavaScript is a scripting language used for web development"},
  {"name": "React", "description": "React is a JavaScript library for building user interfaces"},
  {"name": "Node.js", "description": "Node.js is a JavaScript runtime built on Chrome's V8 JavaScript engine"},
  {"name": "Angular", "description": "Angular is a TypeScript-based open-source framework for building web applications"},
  {"name": "HTML5", "description": "HTML5 is the latest version of the Hypertext Markup Language"},
  {"name": "CSS3", "description": "CSS3 is the latest evolution of the Cascading Style Sheets language"},
  {"name": "SQL", "description": "SQL (Structured Query Language) is a domain-specific language used in programming and managing relational databases"},
  {"name": "Git", "description": "Git is a distributed version control system for tracking changes in source code during software development"},
  {"name": "Vue.js", "description": "Vue.js is a progressive JavaScript framework for building user interfaces"},
  {"name": "Django", "description": "Django is a high-level Python web framework that encourages rapid development and clean, pragmatic design"},
  {"name": "C#", "description": "C# (C Sharp) is a modern, object-oriented programming language developed by Microsoft"},
  {"name": "Swift", "description": "Swift is a powerful and intuitive programming language for iOS, macOS, watchOS, and tvOS"},
  {"name": "MongoDB", "description": "MongoDB is a NoSQL database program that uses JSON-like documents with optional schemas"},
];

const imageUrl = 'https://wallpapercave.com/wp/wp3815943.png';

const Home = () => {
  return (
    <div>
      <div>
      <Navbar />
      <div className="container">
        <div className="row">
          {CourseData.map((course, index) => (
            <div key={index} className="col-md-3 mb-3">
              <CourseCard title={course.name} description={course.description} />
            </div>
          ))}
        </div>
      </div>
      <Background imageUrl={imageUrl} />
      
      </div>
      <Footer/>
    </div>
  );
};
export default Home;
