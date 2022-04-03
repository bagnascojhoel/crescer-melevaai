package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.response.BalanceTransitionResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverWithdrawAmountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawMoneyDriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverWithdrawAmountValidator driverWithdrawAmountValidator;

    @Autowired
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    public BalanceTransitionResponse withdraw(String cpf, String amount) {
        BigDecimal fixedAmount = new BigDecimal(amount);

        driverWithdrawAmountValidator.validate(fixedAmount);

        Driver driver = fetchDomainDriverByCpfService.fetch(cpf);

        driver.withdraw(fixedAmount);

        driverRepository.save(driver);

        return new BalanceTransitionResponse(driver.getBalance());
    }
}
