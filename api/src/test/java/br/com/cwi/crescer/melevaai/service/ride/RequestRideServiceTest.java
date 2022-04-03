package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.request.RideRequest;
import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.mapper.ride.FromRideRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.ride.ToRequestRideResponseMapper;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.VerifyExistsAvailableVehicleService;
import br.com.cwi.crescer.melevaai.service.VerifyPassengerIsFreeService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchDomainPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.vehicle.FetchRandomAvailableVehicleService;
import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableVehiclesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class RequestRideServiceTest {

    @InjectMocks
    private RequestRideService subject;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Mock
    private ToRequestRideResponseMapper toRequestRideResponseMapper;

    @Mock
    private VerifyPassengerIsFreeService verifyPassengerIsFreeService;

    @Mock
    private VerifyExistsAvailableVehicleService verifyExistsAvailableVehicleService;

    @Mock
    private FetchRandomAvailableVehicleService fetchRandomAvailableVehicleService;

    @Mock
    private Vehicle vehicle;

    @Mock
    private Passenger passenger;

    @Mock
    private Point point;

    @Test
    public void shouldValidateAndAddToRepository() {
        // arrange
        String id = "23";
        String cpf = "9";

        RideRequest rideRequest = Mockito.spy(new RideRequest());
        rideRequest.setOrigin(point);
        rideRequest.setDestination(point);

        Ride ride = Mockito.spy(new Ride());
        ride.setOrigin(rideRequest.getOrigin());
        ride.setDestination(rideRequest.getDestination());
        ride.setPassenger(passenger);
        ride.setVehicle(vehicle);
        ride.setStatus(RideStatus.CHAMADA);

        RequestRideResponse requestRideResponse = new RequestRideResponse();

        Mockito.when(fetchRandomAvailableVehicleService.fetch()).thenReturn(vehicle);

        Mockito.when(fetchDomainPassengerByCpfService.fetch(cpf)).thenReturn(passenger);

        Mockito.when(toRequestRideResponseMapper.map(ride)).thenReturn(requestRideResponse);

        // act
        subject.request(cpf, rideRequest);

        // assert
        Mockito.verify(fetchDomainPassengerByCpfService).fetch(cpf);
        Mockito.verify(verifyPassengerIsFreeService).verify(cpf);
        Mockito.verify(verifyExistsAvailableVehicleService).verify();
        Mockito.verify(toRequestRideResponseMapper).map(Mockito.any(Ride.class));
        Mockito.verify(ride).setOrigin(point);
        Mockito.verify(ride).setDestination(point);
        Mockito.verify(ride).setStatus(RideStatus.CHAMADA);
        Mockito.verify(ride).setVehicle(vehicle);
        Mockito.verify(rideRepository).save(Mockito.any(Ride.class));
    }
}