package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
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
public class DriverAlreadyExistsValidatorTest {

    @InjectMocks
    private DriverAlreadyExistsValidator subject;

    private Driver driver;

    @Before
    public void setup() {
        driver = new Driver();
    }

    @Test
    public void shouldDoNothingWhenValidateWithEmptyOptional() {
        subject.validate(Optional.empty());
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithNonEmptyOptional() {
        subject.validate(Optional.of(driver));
    }

}