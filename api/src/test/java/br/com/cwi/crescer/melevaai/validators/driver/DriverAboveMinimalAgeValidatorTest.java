package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class DriverAboveMinimalAgeValidatorTest {

    @InjectMocks
    private DriverAboveMinimalAgeValidator subject;

    private Driver driver;

    @Before
    public void setup() {
        driver = new Driver();
    }

    @Test
    public void shouldDoNothingWhenValidateWithDriverWithAgeGreaterThanEighteen() {
        driver.setBirthDate(LocalDate.now().minusYears(19));
        subject.validate(driver);
    }

    @Test
    public void shouldDoNothingWhenValidateWithDriverWithAgeEqualsEighteen() {
        driver.setBirthDate(LocalDate.now().minusYears(18));
        subject.validate(driver);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithAgeSmallerThanEighteen() {
        driver.setBirthDate(LocalDate.now().minusYears(17));
        subject.validate(driver);
    }

}