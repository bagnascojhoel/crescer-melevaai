package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.service.ride.ListDomainRidesByPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurePassengerAverageScoreService {

    @Autowired
    private ListDomainRidesByPassengerService listDomainRidesByPassengerService;

    public int measure(String cpf) {
        final List<Ride> rides = listDomainRidesByPassengerService.list(cpf);

        final List<Ride> evaluatedRides = rides.stream()
                .filter(r -> r.getStatus().equals(RideStatus.FINALIZADA) && r.getPassengerScore() > 0)
                .collect(Collectors.toList());

        final long totalScore = evaluatedRides.stream()
                .map(r -> r.getPassengerScore())
                .reduce(0, Integer::sum);

        final long qtyRides = evaluatedRides.stream().count();

        return Math.round(totalScore / qtyRides);
    }
}
