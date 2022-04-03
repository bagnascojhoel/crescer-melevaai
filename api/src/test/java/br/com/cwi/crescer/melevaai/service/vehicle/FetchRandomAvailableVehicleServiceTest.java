package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Plate;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.junit.Assert;
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
public class FetchRandomAvailableVehicleServiceTest {

    @InjectMocks
    private FetchRandomAvailableVehicleService subject;

    @Mock
    private ListAvailableDomainVehiclesService listAvailableDomainVehiclesService;

    @Test
    public void shouldReturnARandomAvailableVehicleWhenFetch() {
        Vehicle vehicle1 = new Vehicle();

        Vehicle vehicle2 = new Vehicle();

        List<Vehicle> availableVehicles = Arrays.asList(vehicle1, vehicle2);

        Mockito.when(listAvailableDomainVehiclesService.list())
            .thenReturn(availableVehicles);

        Vehicle actual = subject.fetch();

        Mockito.verify(listAvailableDomainVehiclesService).list();

        Assert.assertTrue(availableVehicles.contains(actual));
    }
}