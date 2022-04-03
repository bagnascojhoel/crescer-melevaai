import './styles.css';
import React from 'react';
import { MdAdd } from 'react-icons/md';
import { COLORS } from '../../../styles';

export function SquareButton({ onClick, icon, iconSize }) {
  return (
    <button className="square-button" onClick={onClick}>
      <SquareButtonIcon icon={icon} size={iconSize} />
    </button>
  );
}

function SquareButtonIcon({ icon, size }) {
  return React.createElement(icon, {
    className: 'square-button__icon',
    color: COLORS.BLACK,
    size,
  });
}

SquareButton.defaultProps = {
  onClick: () => {},
  icon: MdAdd,
  iconSize: 30,
};
