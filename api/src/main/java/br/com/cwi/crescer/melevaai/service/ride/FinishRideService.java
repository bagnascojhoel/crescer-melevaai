package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyFinishedValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotStartedYetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class FinishRideService {

    @Autowired
    private FetchRideByIdService fetchRideByIdService;

    @Autowired
    private RideNotStartedYetValidator rideNotStartedYetValidator;

    @Autowired
    private RideAlreadyFinishedValidator rideAlreadyFinishedValidator;

    @Autowired
    private ListDomainRidesByPassengerService listDomainRidesByPassengerService;

    @Autowired
    private RideRepository rideRepository;

    public void finish(String id) {
        Ride ride = fetchRideByIdService.fetch(Long.parseLong(id));

        rideNotStartedYetValidator.validate(ride);

        rideAlreadyFinishedValidator.validate(ride);

        ride.setEndTime(LocalDateTime.now());

        ride.setPrice(Ride.measurePrice(ride.getStartTime(), ride.getEndTime()));

        ride.getPassenger().withdraw(ride.getPrice());

        ride.getVehicle().getOwner().deposit(ride.getPrice());

        ride.setStatus(RideStatus.FINALIZADA);

        rideRepository.save(ride);
    }
}
