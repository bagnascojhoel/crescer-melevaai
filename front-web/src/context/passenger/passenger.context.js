import createGlobalState from 'react-create-global-state';

const [useGlobalPassenger, PassengerProvider] = createGlobalState(null);

export { useGlobalPassenger, PassengerProvider };
