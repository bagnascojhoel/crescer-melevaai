import './styles.css';
import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import { ROUTES } from '../../../routes';
import { NavbarPassenger } from './navbar-passenger/navbar-passenger.component';
import { LayoutContainer } from '../';
import { useGlobalPassenger, useGlobalRide } from '../../../context';
import { usePassengerAPI } from '../../../hooks/';

export function Navbar() {
  const passengerAPI = usePassengerAPI();
  const [globalPassenger, setGlobalPassenger] = useGlobalPassenger();
  const [ride] = useGlobalRide();
  const { pathname } = useLocation();

  const handleAddMoney = async (money) => {
    const {balance} = await passengerAPI.addMoneyPassenger(globalPassenger.cpf, money);
    console.log(balance);
    setGlobalPassenger({...globalPassenger, balance});
  };

  if (ride) return <></>;

  return (
    <nav className="navbar">
      <LayoutContainer className="navbar-container">
        <ul className="navbar__list">
          <NavbarItem pathname={pathname} to={ROUTES.REQUEST_RIDE}>
            Chamar corrida
          </NavbarItem>

          <NavbarItem pathname={pathname} to={ROUTES.PASSENGER}>
            Passageiros
          </NavbarItem>

          <NavbarItem pathname={pathname} to={ROUTES.DRIVER}>
            Motoristas
          </NavbarItem>

          <NavbarItem pathname={pathname} to={ROUTES.VEHICLE}>
            Veículos
          </NavbarItem>

          <NavbarItem pathname={pathname} to={ROUTES.PASSENGER_RIDE_HISTORY}>
            Histórico de corridas
          </NavbarItem>

          <NavbarItem pathname={pathname} to={ROUTES.ON_GOING_RIDES}>
            Corridas em andamento
          </NavbarItem>
        </ul>
        {!globalPassenger ? null : (
          <NavbarPassenger
            balance={globalPassenger.balance}
            name={globalPassenger.name}
            onAddMoney={handleAddMoney}
          />
        )}
      </LayoutContainer>
    </nav>
  );
}

function NavbarItem({ to, pathname, children }) {
  const active = pathname === to;
  const activeClassName = active && 'navbar__list-item--active';
  return (
    <li className={`navbar__list-item ${activeClassName}`}>
      <Link className="navbar__list-item__content" to={to}>
        {children}
      </Link>
    </li>
  );
}
