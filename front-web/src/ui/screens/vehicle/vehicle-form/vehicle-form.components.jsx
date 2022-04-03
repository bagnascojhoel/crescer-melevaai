import React, { useEffect, useState } from 'react';
import { useVehicleAPI } from '../../../../hooks';
import { mapToOption } from '../../../../utils';
import { FloatingForm, InputSelect, InputText } from '../../../components';

export function VehicleForm({ onSubmit, dispatch }) {
  const API = useVehicleAPI();
  const [brands, setBrands] = useState([]);
  const [colors, setColors] = useState([]);
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    (async () => {
      const brandsResponse = (await API.getBrands()) || [];
      const colorsResponse = (await API.getColors()) || [];
      const categoriesResponse = (await API.getCategories()) || [];

      setBrands(brandsResponse.map(mapToOption));
      setColors(colorsResponse.map(mapToOption));
      setCategories(categoriesResponse.map(mapToOption));
    })();
  }, []);

  return (
    <>
      <FloatingForm title="Cadastro veículo" onSubmit={onSubmit} valid={true}>
        <InputText
          label="CPF do proprietário"
          placeholder="123.456.789-00"
          name="ownerCpf"
          onChange={(v) => dispatch({ type: 'ownerCpf', payload: v })}
        />

        <InputText
          label="Placa"
          placeholder="AAAAC5"
          name="plate"
          onChange={(v) => dispatch({ type: 'plate', payload: v })}
        />

        <InputSelect
          options={brands}
          label="Marca"
          name="brand"
          onChange={(v) => dispatch({ type: 'brand', payload: v })}
        />

        <InputText
          label="Modelo"
          placeholder="Esportivo"
          name="model"
          onChange={(v) => dispatch({ type: 'model', payload: v })}
        />

        <InputText
          label="Ano"
          placeholder="1899"
          name="year"
          onChange={(v) => dispatch({ type: 'year', payload: v })}
        />

        <InputSelect
          options={colors}
          label="Cor"
          name="color"
          onChange={(v) => dispatch({ type: 'color', payload: v })}
        />

        <InputText
          label="Foto"
          placeholder="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
          name="photo"
          onChange={(v) => dispatch({ type: 'photo', payload: v })}
        />

        <InputSelect
          options={categories}
          label="Categoria"
          name="category"
          onChange={(v) => dispatch({ type: 'category', payload: v })}
        />

        <InputText
          label="Quantidade de lugares"
          type="number"
          placeholder="5"
          name="qtySeats"
          onChange={(v) => dispatch({ type: 'qtySeats', payload: v })}
        />
      </FloatingForm>
    </>
  );
}
