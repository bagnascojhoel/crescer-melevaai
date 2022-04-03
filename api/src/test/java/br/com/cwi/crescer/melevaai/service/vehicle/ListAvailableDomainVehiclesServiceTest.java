package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.service.ride.ListDomainOnGoingRidesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class ListAvailableDomainVehiclesServiceTest {

    @InjectMocks
    private ListAvailableDomainVehiclesService subject;

    @Mock
    private ListDomainOnGoingRidesService listDomainOnGoingRidesService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldBeAListOfVehiclesNotOnOnGoingRideWhenList() {
        Ride ride = Mockito.mock(Ride.class);
        Vehicle vehicle = Mockito.mock(Vehicle.class);

        Mockito.when(listDomainOnGoingRidesService.list())
                .thenReturn(Arrays.asList(ride));
        Mockito.when(vehicleRepository.findAll())
                .thenReturn(Arrays.asList(vehicle));

        subject.list();

        Mockito.verify(listDomainOnGoingRidesService).list();
        Mockito.verify(vehicleRepository).findAll();
    }
}