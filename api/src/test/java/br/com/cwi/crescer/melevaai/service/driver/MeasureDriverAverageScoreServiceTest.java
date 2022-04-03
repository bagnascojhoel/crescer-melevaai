package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.service.ride.ListDomainRidesByDriverService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MeasureDriverAverageScoreServiceTest {

    @InjectMocks
    private MeasureDriverAverageScoreService subject;

    @Mock
    private ListDomainRidesByDriverService listDomainRidesByDriverService;

    @Test
    public void shouldCalculateAnAverageScoreForDriverByCpfWhenMeasure() {
        String cpf = "1";

        Ride ride1 = new Ride();
        ride1.setStatus(RideStatus.FINALIZADA);
        ride1.setDriverScore(3);

        Ride ride2 = new Ride();
        ride2.setStatus(RideStatus.FINALIZADA);
        ride2.setDriverScore(2);

        Ride ride3 = new Ride();
        ride3.setStatus(RideStatus.CHAMADA);

        Mockito.when(listDomainRidesByDriverService.list(cpf))
                .thenReturn(Arrays.asList(ride1, ride2));

        int actual = subject.measure(cpf);

        Mockito.verify(listDomainRidesByDriverService).list(cpf);
        Assert.assertEquals((3 + 2) / 2, actual);
    }
}