import React, { useEffect, useState } from 'react';
import { useVehicleAPI } from '../../../../hooks';
import { FloatingForm, InputSelect, InputText } from '../../../components';
import { mapToOption, transformDate } from '../../../../utils';

export function DriverForm({ onSubmit, dispatch }) {
  const vehicleAPI = useVehicleAPI();
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    (async () => {
      const response = await vehicleAPI.getCategories() || [];

      setCategories(response.map(mapToOption));
    })();
  }, []);

  return (
    <>
      <FloatingForm title="Cadastro motorista" onSubmit={onSubmit} valid={true}>
        <InputText
          label="Nome"
          placeholder="José Luis"
          name="name"
          onChange={(v) => dispatch({ type: 'name', payload: v })}
        />

        <InputText
          type="email"
          label="Email"
          placeholder="example@gmail.com"
          name="email"
          onChange={(v) => dispatch({ type: 'email', payload: v })}
        />

        <InputText
          label="CPF"
          placeholder="123.456.789-00"
          name="cpf"
          onChange={(v) => dispatch({ type: 'cpf', payload: v })}
        />

        <InputText
          type="date"
          label="Data de nascimento"
          placeholder="01/01/2000"
          name="birthDate"
          onChange={(v) =>
            dispatch({ type: 'birthDate', payload: transformDate(v) })
          }
        />

        <h4>CNH</h4>

        <InputText
          label="Número"
          placeholder="123456789"
          name="cnhNumber"
          onChange={(v) => dispatch({ type: 'cnhNumber', payload: v })}
        />

        <InputSelect
          options={categories}
          label="Categoria"
          name="cnhCategory"
          onChange={(v) => dispatch({ type: 'cnhCategory', payload: v })}
        />

        <InputText
          type="date"
          label="Data de vencimento"
          placeholder="01/01/2050"
          name="cnhDueDate"
          onChange={(v) =>
            dispatch({ type: 'cnhDueDate', payload: transformDate(v) })
          }
        />
      </FloatingForm>
    </>
  );
}
