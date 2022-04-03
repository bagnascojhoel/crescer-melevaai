package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
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
public class RideAlreadyStartedValidatorTest {

    @InjectMocks
    private RideAlreadyStartedValidator subject;

    private Ride ride;

    @Before
    public void setup() {
        ride = new Ride();
    }

    @Test
    public void shouldDoNothingWhenValidateWithRideWithStatusChamada() {
        ride.setStatus(RideStatus.CHAMADA);
        subject.validate(ride);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithRideWithStatusDifferentFromChamada() {
        ride.setStatus(RideStatus.INICIADA);
        subject.validate(ride);
    }

}