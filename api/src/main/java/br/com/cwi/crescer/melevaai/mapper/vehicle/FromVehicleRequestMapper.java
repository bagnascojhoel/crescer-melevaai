package br.com.cwi.crescer.melevaai.mapper.vehicle;

import br.com.cwi.crescer.melevaai.controller.request.VehicleRequest;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Plate;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FromVehicleRequestMapper {

    @Autowired
    private ModelMapper mapper;

    public Vehicle map(VehicleRequest vehicleRequest, Driver owner) {
        Vehicle vehicle = mapper.map(vehicleRequest, Vehicle.class);

        vehicle.setPlate(new Plate(vehicleRequest.getPlate()));
        vehicle.setOwner(owner);

        return vehicle;
    }
}
