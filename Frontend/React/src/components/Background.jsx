// BackgroundImage.js
import React from 'react';


const Background = ({ imageUrl, children }) => {
  const style = {
    backgroundImage: `url("${imageUrl}")`, // wrap the url in double quotes.
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
    height: '100vh',
    
  };

  return (
    <div style={style}>
      {children}
    </div>
  );
};

export default Background;
