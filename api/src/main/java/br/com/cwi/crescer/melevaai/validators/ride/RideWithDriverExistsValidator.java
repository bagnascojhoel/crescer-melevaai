package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RideWithDriverExistsValidator {
    public void validate(List<Ride> rides) {
        if (rides.isEmpty())
            throw new NotFoundException("O motorista solicitado não possui nenhuma corrida.");
    }
}
