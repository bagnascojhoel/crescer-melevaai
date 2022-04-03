package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class RidePassengerScoreValidatorTest {

    @InjectMocks
    private RidePassengerScoreValidator subject;

    private Ride ride;

    @Before
    public void setup() {
        ride = new Ride();
    }

    @Test
    public void shouldDoNothingWhenValidateWithRideWithPassengerScoreEqualZero() {
        subject.validate(ride);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithRideWithPassengerScoreDifferentThanZero() {
        ride.setPassengerScore(3);
        subject.validate(ride);
    }

}