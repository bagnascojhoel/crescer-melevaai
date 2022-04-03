package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideDoesNotExistValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FetchRideByIdServiceTest {

    @InjectMocks
    private FetchRideByIdService subject;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private RideDoesNotExistValidator rideDoesNotExistValidator;

    @Test
    public void shouldBeRideWithSameIdWhenFetch() {
        // arrange
        Long id = Long.getLong("1");
        Ride ride = new Ride();
        ride.setId(id);

        Mockito.when(rideRepository.findById(id))
                .thenReturn(Optional.of(ride));
        // act
        Ride actual = subject.fetch(id);

        // assert
        Mockito.verify(rideRepository).findById(id);
        Mockito.verify(rideDoesNotExistValidator).validate(Optional.of(ride));

        Assert.assertEquals(id, actual.getId());
    }
}