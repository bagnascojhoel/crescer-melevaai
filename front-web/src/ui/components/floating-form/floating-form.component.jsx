import './styles.css';
import React from 'react';
import { Button } from '../button/button.component';

export function FloatingForm({
  onSubmit,
  title,
  width,
  buttonText,
  valid,
  children,
}) {
  const _onSubmit = (event) => {
    event.preventDefault();

    if (valid) onSubmit();
  };

  return (
    <form onSubmit={_onSubmit} className="floating-form" style={{ width }}>
      {title && <h2>{title}</h2>}

      {children}
      <Button disabled={!valid} className="floating-form__button">
        {buttonText}
      </Button>
    </form>
  );
}

FloatingForm.defaultProps = {
  width: '35%',
  buttonText: 'Cadastrar',
  valid: true,
};
