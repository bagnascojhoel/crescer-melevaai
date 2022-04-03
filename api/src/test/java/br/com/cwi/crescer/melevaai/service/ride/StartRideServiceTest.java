package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.mapper.ride.ToStartRideResponseMapper;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyStartedValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StartRideServiceTest {

    @InjectMocks
    private StartRideService subject;

    @Mock
    private ToStartRideResponseMapper toStartRideResponseMapper;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideAlreadyStartedValidator rideAlreadyStartedValidator;

    @Mock
    private RideRepository rideRepository;

    @Test
    public void shouldHaveStatusIniciadaWhenStart() {
        String id = "23";
        Ride ride = Mockito.spy(new Ride());

        Mockito.when(fetchRideByIdService.fetch(Long.parseLong(id))).thenReturn(ride);

        Mockito.when(toStartRideResponseMapper.map(ride)).thenReturn(Mockito.mock(StartRideResponse.class));

        subject.start(id);

        Mockito.verify(fetchRideByIdService).fetch(Long.parseLong(id));
        Mockito.verify(rideAlreadyStartedValidator).validate(ride);
        Mockito.verify(ride).setStartTime(Mockito.any());
        Mockito.verify(ride).setStatus(RideStatus.INICIADA);
        Mockito.verify(toStartRideResponseMapper).map(ride);
        Mockito.verify(rideRepository).save(ride);
    }
}