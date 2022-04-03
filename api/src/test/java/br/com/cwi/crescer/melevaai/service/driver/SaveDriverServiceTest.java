package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.request.DriverRequest;
import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.mapper.driver.FromDriverRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.driver.ToDriverResponseMapper;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.PersonCpfValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverAboveMinimalAgeValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverWithValidCnhValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverAlreadyExistsValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class SaveDriverServiceTest {

    @InjectMocks
    private SaveDriverService subject;

    @Mock
    private FromDriverRequestMapper fromDriverRequestMapper;

    @Mock
    private ToDriverResponseMapper toDriverResponseMapper;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private DriverAlreadyExistsValidator driverAlreadyExistsValidator;

    @Mock
    private DriverAboveMinimalAgeValidator driverAboveMinimalAgeValidator;

    @Mock
    private DriverWithValidCnhValidator driverWithValidCnhValidator;

    @Mock
    private PersonCpfValidator personCpfValidator;

    @Test
    public void shouldBeDriverResponseWithSameCpfWhenSave() {
        // arrange
        String cpf = "0";

        DriverRequest driverRequest = new DriverRequest();
        driverRequest.setCpf(cpf);

        Driver driver = new Driver();
        driver.setCpf(cpf);

        DriverResponse driverResponse = new DriverResponse();
        driverResponse.setCpf(cpf);

        Mockito.when(fromDriverRequestMapper.map(driverRequest))
                .thenReturn(driver);

        Mockito.when(driverRepository.findByCpf(cpf))
                .thenReturn(Optional.of(driver));

        Mockito.when(toDriverResponseMapper.map(driver))
                .thenReturn(driverResponse);

        // act
        DriverResponse actualResponse = subject.save(driverRequest);

        // assert
        Mockito.verify(driverAlreadyExistsValidator).validate(Optional.of(driver));
        Mockito.verify(personCpfValidator).validate(cpf);
        Mockito.verify(driverAboveMinimalAgeValidator).validate(driver);
        Mockito.verify(driverWithValidCnhValidator).validate(driver);
        Mockito.verify(driverRepository).save(driver);

        Assert.assertEquals(driverResponse, actualResponse);

    }



}
