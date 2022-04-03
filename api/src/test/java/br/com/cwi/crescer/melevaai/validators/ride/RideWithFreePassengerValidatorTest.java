package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RideWithFreePassengerValidatorTest {

    @InjectMocks
    private RideWithFreePassengerValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithEmptyOptional() {
        subject.validate(Optional.empty());
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithNonEmptyOptional() {
        Ride ride = new Ride();

        subject.validate(Optional.of(ride));
    }

}