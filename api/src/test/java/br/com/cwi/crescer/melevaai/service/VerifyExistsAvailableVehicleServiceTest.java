package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableDomainVehiclesService;
import br.com.cwi.crescer.melevaai.validators.VehicleAvailableExistsValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class VerifyExistsAvailableVehicleServiceTest {

    @InjectMocks
    private VerifyExistsAvailableVehicleService subject;

    @Mock
    private ListAvailableDomainVehiclesService listAvailableDomainVehiclesService;

    @Mock
    private VehicleAvailableExistsValidator vehicleAvailableExistsValidator;

    @Test
    public void shouldValidateIfExistsSomeVehicleWhenVerify() {
        List<Vehicle> availableVehicles = Arrays.asList(Mockito.mock(Vehicle.class));

        Mockito.when(listAvailableDomainVehiclesService.list())
                .thenReturn(availableVehicles);

        subject.verify();

        Mockito.verify(listAvailableDomainVehiclesService).list();
        Mockito.verify(vehicleAvailableExistsValidator).validate(availableVehicles);
    }
}