import './App.css';
import { Redirect, Route, Switch } from 'react-router-dom';
import { useGlobalPassenger, useGlobalRide } from './context';
import { Navbar } from './ui/components';
import { ROUTES } from './routes';
import {
  AskRideScreen,
  DriverScreen,
  OnGoingRidesScreen,
  PassengerScreen,
  RideHistoryScreen,
  VehicleScreen,
} from './ui/screens';

export default function App() {
  return (
    <>
      <Navbar />
      <Switch>
        <Route path={ROUTES.HOME} exact>
          <Redirect to={ROUTES.REQUEST_RIDE} />
        </Route>

        <HasPassengerRoute path={ROUTES.REQUEST_RIDE} exact>
          <AskRideScreen />
        </HasPassengerRoute>

        <HasPassengerRoute path={ROUTES.PASSENGER_RIDE_HISTORY}>
          <RideHistoryScreen />
        </HasPassengerRoute>

        <Route path={ROUTES.ON_GOING_RIDES}>
          <OnGoingRidesScreen />
        </Route>

        <Route path={ROUTES.PASSENGER}>
          <PassengerScreen />
        </Route>

        <Route path={ROUTES.DRIVER}>
          <DriverScreen />
        </Route>

        <Route path={ROUTES.VEHICLE}>
          <VehicleScreen />
        </Route>
      </Switch>
    </>
  );
}

function HasPassengerRoute({ path, children }) {
  const [passenger] = useGlobalPassenger();

  if (!passenger) return <Redirect to={ROUTES.PASSENGER} />;
  else return <Route path={path}>{children}</Route>;
}

function HasRideRoute({ path, children }) {
  const [ride] = useGlobalRide();

  if (!ride) return <Redirect to={ROUTES.HOME} />;
  else return <Route path={path}>{children}</Route>;
}
