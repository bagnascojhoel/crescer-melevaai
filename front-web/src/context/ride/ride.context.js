import createGlobalState from 'react-create-global-state';

const [useGlobalRide, RideProvider] = createGlobalState(null);

export { useGlobalRide, RideProvider };
