package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.mapper.ride.ToRideResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListRidesByPassengerService {

    @Autowired
    private ToRideResponseMapper toRideResponseMapper;

    @Autowired
    private ListDomainRidesByPassengerService listDomainRidesByPassengerService;

    public List<RideResponse> list(String cpf) {
        List<Ride> rides = listDomainRidesByPassengerService.list(cpf);

        return rides.stream()
                .map(toRideResponseMapper::map)
                .collect(Collectors.toList());
    }
}
