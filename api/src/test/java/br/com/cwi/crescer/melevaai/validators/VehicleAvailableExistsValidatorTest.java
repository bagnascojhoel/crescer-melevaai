package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VehicleAvailableExistsValidatorTest {

    @InjectMocks
    private VehicleAvailableExistsValidator subject;

    @Mock
    private Vehicle vehicle;

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyList() {
        List<Vehicle> vehicles = Arrays.asList(vehicle);

        subject.validate(vehicles);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithEmptyList() {
        subject.validate(Arrays.asList());
    }

}