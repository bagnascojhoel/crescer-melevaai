package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.mapper.driver.ToDriverResponseMapper;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListDriversServiceTest {

    @InjectMocks
    private ListDriversService subject;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private ToDriverResponseMapper toDriverResponseMapper;

    @Test
    public void shouldBeAnArrayListOfAllDriversWhenList() {
        // arrange
        Driver driver = new Driver();
        DriverResponse driverResponse = new DriverResponse();
        List<Driver> driverList = Arrays.asList(driver);
        List<DriverResponse> driverResponseList = Arrays.asList(driverResponse);

        Mockito.when(toDriverResponseMapper.map(driver))
                .thenReturn(driverResponse);

        Mockito.when(driverRepository.findAll())
                .thenReturn(driverList);

        List<DriverResponse> expected = driverResponseList;
        // act
        List<DriverResponse> actual = subject.list();

        // assert
        Mockito.verify(driverRepository).findAll();
        Mockito.verify(toDriverResponseMapper).map(driver);

        Assert.assertEquals(expected, actual);

    }

}