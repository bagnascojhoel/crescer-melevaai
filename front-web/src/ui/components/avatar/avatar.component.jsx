import './styles.css';
import React from 'react';

export function Avatar({ url, side }) {
  return (
    <div
      className="avatar"
      style={{
        width: side,
        height: side,
        backgroundImage: `url("${url}")`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
      }}
    ></div>
  );
}

Avatar.defaultProps = {
  side: '60px',
};
