package br.com.cwi.crescer.melevaai.validators.vehicle;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.validators.PersonMinimalDepositAmountValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VehicleOwnerSameCategoryValidatorTest {

    @InjectMocks
    private VehicleOwnerSameCategoryValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithOwnerFromSameCategory() {
        Category category = Category.ACC;
        CNH cnh = new CNH();
        cnh.setCategory(category);
        Driver driver = new Driver();
        driver.setCnh(cnh);

        subject.validate(category, driver);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithOwnerFromDifferentCategories() {
        Category category = Category.ACC;
        CNH cnh = new CNH();
        cnh.setCategory(Category.A);
        Driver driver = new Driver();
        driver.setCnh(cnh);

        subject.validate(category, driver);
    }

}