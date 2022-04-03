package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class RideNotFinishedYetValidator {

    public void validate(Ride ride) {
        if (ride.getStatus() != RideStatus.FINALIZADA)
            throw new BusynessLogicException("Ride ainda não foi finalizada");
    }

}
