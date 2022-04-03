package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListAvailableVehiclesServiceTest {

    @InjectMocks
    private ListAvailableVehiclesService subject;

    @Mock
    private MapToVehicleResponseListService mapToVehicleResponseListService;

    @Mock
    private ListAvailableDomainVehiclesService listAvailableDomainVehiclesService;

    @Test
    public void shouldBeAllVehiclesFromAvailableDomainVehiclesServiceAsResponseWhenList() {
        List<Vehicle> availableVehicles = Arrays.asList(Mockito.mock(Vehicle.class));
        List<VehicleResponse> availableVehicleResponses = Arrays.asList(Mockito.mock(VehicleResponse.class));

        Mockito.when(listAvailableDomainVehiclesService.list())
                .thenReturn(availableVehicles);
        Mockito.when(mapToVehicleResponseListService.map(availableVehicles))
                .thenReturn(availableVehicleResponses);

        subject.list();

        Mockito.verify(listAvailableDomainVehiclesService).list();
        Mockito.verify(mapToVehicleResponseListService).map(availableVehicles);
    }
}