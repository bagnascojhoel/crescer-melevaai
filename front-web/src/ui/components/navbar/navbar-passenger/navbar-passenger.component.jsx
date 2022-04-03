import './styles.css';
import React, { useState } from 'react';
import { SquareButton, TextWithTitle } from '../../';
import { SPACING } from '../../../../styles';
import { MdAttachMoney } from 'react-icons/md';
import { BalanceTransaction } from '../../balance-transaction/balance-transaction.component';
import { formatMoneyAsBRL } from '../../../../utils';

export function NavbarPassenger({
  name,
  balance,
  onAddMoney,
}) {
  const [showAddBalance, setShowAddBalance] = useState(false);

  const handleClick = () => {
    setShowAddBalance(true);
  };

  const _onAddMoney = (money) => {
    setShowAddBalance(false);
    if (money) onAddMoney(money);
  };

  return (
    <div className="navbar-info">
      <div className="navbar-info__content">
        <span style={{ marginRight: SPACING.SMALL_GUTTER }}>
          <TextWithTitle primaryText text={name} title="Passageiro" />
        </span>

        <TextWithTitle
          primaryText
          text={formatMoneyAsBRL(balance)}
          title="Saldo"
        />
      </div>
      <span style={{ marginLeft: SPACING.SMALL_GUTTER }}>
        <SquareButton
          onClick={handleClick}
          iconSize={30}
          icon={MdAttachMoney}
        />
      </span>

      {showAddBalance && <BalanceTransaction onAddMoney={_onAddMoney} />}
    </div>
  );
}
