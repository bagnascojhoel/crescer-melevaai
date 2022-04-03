package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.mapper.ride.ToRideResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListOnGoingRidesService {

    @Autowired
    private ListDomainOnGoingRidesService listDomainOnGoingRidesService;

    @Autowired
    private ToRideResponseMapper toRideResponseMapper;

    public List<RideResponse> list() {
        return listDomainOnGoingRidesService.list().stream()
                .map(toRideResponseMapper::map)
                .collect(Collectors.toList());
    }
}
