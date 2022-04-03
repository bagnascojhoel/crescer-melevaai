package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.domain.Person;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PersonMinimalWithdrawAmountValidator {
    public void validate(Person person, BigDecimal depositAmount) {
        if (person.getBalance().compareTo(depositAmount) == -1)
            throw new BusynessLogicException("Valor na carteira é inferior do necessáro");
    }
}
