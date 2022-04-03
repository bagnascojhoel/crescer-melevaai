package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToStartRideResponseMapper {

    public StartRideResponse map(Ride ride) {
        StartRideResponse result = new StartRideResponse();

        result.setExpectedDuration(ride.measureExpectedDuration().getSeconds());
        result.setExpectedPrice(ride.measureExpectedPrice());

        return result;
    }

}
