package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.mapper.passenger.ToPassengerResponseMapper;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPassengersService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ToPassengerResponseMapper toPassengerResponseMapper;

    public List<PassengerResponse> list() {
        return passengerRepository.findAll().stream()
                .map(p -> toPassengerResponseMapper.map(p))
                .collect(Collectors.toList());
    }
}
