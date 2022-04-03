import React, { useEffect, useReducer, useState } from 'react';
import { transformDate } from '../../../../utils';
import { FloatingForm, InputText } from '../../../components';

export function PassengerForm({ onSubmit, reducer, dispatch }) {
  const [isValidField, dispatchValidate] = useReducer(reducer, {});

  const handleValidate = (_isValid, type) => {
    dispatchValidate({ type, payload: _isValid });
  };

  return (
    <>
      <FloatingForm
        title="Cadastro passageiro"
        onSubmit={onSubmit}
      >
        <InputText
          required
          label="Nome"
          placeholder="José Luis"
          name="name"
          onChange={(v) => dispatch({ type: 'name', payload: v })}
          onValidate={handleValidate}
        />

        <InputText
          required
          label="Email"
          type="email"
          placeholder="example@gmail.com"
          name="email"
          onChange={(v) => dispatch({ type: 'email', payload: v })}
          onValidate={handleValidate}
        />

        <InputText
          required
          label="CPF"
          placeholder="123.456.789-00"
          name="cpf"
          onChange={(v) => dispatch({ type: 'cpf', payload: v })}
          onValidate={handleValidate}
          validate={() => true}
          errorMessage="CPF deve estar no formato correto."
        />

        <InputText
          required
          type="date"
          label="Data de nascimento"
          placeholder="01/01/2000"
          name="birthDate"
          onChange={(v) =>
            dispatch({ type: 'birthDate', payload: transformDate(v) })
          }
          onValidate={handleValidate}
        />
      </FloatingForm>
    </>
  );
}

