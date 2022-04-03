package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.mapper.passenger.ToPassengerResponseMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FetchPassengerByCpfServiceTest {

    @InjectMocks
    private FetchPassengerByCpfService subject;

    @Mock
    private ToPassengerResponseMapper toPassengerResponseMapper;

    @Mock
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Test
    public void shouldBePassengerResponseWithSameCpfWhenFetch() {
        // arrange
        String cpf = "1";
        Passenger passenger = new Passenger();
        passenger.setCpf(cpf);

        PassengerResponse passengerResponse = new PassengerResponse();
        passengerResponse.setCpf(cpf);

        Mockito.when(fetchDomainPassengerByCpfService.fetch(cpf))
                .thenReturn(passenger);

        Mockito.when(toPassengerResponseMapper.map(passenger))
                .thenReturn(passengerResponse);

        // act
        subject.fetch(cpf);

        // assert
        Mockito.verify(fetchDomainPassengerByCpfService).fetch(cpf);
        Mockito.verify(toPassengerResponseMapper).map(passenger);

        Assert.assertEquals(cpf, passengerResponse.getCpf());
    }
}
