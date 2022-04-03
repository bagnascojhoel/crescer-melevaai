import { API_CONTEXT, useBaseAPI } from '../base-api/base-api.hook';

export function useDriverAPI() {
  const baseAPI = useBaseAPI(API_CONTEXT.DRIVER);

  const getAllDrivers = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all drivers: "${err}"`);
    }
  };

  const deleteDriverByCPF = async (CPF) => {
    try {
      const { data } = await baseAPI.delete(`/${CPF}`);
      return data;
    } catch (err) {
      console.error(`Error while trying to delete driver by CPF: "${err}"`);
    }
  };

  const registerDriver = async (driver) => {
    try {
      const { data } = await baseAPI.post('/', driver);
      return data;
    } catch (err) {
      console.error(`Error while trying to register driver: "${err}"`);
      return { error: 'Não foi possível cadastrar motorista.' };
    }
  };

  const withdrawMoneyDriver = async (driverCPF, money) => {
    try {
      const { data } = await baseAPI.put(
        `/${driverCPF}/conta-virtual?valor=${money}`
      );
      return data;
    } catch (err) {
      console.error(
        `Error while trying to withdraw money from the driver: "${err}"`
      );
    }
  };

  return {
    getAllDrivers,
    deleteDriverByCPF,
    registerDriver,
    withdrawMoneyDriver,
  };
}