import React from 'react';
import { Rating, TextWithTitle } from '../../../components';

export function RideHistoryDataListItem({
  data: ride,
  onRatePassenger,
  onRateDriver,
}) {
  const _onRatePassenger = (score) => {
    onRatePassenger(ride.id, score);
  };

  const _onRateDriver = (score) => {
    onRateDriver(ride.id, score);
  };

  return (
    <>
      <TextWithTitle title="Identificador" text={ride.id} />

      <div className="ride-history-screen__rating-group">
        <Rating onClick={_onRatePassenger} value={ride.passengerScore} />
        <TextWithTitle title="Passageiro" text={ride.passenger} />
      </div>

      <div className="ride-history-screen__rating-group">
        <Rating onClick={_onRateDriver} value={ride.driverScore} />
        <TextWithTitle title="Motorista" text={ride.driver} />
      </div>
      <TextWithTitle title="Status" text={ride.status} />
    </>
  );
}
