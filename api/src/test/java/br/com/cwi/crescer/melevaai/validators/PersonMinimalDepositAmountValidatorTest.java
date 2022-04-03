package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class PersonMinimalDepositAmountValidatorTest {

    @InjectMocks
    private PersonMinimalDepositAmountValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithAmountGreaterThanMinimalDeposit() {
        BigDecimal amount = new BigDecimal("20");

        subject.validate(amount);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithAmountLesserThanMinimalDeposit() {
        BigDecimal amount = new BigDecimal("-5");

        subject.validate(amount);
    }

}