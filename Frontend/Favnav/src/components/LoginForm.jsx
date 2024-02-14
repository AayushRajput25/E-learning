import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function LoginForm() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const userData = {
      email: email,
      password: password
    };
    console.log(userData);
    setEmail("");
    setPassword("");
    // Abhi k liye data console pe print 
  };

  return (
    <div className="container mt-4" style={{ maxWidth: '400px' }}>
      <div className="card p-3 shadow">
        <h2 className="mb-3">Login</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">Email:</label>
            <input
              type="email"
              className="form-control"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label">Password:</label>
            <input
              type="password"
              className="form-control"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary mb-3">Submit</button>
        </form>
        <p className="mb-0">Not a member? <Link to='/student_signup'>Sign up</Link></p>
      </div>
    </div>
  );
}

export default LoginForm;
