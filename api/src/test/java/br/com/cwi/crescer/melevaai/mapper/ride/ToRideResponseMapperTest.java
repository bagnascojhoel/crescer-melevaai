package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ToRideResponseMapperTest {

    @InjectMocks
    private ToRideResponseMapper subject;

    @Mock
    private Point point;

    @Test
    public void shouldMapToRideResponseCorrectly() {
        Long id = Long.parseLong("5");
        Passenger passenger = new Passenger();
        passenger.setCpf("51");
        passenger.setName("Jonas");
        Driver driver = new Driver();
        driver.setCpf("13");
        driver.setName("Josué");
        Vehicle vehicle = new Vehicle();
        String plate = "56";
        vehicle.setOwner(driver);
        vehicle.setPlate(new Plate(plate));
        BigDecimal price = BigDecimal.valueOf(15.3);

        Ride ride = new Ride(id, point, point, passenger, vehicle, null, null, price, RideStatus.FINALIZADA, 0,0);

        RideResponse expected = new RideResponse(
                id,
                point,
                point,
                passenger.getCpf(),
                passenger.getName(),
                vehicle.getPlate().getNumber(),
                driver.getCpf(),
                driver.getName(),
                null,
                null,
                price,
                RideStatus.FINALIZADA,
                0,
                0);

        RideResponse actual = subject.map(ride);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getOrigin(), actual.getOrigin());
        Assert.assertEquals(expected.getDestination(), actual.getDestination());
        Assert.assertEquals(expected.getPassengerCpf(), actual.getPassengerCpf());
        Assert.assertEquals(expected.getPassenger(), actual.getPassenger());
        Assert.assertEquals(expected.getDriverCpf(), actual.getDriverCpf());
        Assert.assertEquals(expected.getDriver(), actual.getDriver());
        Assert.assertEquals(expected.getPlate(), actual.getPlate());
        Assert.assertEquals(expected.getStartTime(), actual.getStartTime());
        Assert.assertEquals(expected.getEndTime(), actual.getEndTime());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
        Assert.assertEquals(expected.getDriverScore(), actual.getDriverScore());
        Assert.assertEquals(expected.getPassengerScore(), actual.getPassengerScore());

    }

}