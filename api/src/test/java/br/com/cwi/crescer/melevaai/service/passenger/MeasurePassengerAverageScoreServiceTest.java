package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.service.ride.ListDomainRidesByPassengerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class MeasurePassengerAverageScoreServiceTest {

    @InjectMocks
    private MeasurePassengerAverageScoreService subject;

    @Mock
    private ListDomainRidesByPassengerService listDomainRidesByPassengerService;

    @Test
    public void shouldCalculateAnAverageScoreForPassengerByCpfWhenMeasure() {
        String cpf = "1";

        Ride ride1 = new Ride();
        ride1.setStatus(RideStatus.FINALIZADA);
        ride1.setPassengerScore(3);

        Ride ride2 = new Ride();
        ride2.setStatus(RideStatus.FINALIZADA);
        ride2.setPassengerScore(2);

        Ride ride3 = new Ride();
        ride3.setStatus(RideStatus.CHAMADA);

        Mockito.when(listDomainRidesByPassengerService.list(cpf))
                .thenReturn(Arrays.asList(ride1, ride2));

        int actual = subject.measure(cpf);

        Mockito.verify(listDomainRidesByPassengerService).list(cpf);
        Assert.assertEquals((3 + 2) / 2, actual);
    }
}