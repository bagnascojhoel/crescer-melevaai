package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PassengerDepositAmountValidator {

    private static final BigDecimal MIN_AMOUNT = new BigDecimal("0");

    public void validate(BigDecimal amount) {
        if (amount.compareTo(MIN_AMOUNT) == -1)
            throw new BusynessLogicException("Não é possível adicionar um valor negativo.");
    }
}
