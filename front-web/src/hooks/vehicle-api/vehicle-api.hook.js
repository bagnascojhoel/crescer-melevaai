import { API_CONTEXT, useBaseAPI } from '../base-api/base-api.hook';


export function useVehicleAPI() {
  const baseAPI = useBaseAPI(API_CONTEXT.VEHICLE);

  const getAllVehicles = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all vehicles: "${err}"`);
    }
  };

  const registerVehicle = async (vehicle) => {
    try {
      const { data } = await baseAPI.post('/', vehicle);
      return data;
    } catch (err) {
      console.error(`Error while trying to register vehicle: "${err}"`);
      return {
        error: 'Não foi possível cadastrar veículo.',
      };
    }
  };

  const getCategories = async () => {
    try {
      const { data } = await baseAPI.get('/categorias');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all categories: "${err}"`);
    }
  };

  const getColors = async () => {
    try {
      const { data } = await baseAPI.get('/cores');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all colors: "${err}"`);
    }
  };

  const getBrands = async () => {
    try {
      const { data } = await baseAPI.get('/marcas');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all colors: "${err}"`);
    }
  };

  return {
    getAllVehicles,
    registerVehicle,
    getCategories,
    getColors,
    getBrands,
  };
}