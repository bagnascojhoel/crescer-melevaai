package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ToStartRideResponseMapperTest {

    @InjectMocks
    private ToStartRideResponseMapper subject;

    @Mock
    private Passenger passenger;

    @Mock
    private Vehicle vehicle;

    @Test
    public void shouldMapToStartRideResponseCorrectly() {
        Long id = Long.parseLong("5");
        Point origin = new Point(id,0, 0);
        Point destination = new Point(id + 1, 15, 36);
        LocalDateTime startTime = LocalDateTime.now();
        RideStatus status = RideStatus.CHAMADA;
        Ride ride = new Ride(id, origin, destination, passenger, vehicle, startTime, null, null, status, 0, 0);

        StartRideResponse expected = new StartRideResponse(ride.measureExpectedDuration().getSeconds(), ride.measureExpectedPrice());

        StartRideResponse actual = subject.map(ride);

        Assert.assertEquals(expected.getExpectedDuration(), actual.getExpectedDuration());
        Assert.assertEquals(expected.getExpectedPrice(), actual.getExpectedPrice());
    }

}