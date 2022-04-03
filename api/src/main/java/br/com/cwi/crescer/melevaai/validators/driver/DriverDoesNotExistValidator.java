package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverDoesNotExistValidator {

    public void validate(Optional<Driver> driver) {
        if (!driver.isPresent())
            throw new NotFoundException("Nao existe motorista com o cpf informado.");
    }
}
