package br.com.cwi.crescer.melevaai.mapper.passenger;

import br.com.cwi.crescer.melevaai.controller.request.PassengerRequest;
import br.com.cwi.crescer.melevaai.domain.Passenger;
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
public class FromPassengerRequestMapperTest {

    @InjectMocks
    private FromPassengerRequestMapper subject;

    @Mock
    private ModelMapper mapper;

    @Test
    public void shouldMapFromPassengerRequestCorrectly() {

        PassengerRequest passengerRequest = new PassengerRequest();
        passengerRequest.setName("Holly");
        passengerRequest.setEmail("adfk@5lkjd.lp");
        passengerRequest.setBirthDate(LocalDate.parse("1800-12-12"));
        passengerRequest.setCpf("15616");

        Passenger passenger = new Passenger();
        passenger.setName(passengerRequest.getName());
        passenger.setEmail(passengerRequest.getEmail());
        passenger.setBirthDate(passengerRequest.getBirthDate());
        passenger.setCpf(passengerRequest.getCpf());

        Mockito.when(mapper.map(passengerRequest, Passenger.class))
                .thenReturn(passenger);

        Passenger actual = subject.map(passengerRequest);

        Assert.assertEquals(passenger.getName(), actual.getName());
        Assert.assertEquals(passenger.getEmail(), actual.getEmail());
        Assert.assertEquals(passenger.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(passenger.getCpf(), actual.getCpf());
    }
}