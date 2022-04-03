package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToRequestRideResponseMapper {


    public RequestRideResponse map(Ride ride) {
        RequestRideResponse result = new RequestRideResponse();

        result.setId(ride.getId());
        result.setPickupDuration(Ride.measureRandomPickupDuration().getSeconds());
        result.setVehicleId(ride.getVehicle().getId());

        return result;
    }
}
