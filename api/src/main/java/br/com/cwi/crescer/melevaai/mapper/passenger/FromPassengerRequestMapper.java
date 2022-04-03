package br.com.cwi.crescer.melevaai.mapper.passenger;

import br.com.cwi.crescer.melevaai.controller.request.PassengerRequest;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FromPassengerRequestMapper {

    @Autowired
    private ModelMapper mapper;

    public Passenger map(PassengerRequest passengerRequest) {
        return mapper.map(passengerRequest, Passenger.class);
    }
}
