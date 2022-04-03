import React, { useEffect, useReducer, useState } from 'react';
import { useVehicleAPI } from '../../../hooks';
import { Alert, DataList, LayoutContainer } from '../../components';
import { VehicleForm } from './vehicle-form/vehicle-form.components';
import { VehicleDataListItem } from './vehicle-data-list-item/vehicle-data-list-item.component';

export function VehicleScreen() {
  const API = useVehicleAPI();
  const [error, setError] = useState('');
  const [vehicles, setVehicles] = useState([]);
  const [vehicle, dispatch] = useReducer(vehicleReducer, {});
  const keyExtractor = (vehicle) => vehicle.plate;

  useEffect(() => updateList(), []);

  const updateList = async () => {
    const response = await API.getAllVehicles();
    setVehicles(response);
  };

  const handleSubmit = async () => {
    console.log(vehicle);
    const { error } = await API.registerVehicle(vehicle);
    if (error) setError(error);
    else updateList();
  };

  const handleDismiss = () => setError('');

  return (
    <LayoutContainer className="screen--row">
      <Alert error={error} onDismiss={handleDismiss} />
      <DataList
        dataList={vehicles}
        itemComponent={VehicleDataListItem}
        keyExtractor={keyExtractor}
      />
      <VehicleForm onSubmit={handleSubmit} dispatch={dispatch} />
    </LayoutContainer>
  );
}

function vehicleReducer(state, action) {
  switch (action.type) {
    case 'ownerCpf':
      return { ...state, ownerCpf: action.payload };
    case 'plate':
      return { ...state, plate: action.payload };
    case 'brand':
      return { ...state, brand: action.payload };
    case 'model':
      return { ...state, model: action.payload };
    case 'year':
      return { ...state, year: action.payload };
    case 'color':
      return { ...state, color: action.payload };
    case 'photo':
      return { ...state, photo: action.payload };
    case 'category':
      return { ...state, category: action.payload };
    case 'qtySeats':
      return { ...state, qtySeats: action.payload };
    default:
      throw 'Invalid action type on vehicleReducer';
  }
}
