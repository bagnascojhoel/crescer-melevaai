package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListDomainDriversServiceTest {

    @InjectMocks
    private ListDomainDriversService subject;

    @Mock
    private DriverRepository driverRepository;

    @Test
    public void shouldBeAllDriversFromRepositoryWhenList() {
        // arrange
        String cpf = "0";
        Driver driver = new Driver();
        driver.setCpf(cpf);

        Mockito.when(driverRepository.findAll())
                .thenReturn(Arrays.asList(driver));
        // act
        List<Driver> actual = subject.list();

        // assert
        Mockito.verify(driverRepository).findAll();

        Assert.assertEquals(driver, actual.get(0));
    }
}