package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.request.DriverRequest;
import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.mapper.driver.FromDriverRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.driver.ToDriverResponseMapper;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.PersonCpfValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverAboveMinimalAgeValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverAlreadyExistsValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverWithValidCnhValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaveDriverService {

    @Autowired
    private FromDriverRequestMapper fromDriverRequestMapper;

    @Autowired
    private ToDriverResponseMapper toDriverResponseMapper;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverAlreadyExistsValidator driverAlreadyExistsValidator;

    @Autowired
    private DriverAboveMinimalAgeValidator driverAboveMinimalAgeValidator;

    @Autowired
    private DriverWithValidCnhValidator driverWithValidCnhValidator;

    @Autowired
    private PersonCpfValidator personCpfValidator;

    public DriverResponse save(DriverRequest request) {

        driverAlreadyExistsValidator.validate(driverRepository.findByCpf(request.getCpf()));

        personCpfValidator.validate(request.getCpf());

        Driver driver = fromDriverRequestMapper.map(request);

        driverAboveMinimalAgeValidator.validate(driver);

        driverWithValidCnhValidator.validate(driver);

        driver.setBalance(BigDecimal.valueOf(0));

        driverRepository.save(driver);

        return toDriverResponseMapper.map(driver);
    }
}
