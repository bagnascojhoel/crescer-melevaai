package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class DriverAboveMinimalAgeValidator {

    private static final int MIN_AGE = 18;

    public void validate(Driver driver) {
        if (driver.measureAge() < MIN_AGE)
            throw new BusynessLogicException("Motorista com idade inválida.");
    }
}
