package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverLinkedToVehicleValidator {
    public void validate(List<Vehicle> veiculo) {
        if (!veiculo.isEmpty())
            throw new BusynessLogicException("Motorista vinculado a algum veículo.");

    }
}
