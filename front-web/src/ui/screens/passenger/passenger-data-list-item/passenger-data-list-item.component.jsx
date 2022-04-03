import React from 'react';
import { MdArrowForward } from 'react-icons/md';
import { useGlobalPassenger } from '../../../../context';
import { formatCPF } from '../../../../utils';
import { SquareButton, TextWithTitle } from '../../../components';

export function PassengerDataListItem({ data: passenger }) {
  const [_, setGlobalPassenger] = useGlobalPassenger();

  const handleClick = () => {
    setGlobalPassenger(passenger);
  };

  return (
    <>
      <TextWithTitle title="Nome" text={passenger.name} />
      <TextWithTitle title="CPF" text={formatCPF(passenger.cpf)} />
      <TextWithTitle title="Email" text={passenger.email} />
      <TextWithTitle title="Data nascimento" text={passenger.birthDate} />
      <SquareButton onClick={handleClick} icon={MdArrowForward} />
    </>
  );
}
