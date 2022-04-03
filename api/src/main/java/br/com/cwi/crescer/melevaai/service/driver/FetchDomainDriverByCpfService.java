package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverDoesNotExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchDomainDriverByCpfService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverDoesNotExistValidator driverDoesNotExistValidator;

    public Driver fetch(String cpf) {
        Optional<Driver> driver = driverRepository.findByCpf(cpf);

        driverDoesNotExistValidator.validate(driver);

        return driver.get();
    }
}
