package br.com.cwi.crescer.melevaai.mapper.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToPassengerResponseMapper {

    @Autowired
    private ModelMapper mapper;

    public PassengerResponse map(Passenger passenger) {
        return mapper.map(passenger, PassengerResponse.class);
    }
}
