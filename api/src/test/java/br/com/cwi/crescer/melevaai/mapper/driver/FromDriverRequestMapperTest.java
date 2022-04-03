package br.com.cwi.crescer.melevaai.mapper.driver;

import br.com.cwi.crescer.melevaai.controller.request.DriverRequest;
import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FromDriverRequestMapperTest {

    @InjectMocks
    private FromDriverRequestMapper subject;

    @Mock
    private ModelMapper mapper;

    @Mock
    private CNH cnh;

    @Test
    public void shouldMapFromDriverRequestCorrectly() {
        DriverRequest driverRequest = new DriverRequest("Opaiz", "sdfa@gasd.ca", LocalDate.parse("2000-12-12"), "12341", cnh);

        Driver driver = new Driver();
        driver.setName(driverRequest.getName());
        driver.setEmail(driverRequest.getEmail());
        driver.setBirthDate(driverRequest.getBirthDate());
        driver.setCpf(driverRequest.getCpf());
        driver.setCnh(driverRequest.getCnh());

        Mockito.when(mapper.map(driverRequest, Driver.class)).thenReturn(driver);

        Driver actual = subject.map(driverRequest);

        Assert.assertEquals(driver.getName(), actual.getName());
        Assert.assertEquals(driver.getEmail(), actual.getEmail());
        Assert.assertEquals(driver.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(driver.getCpf(), actual.getCpf());
        Assert.assertEquals(driver.getCnh(), actual.getCnh());
    }
}