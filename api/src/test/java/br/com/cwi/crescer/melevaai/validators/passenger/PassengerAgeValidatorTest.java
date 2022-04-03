package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PassengerAgeValidatorTest {

    @InjectMocks
    private PassengerAgeValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithAgeGreaterThanTheMin() {
        subject.validate(17);
    }

    @Test
    public void shouldDoNothingWhenValidateWithAgeEqualThanTheMin() {
        subject.validate(16);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithAgeSmallerThanTheMin() {
        subject.validate(15);
    }

}