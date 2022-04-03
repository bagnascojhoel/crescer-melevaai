package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.mapper.passenger.ToPassengerResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchPassengerByCpfService {

    @Autowired
    private ToPassengerResponseMapper toPassengerResponseMapper;

    @Autowired
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    public PassengerResponse fetch(String cpf) {
        Passenger passenger = fetchDomainPassengerByCpfService.fetch(cpf);

        return toPassengerResponseMapper.map(passenger);
    }
}
