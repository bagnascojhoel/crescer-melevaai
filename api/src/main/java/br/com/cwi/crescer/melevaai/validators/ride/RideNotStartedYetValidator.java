package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class RideNotStartedYetValidator {
    public void validate(Ride ride) {
        if (ride.getStatus() == RideStatus.CHAMADA)
            throw new BusynessLogicException("Ride ainda não foi iniciada.");
    }
}
