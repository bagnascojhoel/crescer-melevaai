package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
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
public class ListVehiclesServiceTest {

    @InjectMocks
    private ListVehiclesService subject;

    @Mock
    private MapToVehicleResponseListService mapToVehicleResponseListService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldBeAllVehiclesFromRepositoryAsResponseWhenList() {
        List<Vehicle> vehicles = Arrays.asList(Mockito.mock(Vehicle.class));

        Mockito.when(vehicleRepository.findAll())
                .thenReturn(vehicles);
        Mockito.when(mapToVehicleResponseListService.map(vehicles))
                .thenReturn(Arrays.asList(Mockito.mock(VehicleResponse.class)));

        subject.list();

        Mockito.verify(vehicleRepository).findAll();
        Mockito.verify(mapToVehicleResponseListService).map(vehicles);
    }
}