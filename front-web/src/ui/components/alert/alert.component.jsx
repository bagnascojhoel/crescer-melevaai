import './styles.css';
import React, { useEffect, useState } from 'react';
import { Modal, Button } from '../';

export function Alert({ onDismiss, error }) {
  const [visible, setVisible] = useState(!!error);

  useEffect(() => setVisible(!!error), [error]);

  const handleClick = () => {
    setVisible(false)
    onDismiss();
  };

  return (
    <Modal show={visible} contentClass="alert--error">
      <h3>{error}</h3>
      <Button onClick={handleClick}>Okay</Button>
    </Modal>
  );
}
