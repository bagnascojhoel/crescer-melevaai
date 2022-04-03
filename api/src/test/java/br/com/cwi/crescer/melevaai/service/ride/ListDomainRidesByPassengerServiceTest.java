package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.passenger.FetchDomainPassengerByCpfService;
import br.com.cwi.crescer.melevaai.validators.ride.RideWithPassengerExistsValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class ListDomainRidesByPassengerServiceTest {

    @InjectMocks
    private ListDomainRidesByPassengerService subject;

    @Mock
    private RideWithPassengerExistsValidator rideWithPassengerExistsValidator;

    @Mock
    private RideRepository rideRepository;

    @Test
    public void shouldBeListWithFirstRideWithCorrectIdWhenList() {
        // arrange
        String cpf = "6";
        Ride ride = new Ride();
        Passenger passenger = new Passenger();
        passenger.setCpf(cpf);

        ride.setPassenger(passenger);

        Mockito.when(rideRepository.findAll())
                .thenReturn(Arrays.asList(ride));

        // act
        String actual = subject.list(cpf).get(0).getPassenger().getCpf();

        // assert
        Mockito.verify(rideRepository).findAll();
        Mockito.verify(rideWithPassengerExistsValidator).validate(Arrays.asList(ride));

        Assert.assertEquals(cpf, actual);
    }
}