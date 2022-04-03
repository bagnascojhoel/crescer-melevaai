package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverDoesNotExistValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FetchDomainDriverByCpfServiceTest {

    @InjectMocks
    private FetchDomainDriverByCpfService subject;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private DriverDoesNotExistValidator driverDoesNotExistValidator;

    @Mock
    private Driver driver;

    @Test
    public void shouldBeDriverWithSameCpfWhenFetch() {
        // arrange
        String cpf = "0";

        Mockito.when(driver.getCpf())
                .thenReturn(cpf);

        Mockito.when(driverRepository.findByCpf(cpf))
                .thenReturn(Optional.of(driver));

        // act
        String actual = subject.fetch(cpf).getCpf();

        // assert
        Mockito.verify(driverRepository).findByCpf(cpf);
        Mockito.verify(driverDoesNotExistValidator).validate(Optional.of(driver));

        Assert.assertEquals(cpf, actual);
    }
}