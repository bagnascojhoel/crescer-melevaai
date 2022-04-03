package br.com.cwi.crescer.melevaai.validators.vehicle;

import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class VehicleOwnerSameCategoryValidator {
    public void validate(Category category, Driver driver) {
        if (category != driver.getCnh().getCategory())
            throw new BusynessLogicException("O proprietário não é apto a dirigir este veiculo.");

    }
}
