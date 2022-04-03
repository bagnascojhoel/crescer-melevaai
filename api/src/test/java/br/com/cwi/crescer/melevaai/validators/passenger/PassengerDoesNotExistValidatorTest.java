package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PassengerDoesNotExistValidatorTest {

    @InjectMocks
    private PassengerDoesNotExistValidator subject;

    private Passenger passenger;

    @Before
    public void setup() {
        passenger = new Passenger();
    }

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyOptional() {
        subject.validate(Optional.of(passenger));
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowWhenValidateWithEmptyOptional() {
        subject.validate(Optional.empty());
    }

}