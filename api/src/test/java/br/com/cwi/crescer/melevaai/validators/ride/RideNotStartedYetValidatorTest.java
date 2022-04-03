package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RideNotStartedYetValidatorTest {

    @InjectMocks
    private RideNotStartedYetValidator subject;

    private Ride ride;

    @Before
    public void setup() {
        ride = new Ride();
    }

    @Test
    public void shouldDoNothingWhenValidateWithRideWithStatusDifferentFromChamada() {
        subject.validate(ride);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithRideWithStatusEqualChamada() {
        ride.setStatus(RideStatus.CHAMADA);
        subject.validate(ride);
    }

}