import React, { useState } from 'react';
import { COLORS } from '../../../../styles';
import { Star } from '../star/star.component';

export function StarGroup({
  onClick,
  max,
  iconColor,
  iconSize,
  value,
  className,
}) {
  const [visibleValue, setVisibleValue] = useState(value);

  const handleClick = (v) => onClick(v);
  const handleMouseOver = (v) => setVisibleValue(v);
  const handleMouseLeave = () => setVisibleValue(value);

  const result = [];
  for (let i = 1; i <= max; i++)
    result.push(
      <Star
        key={i}
        value={i}
        active={i <= visibleValue}
        size={iconSize}
        color={iconColor}
        onClick={handleClick}
        onMouseOver={handleMouseOver}
      />
    );

  return (
    <div className={className} onMouseLeave={handleMouseLeave}>
      {result}
    </div>
  );
}

StarGroup.defaultProps = {
  onMouseOver: () => {},
  onClick: () => {},
  iconColor: COLORS.GRAY,
  iconSize: 36,
  max: 5,
};
