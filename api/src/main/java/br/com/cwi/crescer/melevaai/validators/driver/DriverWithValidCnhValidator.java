package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DriverWithValidCnhValidator {

    public void validate(Driver driver) {
        if (!isValidaDueDate(driver.getCnh()))
            throw new BusynessLogicException("Motorista com CNH vencida.");
    }

    private boolean isValidaDueDate(CNH cnh) {
        return cnh.getDueDate().isAfter(LocalDate.now());
    }

}
