import './styles.css';
import React, { useEffect, useState } from 'react';
import { useGlobalPassenger } from '../../../context';
import { useRideAPI } from '../../../hooks';
import { DataList, LayoutContainer } from '../../components';
import { RideHistoryDataListItem } from './ride-history-data-list-item/ride-history-data-list-item.component';

export function RideHistoryScreen() {
  const API = useRideAPI();
  const [globalPassenger] = useGlobalPassenger();
  const [ridesHistory, setRidesHistory] = useState([]);
  const keyExtractor = ({ id }) => id;

  useEffect(() => updateList(), []);

  const updateList = async () => {
    const rides = await API.getRideHistoryByCPF(globalPassenger.cpf);
    setRidesHistory([]);
    setRidesHistory(rides);
  };

  const handleRatePassenger = async (rideID, score) => {
    await API.ratePassenger(rideID, score);
    updateList();
  };

  const handleRateDriver = async (rideID, score) => {
    await API.rateDriver(rideID, score);
    updateList();
  };

  return (
    <LayoutContainer>
      <DataList
        itemComponent={RideHistoryDataListItem}
        dataList={ridesHistory}
        keyExtractor={keyExtractor}
        onRatePassenger={handleRatePassenger}
        onRateDriver={handleRateDriver}
      />
    </LayoutContainer>
  );
}
