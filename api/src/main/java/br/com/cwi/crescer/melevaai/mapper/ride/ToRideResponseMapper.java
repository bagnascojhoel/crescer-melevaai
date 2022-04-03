package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToRideResponseMapper {

    public RideResponse map(Ride ride) {
        RideResponse result = new RideResponse();

        result.setId(ride.getId());

        result.setOrigin(ride.getOrigin());
        result.setDestination(ride.getDestination());

        result.setPassengerCpf(ride.getPassenger().getCpf());
        result.setPassenger(ride.getPassenger().getName());

        result.setPlate(ride.getVehicle().getPlate().getNumber());

        result.setDriverCpf(ride.getVehicle().getOwner().getCpf());
        result.setDriver(ride.getVehicle().getOwner().getName());

        result.setStartTime(ride.getStartTime());
        result.setEndTime(ride.getEndTime());

        result.setPrice(ride.getPrice());

        result.setStatus(ride.getStatus());

        result.setDriverScore(ride.getDriverScore());
        result.setPassengerScore(ride.getPassengerScore());

        return result;
    }
}
