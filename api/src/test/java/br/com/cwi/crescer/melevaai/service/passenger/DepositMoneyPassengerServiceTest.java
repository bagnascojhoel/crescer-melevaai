package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDepositAmountValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class DepositMoneyPassengerServiceTest {
    @InjectMocks
    private DepositMoneyPassengerService subject;

    @Mock
    private PassengerDepositAmountValidator passengerDepositAmountValidator;

    @Mock
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private Passenger passenger;

    @Test
    public void shouldIncreasePassengerBalanceWhenDepositPositiveAmount() {
        // arrange
        String cpf = "0";
        String amount = "100";

        Mockito.when(fetchDomainPassengerByCpfService.fetch(cpf))
                .thenReturn(passenger);
        // act
        subject.deposit(cpf, amount);
        // assert
        Mockito.verify(passengerDepositAmountValidator).validate(new BigDecimal(amount));
        Mockito.verify(passenger).deposit(new BigDecimal(amount));
        Mockito.verify(passengerRepository).save(passenger);
    }
}
