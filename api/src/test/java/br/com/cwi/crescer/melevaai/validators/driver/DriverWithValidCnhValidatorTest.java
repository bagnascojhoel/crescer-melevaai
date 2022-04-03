package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerAgeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class DriverWithValidCnhValidatorTest {

    @InjectMocks
    private DriverWithValidCnhValidator subject;

    private Driver driver;

    private CNH cnh;

    @Before
    public void setup() {
        cnh = new CNH();
        driver = new Driver();
        driver.setCnh(cnh);
    }

    @Test
    public void shouldDoNothingWhenValidateWithDriverWithNotExpiredCnh() {
        cnh.setDueDate(LocalDate.now().plusMonths(1));
        subject.validate(driver);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithDriverWithExpiredCnh() {
        cnh.setDueDate(LocalDate.now());
        subject.validate(driver);
    }

}