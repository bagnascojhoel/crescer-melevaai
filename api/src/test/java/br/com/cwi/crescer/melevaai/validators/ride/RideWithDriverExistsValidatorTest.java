package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RideWithDriverExistsValidatorTest {

    @InjectMocks
    private RideWithDriverExistsValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyList() {
        Ride ride = new Ride();

        subject.validate(Arrays.asList(ride));
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowWhenValidateWithEmptyList() {
        subject.validate(Arrays.asList());
    }

}