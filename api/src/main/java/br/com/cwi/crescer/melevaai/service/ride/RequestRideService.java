package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.request.RideRequest;
import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.mapper.ride.FromRideRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.ride.ToRequestRideResponseMapper;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.VerifyExistsAvailableVehicleService;
import br.com.cwi.crescer.melevaai.service.VerifyPassengerIsFreeService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchDomainPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.vehicle.FetchRandomAvailableVehicleService;
import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestRideService {


    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Autowired
    private ListAvailableVehiclesService listAvailableVehiclesService;

    @Autowired
    private FetchRandomAvailableVehicleService fetchRandomAvailableVehicleService;

    @Autowired
    private FromRideRequestMapper fromRideRequestMapper;

    @Autowired
    private ToRequestRideResponseMapper toRequestRideResponseMapper;

    @Autowired
    private VerifyPassengerIsFreeService verifyPassengerIsFreeService;

    @Autowired
    private VerifyExistsAvailableVehicleService verifyExistsAvailableVehicleService;

    public RequestRideResponse request(String cpf, RideRequest request) {
        Passenger passenger = fetchDomainPassengerByCpfService.fetch(cpf);

        verifyPassengerIsFreeService.verify(cpf);

        verifyExistsAvailableVehicleService.verify();

        Ride ride = new Ride();

        ride.setDestination(request.getDestination());
        ride.setOrigin(request.getOrigin());
        ride.setPassenger(passenger);
        ride.setVehicle(fetchRandomAvailableVehicleService.fetch());
        ride.setStatus(RideStatus.CHAMADA);

        rideRepository.save(ride);

        return toRequestRideResponseMapper.map(ride);
    }

}
