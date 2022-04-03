package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotFinishedYetValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RidePassengerScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class RatePassengerServiceTest {

    @InjectMocks
    private RatePassengerService subject;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideScoreValidator rideScoreValidator;

    @Mock
    private RidePassengerScoreValidator ridePassengerScoreValidator;

    @Mock
    private RideNotFinishedYetValidator rideNotFinishedYetValidator;

    @Mock
    private RideRepository rideRepository;

    @Test
    public void shouldMakeValidationsSetPassengerScoreAndUpdateAverageScoreWhenRate() {
        // arrange
        String cpf = "7";
        String id = "6";
        String score = "5";

        Ride ride = Mockito.spy(Ride.class);
        Passenger passenger = Mockito.spy(new Passenger());
        ride.setPassenger(passenger);

        Mockito.when(fetchRideByIdService.fetch(Long.parseLong(id)))
                .thenReturn(ride);

        // act
        subject.rate(id, score);

        // assert
        Mockito.verify(fetchRideByIdService).fetch(Long.parseLong(id));
        Mockito.verify(rideScoreValidator).validate(Integer.parseInt(score));
        Mockito.verify(ridePassengerScoreValidator).validate(ride);
        Mockito.verify(rideNotFinishedYetValidator).validate(ride);
        Mockito.verify(ride).setPassengerScore(Integer.parseInt(score));
        Mockito.verify(rideRepository).save(ride);
    }
}