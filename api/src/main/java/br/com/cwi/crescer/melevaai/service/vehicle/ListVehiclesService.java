package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListVehiclesService {

    @Autowired
    private MapToVehicleResponseListService mapToVehicleResponseListService;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleResponse> list() {
        return mapToVehicleResponseListService.map(vehicleRepository.findAll());
    }
}
