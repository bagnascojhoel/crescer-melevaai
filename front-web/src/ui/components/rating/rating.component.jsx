import './styles.css';
import React from 'react';
import { StarGroup } from './star-group/star-group.component';

export function Rating({ onChange, value, ...props }) {
  const handleClick = (value) => onChange(value);

  return (
    <>
      <StarGroup onClick={handleClick} value={value} {...props} />
    </>
  );
}
