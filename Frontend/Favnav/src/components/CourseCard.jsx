import React from 'react';

const CourseCard = ({ title, description }) => {
  return (
    <div className="card m-3" style={{ width: '18rem', boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)', transition: 'box-shadow 0.3s' }}>
      <div className="card-body">
        <h5 className="card-title">{title}</h5>
        <p className="card-text">{description}</p>
        <div className="d-flex justify-content-between align-items-center">
          <button className="btn btn-success">Enroll</button>
          <span className="badge bg-info text-white">Free</span>
        </div>
      </div>
    </div>
  );
};

export default CourseCard;
