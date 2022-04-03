package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.request.RideRequest;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FromRideRequestMapper {

    @Autowired
    private ModelMapper mapper;

    public Ride map(RideRequest rideRequest) {
        return mapper.map(rideRequest, Ride.class);
    }
}
