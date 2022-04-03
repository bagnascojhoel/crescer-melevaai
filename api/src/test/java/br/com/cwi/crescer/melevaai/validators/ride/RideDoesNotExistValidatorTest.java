package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
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
public class RideDoesNotExistValidatorTest {

    @InjectMocks
    private RideDoesNotExistValidator subject;

    private Ride ride;

    @Before
    public void setup() {
        ride = new Ride();
    }

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyRideOptional() {
        subject.validate(Optional.of(ride));
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowWhenValidateWithEmptyRideOptional() {
        subject.validate(Optional.empty());
    }

}