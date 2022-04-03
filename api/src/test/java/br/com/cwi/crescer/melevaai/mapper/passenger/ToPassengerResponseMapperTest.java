package br.com.cwi.crescer.melevaai.mapper.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
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

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ToPassengerResponseMapperTest {

    @InjectMocks
    private ToPassengerResponseMapper subject;

    @Mock
    private ModelMapper mapper;

    @Test
    public void shouldMapToPassengerResponseCorrectly() {

        Passenger passenger = new Passenger();
        passenger.setName("Jonas");
        passenger.setCpf("2065");
        passenger.setEmail("asdfa@gad.co");
        passenger.setBirthDate(LocalDate.parse("2000-12-12"));
        passenger.setBalance(BigDecimal.valueOf(50.3));
        passenger.setAvgScore(4);

        PassengerResponse passengerResponse = new PassengerResponse(
                passenger.getName(),
                passenger.getEmail(),
                passenger.getBirthDate(),
                passenger.getCpf(),
                passenger.getBalance(),
                passenger.getAvgScore()
        );

        Mockito.when(mapper.map(passenger, PassengerResponse.class))
                .thenReturn(passengerResponse);

        PassengerResponse actual = subject.map(passenger);

        Assert.assertEquals(passengerResponse.getName(), actual.getName());
        Assert.assertEquals(passengerResponse.getEmail(), actual.getEmail());
        Assert.assertEquals(passengerResponse.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(passengerResponse.getCpf(), actual.getCpf());
        Assert.assertEquals(passengerResponse.getBalance(), actual.getBalance());
        Assert.assertEquals(passengerResponse.getAvgScore(), actual.getAvgScore());
    }
}