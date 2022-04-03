import './styles.css';
import React from 'react';

export function InputSelect({
  onChange,
  onValidate,
  options,
  required,
  value,
  name,
  label,
  id,
}) {
  const _onChange = (event) => {
    const _value = event.target.value;
    onChange(_value);

    if (required) onValidate(true, name);
  };

  return (
    <div className="input-select">
      {label && (
        <label className="input-select__label" htmlFor={name}>
          {label}
        </label>
      )}

      <select
        className="input-select__input"
        onChange={_onChange}
        name={name}
        value={value}
        id={id}
      >
        <option defaultValue disabled>
          {label}
        </option>
        {options.map((opt) => (
          <option value={opt.value} key={opt.value}>
            {opt.text}
          </option>
        ))}
      </select>
    </div>
  );
}

InputSelect.defaultProps = {
  options: [],
};
