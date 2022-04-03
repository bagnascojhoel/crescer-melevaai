package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.mapper.vehicle.ToVehicleResponseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MapToVehicleResponseListServiceTest {

    @InjectMocks
    private MapToVehicleResponseListService subject;

    @Mock
    private ToVehicleResponseMapper toVehicleResponseMapper;

    @Test
    public void shouldMapEveryItemOnTheListToVehicleResponseWhenMap() {
        Vehicle vehicle = Mockito.mock(Vehicle.class);

        Mockito.when(toVehicleResponseMapper.map(vehicle))
                .thenReturn(Mockito.mock(VehicleResponse.class));

        subject.map(Arrays.asList(vehicle));

        Mockito.verify(toVehicleResponseMapper).map(vehicle);
    }
}