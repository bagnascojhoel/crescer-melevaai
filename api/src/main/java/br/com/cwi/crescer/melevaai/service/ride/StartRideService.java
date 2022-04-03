package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.mapper.ride.ToStartRideResponseMapper;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyStartedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StartRideService {

    @Autowired
    private ToStartRideResponseMapper toStartRideResponseMapper;

    @Autowired
    private FetchRideByIdService fetchRideByIdService;

    @Autowired
    private RideAlreadyStartedValidator rideAlreadyStartedValidator;

    @Autowired
    private RideRepository rideRepository;


    public StartRideResponse start(String id) {

        Ride ride = fetchRideByIdService.fetch(Long.parseLong(id));

        rideAlreadyStartedValidator.validate(ride);

        ride.setStartTime(LocalDateTime.now());
        ride.setStatus(RideStatus.INICIADA);

        rideRepository.save(ride);

        return toStartRideResponseMapper.map(ride);
    }
}
