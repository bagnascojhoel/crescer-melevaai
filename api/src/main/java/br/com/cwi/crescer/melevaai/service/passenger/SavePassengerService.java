package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.request.PassengerRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.mapper.passenger.FromPassengerRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.passenger.ToPassengerResponseMapper;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import br.com.cwi.crescer.melevaai.validators.PersonCpfValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerAgeValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SavePassengerService {

    @Autowired
    private FromPassengerRequestMapper fromPassengerRequestMapper;

    @Autowired
    private ToPassengerResponseMapper toPassengerResponseMapper;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PersonCpfValidator personCpfValidator;

    @Autowired
    private PassengerExistsValidator passengerExistsValidator;

    @Autowired
    private PassengerAgeValidator passengerAgeValidator;

    public PassengerResponse save(PassengerRequest passengerRequest) {

        passengerExistsValidator.validate(passengerRepository.findByCpf(passengerRequest.getCpf()));

        Passenger passenger = fromPassengerRequestMapper.map(passengerRequest);

        passengerAgeValidator.validate(passenger.measureAge());

        personCpfValidator.validate(passenger.getCpf());

        passenger.setBalance(new BigDecimal(0));

        passengerRepository.save(passenger);

        return toPassengerResponseMapper.map(passenger);
    }
}
