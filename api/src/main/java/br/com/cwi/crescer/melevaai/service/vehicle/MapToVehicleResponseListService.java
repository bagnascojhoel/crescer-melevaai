package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.mapper.vehicle.ToVehicleResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapToVehicleResponseListService {

    @Autowired
    private ToVehicleResponseMapper toVehicleResponseMapper;

    public List<VehicleResponse> map(List<Vehicle> vehicleList) {
        return vehicleList.stream()
                .map(v -> toVehicleResponseMapper.map(v))
                .collect(Collectors.toList());
    }
}
