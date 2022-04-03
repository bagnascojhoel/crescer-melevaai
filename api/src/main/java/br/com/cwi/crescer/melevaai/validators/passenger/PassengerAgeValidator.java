package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class PassengerAgeValidator {

    private static final int MIN_AGE = 16;

    public void validate(int age) {
        if (age < MIN_AGE)
            throw new BusynessLogicException("Passageiro com idade inválida.");

    }
}
