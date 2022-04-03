import './styles.css';
import React from 'react';
import { MdStar, MdStarBorder } from 'react-icons/md';

export function Star({ active, size, color, onClick, onMouseOver, value }) {
  const _onClick = () => onClick(value);
  const _onMouseOver = () => onMouseOver(value);

  return (
    <button
      className={`rating__star`}
      onClick={_onClick}
      onMouseOver={_onMouseOver}
    >
      {active ? (
        <MdStar color={color} size={size} />
      ) : (
        <MdStarBorder color={color} size={size} />
      )}
    </button>
  );
}

Star.defaultProps = {
  onMouseOver: () => {},
  onClick: () => {},
};
