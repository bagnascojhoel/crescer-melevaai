import './index.css';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import { PassengerProvider, RideProvider } from './context';
import App from './App';

ReactDOM.render(
  <BrowserRouter>
    <PassengerProvider>
      <RideProvider>
        <App />
      </RideProvider>
    </PassengerProvider>
  </BrowserRouter>,
  document.getElementById('root')
);
