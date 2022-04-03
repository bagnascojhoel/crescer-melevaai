package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListDomainOnGoingRidesService {

    @Autowired
    private RideRepository rideRepository;

    public List<Ride> list() {
        List<Ride> ridesRequested = rideRepository.findByStatus(RideStatus.CHAMADA);
        List<Ride> ridesStarted = rideRepository.findByStatus(RideStatus.INICIADA);
        List<Ride> result = new ArrayList<>();

        result.addAll(ridesRequested);
        result.addAll(ridesStarted);

        return result;

    }
}
