package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleAvailableExistsValidator {
    public void validate(List<Vehicle> vehicles) {
        if (vehicles.isEmpty())
            throw new BusynessLogicException("Sem veículos disponíveis.");

    }
}
