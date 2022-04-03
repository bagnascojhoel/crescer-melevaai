import React, { useEffect, useReducer, useState } from 'react';
import { MdDelete } from 'react-icons/md';
import { useDriverAPI } from '../../../hooks';
import {
  Alert,
  DataList,
  LayoutContainer,
  SquareButton,
  TextWithTitle,
} from '../../components';
import { DriverDataListItem } from './driver-data-list-item/driver-data-list-item.component';
import { DriverForm } from './driver-form/driver-form.component';

export function DriverScreen() {
  const API = useDriverAPI();
  const [drivers, setDrivers] = useState([]);
  const [error, setError] = useState('');
  const [driver, driverDispatch] = useReducer(driverReducer, {});
  const keyExtractor = (data) => data.cpf;

  useEffect(() => updateList(), []);

  const updateList = async () => {
    const data = await API.getAllDrivers();
    setDrivers(data);
  };

  const handleSubmit = async () => {
    const { error } = await API.registerDriver(driver);

    if (error) setError(error);
    else updateList();
  };

  const handleDismiss = () => setError('');

  const handleDelete = async (driverCPF) => {
    await API.deleteDriverByCPF(driverCPF);
    updateList();
  };

  const handleAddMoney = async (driverCPF, money) => {
    await API.withdrawMoneyDriver(driverCPF, money);
    updateList();
  };

  return (
    <LayoutContainer className="screen--row">
      <Alert error={error} onDismiss={handleDismiss} />
      <DataList
        dataList={drivers}
        keyExtractor={keyExtractor}
        itemComponent={DriverDataListItem}
        onDelete={handleDelete}
        onAddMoney={handleAddMoney}
      />
      <DriverForm
        dispatch={driverDispatch}
        reducer={driverReducer}
        onSubmit={handleSubmit}
      />
    </LayoutContainer>
  );
}

function driverReducer(state, action) {
  switch (action.type) {
    case 'cnhNumber':
      return { ...state, cnh: { ...state.cnh, number: action.payload } };
    case 'cnhDueDate':
      return { ...state, cnh: { ...state.cnh, dueDate: action.payload } };
    case 'cnhCategory':
      return { ...state, cnh: { ...state.cnh, category: action.payload } };
    case 'cpf':
      return { ...state, cpf: action.payload };
    case 'name':
      return { ...state, name: action.payload };
    case 'email':
      return { ...state, email: action.payload };
    case 'birthDate':
      return { ...state, birthDate: action.payload };
    default:
      throw 'Invalid action type on driverReducer';
  }
}
