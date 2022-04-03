package br.com.cwi.crescer.melevaai.mapper.driver;

import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
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

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ToDriverResponseMapperTest {

    @InjectMocks
    private ToDriverResponseMapper subject;

    @Mock
    private ModelMapper mapper;

    @Mock
    private CNH cnh;

    @Test
    public void shouldMapToDriverResponseCorrectly() {

        Driver driver = new Driver();
        driver.setId(Long.parseLong("1234"));
        driver.setName("Lukas");
        driver.setEmail("adfasdlkj@asdlkf.c");
        driver.setBirthDate(LocalDate.parse("2000-12-12"));
        driver.setCpf("13241234");
        driver.setCnh(cnh);
        driver.setBalance(BigDecimal.valueOf(123.44));
        driver.setAvgScore(234);

        DriverResponse driverResponse = new DriverResponse(
                driver.getId(),
                driver.getName(),
                driver.getEmail(),
                driver.getBirthDate(),
                driver.getCpf(),
                driver.getCnh(),
                driver.getBalance(),
                driver.getAvgScore()
        );

        Mockito.when(mapper.map(driver, DriverResponse.class)).thenReturn(driverResponse);

        DriverResponse actual = subject.map(driver);

        Assert.assertEquals(driverResponse.getId(), actual.getId());
        Assert.assertEquals(driverResponse.getName(), actual.getName());
        Assert.assertEquals(driverResponse.getEmail(), actual.getEmail());
        Assert.assertEquals(driverResponse.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(driverResponse.getCpf(), actual.getCpf());
        Assert.assertEquals(driverResponse.getCnh(), actual.getCnh());
        Assert.assertEquals(driverResponse.getBalance(), actual.getBalance());
        Assert.assertEquals(driverResponse.getAvgScore(), actual.getAvgScore());
    }
}
