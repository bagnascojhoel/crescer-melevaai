package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class RideScoreValidatorTest {

    @InjectMocks
    private RideScoreValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithScoreThree() {
        subject.validate(3);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithScoreSix() {
        subject.validate(6);
    }

}