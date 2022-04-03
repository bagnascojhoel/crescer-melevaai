package br.com.cwi.crescer.melevaai.validators.vehicle;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class VehicleHasOwnerValidatorTest {

    @InjectMocks
    private VehicleHasOwnerValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithVehicleWithOwner() {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(new Driver());

        subject.validate(vehicle);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithVehicleWithNoOwner() {
        Vehicle vehicle = new Vehicle();

        subject.validate(vehicle);
    }

}