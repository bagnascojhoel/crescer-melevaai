package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class RideAlreadyStartedValidator {
    public void validate(Ride ride) {
        if (ride.getStatus() != RideStatus.CHAMADA)
            throw new BusynessLogicException("Ride já foi iniciada.");
    }
}
