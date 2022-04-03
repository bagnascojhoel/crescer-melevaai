package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DriverWithdrawAmountValidatorTest {

    @InjectMocks
    private DriverWithdrawAmountValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithAmountGreaterThanZero() {
        subject.validate(BigDecimal.valueOf(15));
    }

    @Test
    public void shouldDoNothingWhenValidateWithAmountEqualsZero() {
        subject.validate(BigDecimal.valueOf(0));
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithAmountSmallerThanZero() {
        subject.validate(BigDecimal.valueOf(-1));
    }

}