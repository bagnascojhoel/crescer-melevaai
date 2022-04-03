package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class RidePassengerScoreValidator {

    public void validate(Ride ride) {
        if (ride.getPassengerScore() != 0)
            throw new BusynessLogicException("Esta corrida já foi avaliada.");
    }
}
