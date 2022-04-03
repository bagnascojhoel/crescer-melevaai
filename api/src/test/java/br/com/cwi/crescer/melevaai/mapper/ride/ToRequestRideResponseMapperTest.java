package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ToRequestRideResponseMapperTest {

    @InjectMocks
    private ToRequestRideResponseMapper subject;

    @Test
    public void shouldMapToRequestRideResponseCorrectly() {
        Long id = Long.parseLong("59");

        Vehicle vehicle = new Vehicle();
        vehicle.setId(id + 1);

        Ride ride = new Ride();
        ride.setId(id);
        ride.setVehicle(vehicle);

        RequestRideResponse expected = new RequestRideResponse(id, vehicle.getId(), 0);

        RequestRideResponse actual = subject.map(ride);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getVehicleId(), actual.getVehicleId());
        Assert.assertNotNull(actual.getPickupDuration());
    }

}