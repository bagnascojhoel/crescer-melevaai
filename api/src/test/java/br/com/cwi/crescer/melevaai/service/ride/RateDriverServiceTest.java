package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideDriverScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotFinishedYetValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class RateDriverServiceTest {

    @InjectMocks
    private RateDriverService subject;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideScoreValidator rideScoreValidator;

    @Mock
    private RideDriverScoreValidator rideDriverScoreValidator;

    @Mock
    private RideNotFinishedYetValidator rideNotFinishedYetValidator;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private Point point;

    @Test
    public void shouldValidateAndSetDriverScoreWhenRate() {
        // arrange
        String id = "78";
        String score = "3";
        String cpf = "6";

        Ride ride = Mockito.spy(Ride.class);
        Vehicle vehicle = Mockito.spy(Vehicle.class);
        Driver driver = Mockito.spy(new Driver());
        vehicle.setId(Long.parseLong(id));
        vehicle.setOwner(driver);
        ride.setVehicle(vehicle);

        Mockito.when(fetchRideByIdService.fetch(Long.parseLong(id)))
                .thenReturn(ride);

        // act
        subject.rate(id, score);

        // assert
        Mockito.verify(fetchRideByIdService).fetch(Long.parseLong(id));
        Mockito.verify(rideScoreValidator).validate(Integer.parseInt(score));
        Mockito.verify(rideDriverScoreValidator).validate(ride);
        Mockito.verify(rideNotFinishedYetValidator).validate(ride);
        Mockito.verify(rideRepository).save(ride);
    }
}