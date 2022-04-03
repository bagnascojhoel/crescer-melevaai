import React, { useState } from 'react';
import { Modal } from '..';
import { InputText, SquareButton } from '..';
import { InputRow } from '../input-row/input-row.component';

export function BalanceTransaction({ onAddMoney }) {
  const [money, setMoney] = useState(0);

  const handleChange = (v) => {
    setMoney(v);
  };

  const _onAddMoney = () => {
    if (money >= 0) onAddMoney(money);
  };

  return (
    <Modal show={true}>
      <InputRow>
        <InputText
          onChange={handleChange}
          type="number"
          placeholder="R$ 10,00"
          min="0"
          noMargin
        />
        <SquareButton onClick={_onAddMoney} iconSize={23} />
      </InputRow>
    </Modal>
  );
}
