package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonCpfValidatorTest {

    @InjectMocks
    private PersonCpfValidator subject;

    @Test
    public void shouldDoNothingWhenValidateWithNonEmptyCpf() {
        String cpf = "1";

        subject.validate(cpf);
    }

    @Test(expected = BusynessLogicException.class)
    public void shouldThrowWhenValidateWithEmptyCpf() {
        String cpf = "";

        subject.validate(cpf);
    }

}