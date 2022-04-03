package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DriverDoesNotExistValidatorTest {

    @InjectMocks
    private DriverDoesNotExistValidator subject;

    private Driver driver;

    @Before
    public void setup() {
        driver = new Driver();
    }

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyOptional() {
        subject.validate(Optional.of(driver));
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowWhenValidateWithEmptyOptional() {
        subject.validate(Optional.empty());
    }

}