package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyFinishedValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PassengerExistsValidatorTest {

    @InjectMocks
    private PassengerExistsValidator subject;

    private Passenger passenger;

    @Before
    public void setup() {
        passenger = new Passenger();
    }

    @Test
    public void shouldDoNothingWhenValidateWithEmptyOptional() {
        subject.validate(Optional.empty());
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithNonEmptyOptional() {
        subject.validate(Optional.of(passenger));
    }

}