package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.driver.ListDomainDriversService;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyFinishedValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotStartedYetValidator;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class FinishRideServiceTest {

    @InjectMocks
    private FinishRideService subject;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideNotStartedYetValidator rideNotStartedYetValidator;

    @Mock
    private RideAlreadyFinishedValidator rideAlreadyFinishedValidator;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private Driver owner;

    @Test
    public void shouldMakeTransactionsWhenFinish() {
        // arrange
        String id = "7";
        BigDecimal price = new BigDecimal("15.2");

        Ride ride = Mockito.spy(Ride.class);
        Passenger passenger = Mockito.spy(Passenger.class);
        passenger.setBalance(new BigDecimal("20"));
        ride.setId(Long.getLong(id));
        ride.setPassenger(passenger);
        ride.setStartTime(LocalDateTime.now());

        ride.setVehicle(Mockito.mock(Vehicle.class));

        Mockito.when(fetchRideByIdService.fetch(Long.parseLong(id))).thenReturn(ride);

        Mockito.when(ride.getPrice()).thenReturn(price);

        Mockito.when(ride.getVehicle().getOwner()).thenReturn(owner);
        // act
        subject.finish(id);

        // assert
        Mockito.verify(fetchRideByIdService).fetch(Long.parseLong(id));
        Mockito.verify(rideNotStartedYetValidator).validate(ride);
        Mockito.verify(rideAlreadyFinishedValidator).validate(ride);
        Mockito.verify(ride).setEndTime(Mockito.any());
        Mockito.verify(ride).setPrice(Mockito.any());
        Mockito.verify(passenger).withdraw(price);
        Mockito.verify(owner).deposit(price);
        Mockito.verify(ride).setStatus(RideStatus.FINALIZADA);
        Mockito.verify(rideRepository).save(ride);

    }
}