package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverAlreadyExistsValidator {

    public void validate(Optional<Driver> driver) {
        if (driver.isPresent())
            throw new BusynessLogicException("Motorista já existe.");
    }

}
