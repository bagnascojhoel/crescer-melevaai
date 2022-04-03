package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
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
public class ListRidesByPassengerServiceTest {

    @InjectMocks
    private ListRidesByPassengerService subject;

    @Mock
    private ToRideResponseMapper toRideResponseMapper;

    @Mock
    private ListDomainRidesByPassengerService listDomainRidesByPassengerService;

    @Mock
    private Ride ride;

    @Mock
    private RideResponse rideResponse;

    @Test
    public void shouldBeAllListDomainRidesAsRideResponseWhenList() {

        String cpf = "12";

        Mockito.when(listDomainRidesByPassengerService.list(cpf))
                .thenReturn(Arrays.asList(ride));

        Mockito.when(toRideResponseMapper.map(ride))
                .thenReturn(rideResponse);

        subject.list(cpf);

        Mockito.verify(listDomainRidesByPassengerService).list(cpf);
        Mockito.verify(toRideResponseMapper).map(Mockito.any());
    }
}