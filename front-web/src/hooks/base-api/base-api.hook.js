import axios from 'axios';

export const API_CONTEXT = {
  RIDE: 'corridas',
  PASSENGER: 'passageiros',
  DRIVER: 'motoristas',
  VEHICLE: 'veiculos',
};

export function useBaseAPI(context, headers) {
  if (context && !contextExists(context)) throw 'Esse contexto não existe.';

  const contextPath = context ? `/${context}` : '';
  const baseAPI = axios.create({
    baseURL: `http://localhost:8100/me-leva-ai${contextPath}`,
    headers,
  });

  return baseAPI;
}

function contextExists(context) {
  const contextList = Object.values(API_CONTEXT);

  return contextList.some((c) => c === context);
}
