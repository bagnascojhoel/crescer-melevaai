package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PersonMinimalDepositAmountValidator {

    private static final BigDecimal MIN_DEPOSIT_AMOUNT = new BigDecimal("0");

    public void validate(BigDecimal depositAmount) {
        if (depositAmount.compareTo(MIN_DEPOSIT_AMOUNT) < 0)
            throw new BusynessLogicException("Valor do depósito deve ser maior que zero.");
    }
}
