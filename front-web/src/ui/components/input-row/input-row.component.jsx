import './styles.css';
import React from 'react';

export function InputRow({ label, children }) {
  return (
    <div className="input-row">
      {label && (
        <label htmlFor={children[0].props.name} className="input-row__label">
          {label}
        </label>
      )}

      <div className="input-row__items">
        {children.map((child, i) => (
          <span className="input-row__item" key={i}>{child}</span>
        ))}
      </div>
    </div>
  );
}
