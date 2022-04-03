package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonMinimalWithdrawAmountValidatorTest {

    @InjectMocks
    private PersonMinimalWithdrawAmountValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithAmountSmallerThanPersonBalance() {
        BigDecimal amount = new BigDecimal("20");
        Passenger passenger = new Passenger();
        passenger.setBalance(BigDecimal.valueOf(20));

        subject.validate(passenger, amount);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithAmountGreaterThanPersonBalance() {
        BigDecimal amount = new BigDecimal("21");
        Passenger passenger = new Passenger();
        passenger.setBalance(BigDecimal.valueOf(20));

        subject.validate(passenger, amount);
    }

}