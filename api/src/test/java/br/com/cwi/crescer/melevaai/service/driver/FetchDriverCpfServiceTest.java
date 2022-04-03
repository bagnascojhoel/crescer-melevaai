package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.mapper.driver.ToDriverResponseMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FetchDriverCpfServiceTest {

    @InjectMocks
    private FetchDriverCpfService subject;

    @Mock
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Mock
    private ToDriverResponseMapper toDriverResponseMapper;

    @Test
    public void shouldBeDriverResponseWithSameCpf() {
        // arrange
        String cpf = "0";
        Driver driver = new Driver();
        driver.setCpf(cpf);

        DriverResponse driverResponse = new DriverResponse();
        driverResponse.setCpf(cpf);

        Mockito.when(fetchDomainDriverByCpfService.fetch(cpf))
                .thenReturn(driver);
        Mockito.when(toDriverResponseMapper.map(driver))
                .thenReturn(driverResponse);

        // act
        DriverResponse actual = subject.fetch(cpf);

        // assert
        Mockito.verify(fetchDomainDriverByCpfService).fetch(cpf);
        Mockito.verify(toDriverResponseMapper).map(driver);

        Assert.assertEquals(driverResponse, actual);


    }
}