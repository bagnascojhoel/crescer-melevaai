package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PassengerDepositAmountValidatorTest {

    @InjectMocks
    private PassengerDepositAmountValidator subject;

    private Passenger passenger;

    @Before
    public void setup() {
        passenger = new Passenger();
    }

    @Test
    public void shouldDoNothingWhenValidateWithAmountGreaterThanTheMin() {
        subject.validate(BigDecimal.valueOf(2));
    }

    @Test
    public void shouldDoNothingWhenValidateWithAmountEqualTheMin() {
        subject.validate(BigDecimal.valueOf(0));
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithAmountSmallerThanTheMin() {
        subject.validate(BigDecimal.valueOf(-1));
    }

}