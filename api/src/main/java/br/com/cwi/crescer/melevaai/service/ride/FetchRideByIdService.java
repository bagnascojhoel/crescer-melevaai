package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideDoesNotExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchRideByIdService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RideDoesNotExistValidator rideDoesNotExistValidator;

    public Ride fetch(Long id) {
        Optional<Ride> ride = rideRepository.findById(id);

        rideDoesNotExistValidator.validate(ride);

        return ride.get();
    }
}
