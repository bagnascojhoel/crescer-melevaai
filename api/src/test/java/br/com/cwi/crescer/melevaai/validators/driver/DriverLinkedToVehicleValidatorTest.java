package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class DriverLinkedToVehicleValidatorTest {

    @InjectMocks
    private DriverLinkedToVehicleValidator subject;

    private Vehicle vehicle;

    @Before
    public void setup() {
        vehicle = new Vehicle();
    }

    @Test
    public void shouldDoNothingWhenValidateWithEmptyList() {
        subject.validate(Arrays.asList());
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithNonEmptyList() {
        subject.validate(Arrays.asList(vehicle));
    }

}