import React, { useState } from 'react';
import { MdAttachMoney, MdDelete } from 'react-icons/md';
import { formatCPF, formatMoneyAsBRL } from '../../../../utils';
import { BalanceTransaction, SquareButton, TextWithTitle } from '../../../components';

export function DriverDataListItem({ data: driver, onDelete, onAddMoney }) {
  const [showAddToBalance, setShowAddToBalance] = useState(false);

  const _onShowAddToBalance = () => {
    setShowAddToBalance(true);
  };

  const _onDelete = () => {
    onDelete(driver.cpf);
  };

  const _onAddMoney = (money) => {
    setShowAddToBalance(false);
    if (money) onAddMoney(driver.cpf, money);
  };

  return (
    <>
      {showAddToBalance && <BalanceTransaction onAddMoney={_onAddMoney} />}
      <SquareButton onClick={_onShowAddToBalance} icon={MdAttachMoney} />
      <TextWithTitle title="Nome" text={driver.name} />
      <TextWithTitle title="CPF" text={formatCPF(driver.cpf)} />
      <TextWithTitle
        title="Saldo"
        text={formatMoneyAsBRL(driver.balance)}
      />
      <TextWithTitle title="Catgoria CNH" text={driver.cnh.category} />
      <SquareButton onClick={_onDelete} icon={MdDelete} />
    </>
  );
}
