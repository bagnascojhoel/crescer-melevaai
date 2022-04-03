package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverWithdrawAmountValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawMoneyDriverServiceTest {

    @InjectMocks
    private WithdrawMoneyDriverService subject;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private DriverWithdrawAmountValidator driverWithdrawAmountValidator;

    @Mock
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Test
    public void shouldSubtract100WhenWithdrawAmountOf100() {
        // arrange
        String cpf = "0";
        String initialAmount = "200";
        String amount = "100";

        Driver driver = Mockito.spy(new Driver());
        driver.setCpf(cpf);
        driver.setBalance(new BigDecimal(initialAmount));

        Mockito.when(fetchDomainDriverByCpfService.fetch(cpf))
                .thenReturn(driver);

        // act
        subject.withdraw(cpf, amount);

        // assert
        Mockito.verify(driverWithdrawAmountValidator).validate(new BigDecimal(amount));
        Mockito.verify(fetchDomainDriverByCpfService).fetch(cpf);
        Mockito.verify(driver).withdraw(new BigDecimal(amount));
        Mockito.verify(driverRepository).save(driver);

    }
}