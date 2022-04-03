package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAvailableVehiclesService {

    @Autowired
    private MapToVehicleResponseListService mapToVehicleResponseListService;

    @Autowired
    private ListAvailableDomainVehiclesService listAvailableDomainVehiclesService;

    public List<VehicleResponse> list() {

        return mapToVehicleResponseListService.map(
                listAvailableDomainVehiclesService.list()
        );
    }
}
