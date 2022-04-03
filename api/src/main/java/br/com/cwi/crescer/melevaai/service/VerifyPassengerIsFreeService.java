package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.service.ride.ListDomainOnGoingRidesService;
import br.com.cwi.crescer.melevaai.validators.ride.RideWithFreePassengerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerifyPassengerIsFreeService {

    @Autowired
    private ListDomainOnGoingRidesService listDomainOnGoingRidesService;

    @Autowired
    private RideWithFreePassengerValidator rideWithFreePassengerValidator;

    public void verify(String cpf) {
        Optional<Ride> rideOptional = listDomainOnGoingRidesService.list().stream()
                .filter(c -> c.getPassenger().getCpf().equals(cpf))
                .findFirst();

        rideWithFreePassengerValidator.validate(rideOptional);
    }
}
