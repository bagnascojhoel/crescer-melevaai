package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.mapper.passenger.ToPassengerResponseMapper;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
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
public class ListPassengersServiceTest {

    @InjectMocks
    private ListPassengersService listPassengersService;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private ToPassengerResponseMapper toPassengerResponseMapper;

    @Test
    public void shouldBeAListOfPassengerResponseWhenList() {
        // arrange
        String cpf = "2";
        Passenger passenger = new Passenger();
        passenger.setCpf(cpf);

        PassengerResponse passengerResponse = new PassengerResponse();
        passengerResponse.setCpf(cpf);

        Mockito.when(passengerRepository.findAll())
                .thenReturn(Arrays.asList(passenger));

        Mockito.when(toPassengerResponseMapper.map(passenger))
                .thenReturn(passengerResponse);
        // act
        List<PassengerResponse> actual = listPassengersService.list();

        // assert
        Mockito.verify(passengerRepository).findAll();
        Mockito.verify(toPassengerResponseMapper).map(passenger);

        Assert.assertEquals(cpf, actual.get(0).getCpf());
    }
}
