package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class PersonCpfValidator {

    public void validate(String cpf) {

        if (cpf.isEmpty())
            throw new BusynessLogicException("O CPF é obrigatório.");

    }
}
