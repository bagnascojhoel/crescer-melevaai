package br.com.cwi.crescer.melevaai.validators.vehicle;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class VehicleHasOwnerValidator {
    public void validate(Vehicle vehicle) {
        if (vehicle.getOwner() == null)
            throw new BusynessLogicException("Um veículo precisa ter um proprietário.");
    }
}
