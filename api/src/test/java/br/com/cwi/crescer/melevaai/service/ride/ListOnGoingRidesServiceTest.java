package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.mapper.ride.ToRideResponseMapper;
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
public class ListOnGoingRidesServiceTest {

    @InjectMocks
    ListOnGoingRidesService subject;

    @Mock
    private ListDomainOnGoingRidesService listDomainOnGoingRidesService;

    @Mock
    private ToRideResponseMapper toRideResponseMapper;

    @Mock
    private Ride ride;

    @Test
    public void shouldListAllOnGoingRidesMappedToRideResponseWhenList() {
        Mockito.when(listDomainOnGoingRidesService.list())
                .thenReturn(Arrays.asList(ride));

        subject.list();

        Mockito.verify(listDomainOnGoingRidesService).list();
        Mockito.verify(toRideResponseMapper).map(ride);
    }
}