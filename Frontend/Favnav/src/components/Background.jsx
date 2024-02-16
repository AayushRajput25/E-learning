// BackgroundImage.js
import React from 'react';

const Background = ({ imageUrl, children }) => {
  const style = {
    backgroundImage: `url("${imageUrl}")`, // Wrap the URL in double quotes
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
    height: '100vh',
    // Add more styling properties based on your requirements
  };

  return (
    <div style={style}>
      {children}
    </div>
  );
};

export default Background;
