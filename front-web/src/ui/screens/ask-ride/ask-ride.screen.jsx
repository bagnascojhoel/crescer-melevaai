import './styles.css';
import React, { useReducer } from 'react';
import {
  FloatingForm,
  InputRow,
  InputText,
  LayoutContainer,
} from '../../components';
import { useRideAPI } from '../../../hooks';
import { useGlobalPassenger } from '../../../context';
import { useHistory } from 'react-router-dom';
import { ROUTES } from '../../../routes';

export function AskRideScreen() {
  const API = useRideAPI();
  const [globalPassenger] = useGlobalPassenger();
  const [origin, dispatchOrigin] = useReducer(pointReducer, {});
  const [destination, dispatchDestination] = useReducer(pointReducer, {});
  const history = useHistory();

  const handleSubmit = async () => {
    await API.requestRide(globalPassenger.cpf, origin, destination);
    history.push(ROUTES.ON_GOING_RIDES)
  };

  return (
    <LayoutContainer className="ask-ride-screen">
      <FloatingForm
        valid={true}
        onSubmit={handleSubmit}
        title="Chamar corrida"
        width="50%"
        buttonText="Chamar"
      >
        <InputRow label="Ponto inicial">
          <InputText
            required
            placeholder="X"
            name="x"
            type="number"
            onChange={(v) => dispatchOrigin({ type: 'x', payload: v })}
          />
          <InputText
            required
            placeholder="Y"
            name="y"
            type="number"
            onChange={(v) => dispatchOrigin({ type: 'y', payload: v })}
          />
        </InputRow>

        <InputRow label="Ponto final">
          <InputText
            required
            placeholder="X"
            name="x"
            type="number"
            onChange={(v) => dispatchDestination({ type: 'x', payload: v })}
          />
          <InputText
            required
            placeholder="Y"
            name="y"
            type="number"
            onChange={(v) => dispatchDestination({ type: 'y', payload: v })}
          />
        </InputRow>
      </FloatingForm>
    </LayoutContainer>
  );
}

function pointReducer(state, action) {
  if (action.type === 'x') return { ...state, x: action.payload };
  else if (action.type === 'y') return { ...state, y: action.payload };
  else throw 'Error while trying to request ride.';
}
