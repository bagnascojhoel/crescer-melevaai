package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.request.RideRequest;
import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FromRideRequestMapperTest {

    @InjectMocks
    private FromRideRequestMapper subject;

    @Mock
    private ModelMapper mapper;

    @Test
    public void shouldMapFromRideRequestCorrectly() {
        RideRequest rideRequest = new RideRequest();

        Point origin = new Point();
        Point destination = new Point();

        Ride ride = new Ride();

        ride.setOrigin(origin);
        ride.setDestination(destination);

        Mockito.when(mapper.map(rideRequest, Ride.class))
                .thenReturn(ride);

        Ride actual = subject.map(rideRequest);

        Assert.assertEquals(ride.getOrigin(), actual.getOrigin());
        Assert.assertEquals(ride.getDestination(), actual.getDestination());
    }

}