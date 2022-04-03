import './styles.css';
import React from 'react';

export function LayoutContainer({ className, children }) {
  return <div className={`layout-container ${className}`}>{children}</div>;
}
