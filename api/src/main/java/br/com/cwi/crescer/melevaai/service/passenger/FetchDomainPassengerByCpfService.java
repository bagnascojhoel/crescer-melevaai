package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDoesNotExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchDomainPassengerByCpfService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerDoesNotExistValidator passengerDoesNotExistValidator;

    public Passenger fetch(String cpf) {
        Optional<Passenger> passengers = passengerRepository.findByCpf(cpf);

        passengerDoesNotExistValidator.validate(passengers);

        return passengers.get();
    }
}
