package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideDriverScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotFinishedYetValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateDriverService {

    @Autowired
    private FetchRideByIdService fetchRideByIdService;

    @Autowired
    private RideScoreValidator rideScoreValidator;

    @Autowired
    private RideDriverScoreValidator rideDriverScoreValidator;

    @Autowired
    private RideNotFinishedYetValidator rideNotFinishedYetValidator;

    @Autowired
    private RideRepository rideRepository;

    public void rate(String rideId, String score) {
        Ride ride = fetchRideByIdService.fetch(Long.parseLong(rideId));

        rideScoreValidator.validate(Integer.parseInt(score));

        rideDriverScoreValidator.validate(ride);

        rideNotFinishedYetValidator.validate(ride);

        ride.setDriverScore(Integer.parseInt(score));

        rideRepository.save(ride);
    }
}
