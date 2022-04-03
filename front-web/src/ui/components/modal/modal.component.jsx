import './styles.css';
import React from 'react';

export function Modal({ show, contentClass, children }) {
  return (
    <aside className={`modal ${show && 'modal--visible'}`}>
      <div className={`modal__content ${contentClass}`}>{children}</div>
    </aside>
  );
}
