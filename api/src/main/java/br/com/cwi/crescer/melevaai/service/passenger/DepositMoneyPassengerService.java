package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.response.BalanceTransitionResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDepositAmountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositMoneyPassengerService {

    @Autowired
    private PassengerDepositAmountValidator passengerDepositAmountValidator;

    @Autowired
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Autowired
    private PassengerRepository passengerRepository;

    public BalanceTransitionResponse deposit(String cpf, String amount) {

        passengerDepositAmountValidator.validate(new BigDecimal(amount));

        Passenger passenger = fetchDomainPassengerByCpfService.fetch(cpf);

        passenger.deposit(new BigDecimal(amount));

        passengerRepository.save(passenger);

        return new BalanceTransitionResponse(passenger.getBalance());
    }
}
