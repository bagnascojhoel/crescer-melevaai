package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.validators.ride.RideWithDriverExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListDomainRidesByDriverService {

    @Autowired
    private RideWithDriverExistsValidator rideWithDriverExistsValidator;

    @Autowired
    private RideRepository rideRepository;

    public List<Ride> list(String cpf) {
        List<Ride> rides = rideRepository.findAll().stream()
                .filter(c -> c.getVehicle().getOwner().getCpf().equals(cpf))
                .collect(Collectors.toList());

        rideWithDriverExistsValidator.validate(rides);

        return rides;
    }
}
