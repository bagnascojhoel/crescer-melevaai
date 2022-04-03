import './styles.css';
import React, { useEffect, useReducer, useState } from 'react';
import { usePassengerAPI } from '../../../hooks/passenger-api/passenger-api.hook';
import { PassengerForm } from './passenger-form/passenger-form.component';
import { Alert, DataList, LayoutContainer } from '../../components';
import { PassengerDataListItem } from './passenger-data-list-item/passenger-data-list-item.component';

export function PassengerScreen() {
  const API = usePassengerAPI();
  const [passengers, setPassengers] = useState([]);
  const [error, setError] = useState('');
  const [passenger, passengerDispatch] = useReducer(passengerReducer, {});
  const keyExtractor = ({ cpf }) => cpf;

  useEffect(() => updateList(), []);

  const updateList = async () => {
    const data = await API.getAllPassengers();
    setPassengers(data);
  };

  const handleSubmit = async () => {
    const { error } = await API.registerPassenger(passenger);

    if (error) setError(error);
    else updateList();
  };

  const handleDismiss = () => setError('');

  return (
    <LayoutContainer className="screen--row">
      <Alert error={error} onDismiss={handleDismiss}/>
      <DataList
        dataList={passengers}
        keyExtractor={keyExtractor}
        itemComponent={PassengerDataListItem}
      />
      <PassengerForm
        reducer={passengerReducer}
        dispatch={passengerDispatch}
        onSubmit={handleSubmit}
      />
    </LayoutContainer>
  );
}

function passengerReducer(state, action) {
  switch (action.type) {
    case 'cpf':
      return { ...state, cpf: action.payload };
    case 'name':
      return { ...state, name: action.payload };
    case 'email':
      return { ...state, email: action.payload };
    case 'birthDate':
      return { ...state, birthDate: action.payload };
    default:
      throw 'Invalid action type on passengerReducer';
  }
}
