package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.request.PassengerRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.mapper.passenger.FromPassengerRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.passenger.ToPassengerResponseMapper;
import br.com.cwi.crescer.melevaai.repository.PassengerRepository;
import br.com.cwi.crescer.melevaai.validators.PersonCpfValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerAgeValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerExistsValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class SavePassengerServiceTest {

    @InjectMocks
    private SavePassengerService subject;

    @Mock
    private FromPassengerRequestMapper fromPassengerRequestMapper;

    @Mock
    private ToPassengerResponseMapper toPassengerResponseMapper;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private PersonCpfValidator personCpfValidator;

    @Mock
    private PassengerExistsValidator passengerExistsValidator;

    @Mock
    private PassengerAgeValidator passengerAgeValidator;

    @Mock
    private PassengerRequest passengerRequest;

    @Mock
    private Passenger passenger;

    @Test
    public void shouldMakeValidationsAndBePassengerResponseWithSameCpfWhenSave() {
        // arrange
        String cpf = "5";
        int age = 18;

        PassengerResponse passengerResponse = new PassengerResponse();
        passengerResponse.setCpf(cpf);

        Mockito.when(passengerRequest.getCpf()).thenReturn(cpf);

        Mockito.when(passenger.getCpf()).thenReturn(cpf);

        Mockito.when(passengerRepository.findByCpf(cpf))
                .thenReturn(Optional.of(passenger));

        Mockito.when(fromPassengerRequestMapper.map(passengerRequest))
                .thenReturn(passenger);

        Mockito.when(passenger.measureAge()).thenReturn(age);

        Mockito.when(toPassengerResponseMapper.map(passenger))
                .thenReturn(passengerResponse);
        // act
        subject.save(passengerRequest);

        // assert
        Mockito.verify(passengerExistsValidator).validate(Optional.of(passenger));
        Mockito.verify(fromPassengerRequestMapper).map(passengerRequest);
        Mockito.verify(passengerAgeValidator).validate(age);
        Mockito.verify(personCpfValidator).validate(cpf);
        Mockito.verify(passengerRepository).save(passenger);
        Mockito.verify(toPassengerResponseMapper).map(passenger);

        Assert.assertEquals(cpf, passengerResponse.getCpf());
    }

}
