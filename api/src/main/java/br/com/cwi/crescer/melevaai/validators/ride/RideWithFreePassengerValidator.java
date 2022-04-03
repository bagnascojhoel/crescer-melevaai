package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RideWithFreePassengerValidator {
    public void validate(Optional<Ride> corrida) {
        if (corrida.isPresent())
            throw new BusynessLogicException("Passageiro já está em corrida.");

    }
}
