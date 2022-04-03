import './styles.css';
import React from 'react';

export function TextWithTitle({ title, text, className }) {
  return (
    <div className={`text-with-title ${className}`}>
      <h3 className="text-with-title__title">
        <small>{title}</small>
      </h3>
      <h2 className={`text-with-title__text`}>{text}</h2>
    </div>
  );
}
