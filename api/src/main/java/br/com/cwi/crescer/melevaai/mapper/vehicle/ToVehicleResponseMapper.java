package br.com.cwi.crescer.melevaai.mapper.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToVehicleResponseMapper {

    @Autowired
    private ModelMapper mapper;

    public VehicleResponse map(Vehicle vehicle) {
        VehicleResponse result = mapper.map(vehicle, VehicleResponse.class);

        result.setPlate(vehicle.getPlate().getNumber());
        result.setOwnerCpf(vehicle.getOwner().getCpf());

        return result;
    }
}
