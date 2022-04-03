package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RideDoesNotExistValidator {
    public void validate(Optional<Ride> ride) {
        if (!ride.isPresent())
            throw new NotFoundException("Ride não encontrada.");
    }
}
