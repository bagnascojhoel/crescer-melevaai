import './styles.css';
import React, { useState } from 'react';

export function InputText({
  onChange,
  onValidate,
  label,
  placeholder,
  name,
  value,
  type,
  required,
  errorMessage,
  validate,
  noMargin,
  min,
}) {
  const [error, setError] = useState('');

  const handleBlur = (event) => {
    const value = event.target.value;

    if (required && !value) {
      setError('Este campo não pode ser vazio!');
      onValidate(false, name);
    } else if (validate && !validate(value)) {
      setError(errorMessage);
      onValidate(false, name);
    } else {
      setError('');
      onValidate(true, name);
    }
  };

  const _onChange = (event) => {
    onChange(event.target.value);
  };

  return (
    <div className={`input-text ${noMargin && 'input-text--no-margin'}`}>
      {label && (
        <label className="input-text__label" htmlFor={name}>
          {label}
        </label>
      )}

      <input
        className={`input-text__input ${error && 'input-text__input--error'}`}
        onChange={_onChange}
        onBlur={handleBlur}
        type={type}
        placeholder={placeholder}
        name={name}
        id={name}
        value={value}
        min={min}
      />
      <span className="input-text__error">{error}</span>
    </div>
  );
}

InputText.defaultProps = {
  onBlur: () => {},
  onValidate: () => true,
  type: 'text',
};
