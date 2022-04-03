package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDoesNotExistValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FetchDomainPassengerByCpfServiceTest {

    @InjectMocks
    private FetchDomainPassengerByCpfService subject;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private PassengerDoesNotExistValidator passengerDoesNotExistValidator;

    @Test
    public void shouldBePassengerWithSameCpfWhenFetch() {
        // arrange
        String cpf = "0";
        Passenger passenger = new Passenger();
        passenger.setCpf(cpf);

        Mockito.when(passengerRepository.findByCpf(cpf))
                .thenReturn(Optional.of(passenger));

        // act
        Passenger actual = subject.fetch(cpf);

        // assert
        Mockito.verify(passengerDoesNotExistValidator).validate(Optional.of(passenger));
        Mockito.verify(passengerRepository).findByCpf(cpf);

        Assert.assertEquals(cpf, actual.getCpf());
    }
}