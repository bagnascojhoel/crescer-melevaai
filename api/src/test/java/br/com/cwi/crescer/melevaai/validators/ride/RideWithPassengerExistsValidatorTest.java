package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.validators.vehicle.VehicleHasOwnerValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RideWithPassengerExistsValidatorTest {

    @InjectMocks
    private RideWithPassengerExistsValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyList() {
        Ride ride = new Ride();

        subject.validate(Arrays.asList(ride));
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithEmptyList() {
        subject.validate(Arrays.asList());
    }

}