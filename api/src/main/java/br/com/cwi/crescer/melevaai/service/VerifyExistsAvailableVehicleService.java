package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableDomainVehiclesService;
import br.com.cwi.crescer.melevaai.validators.VehicleAvailableExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyExistsAvailableVehicleService {

    @Autowired
    private ListAvailableDomainVehiclesService listAvailableDomainVehiclesService;

    @Autowired
    private VehicleAvailableExistsValidator vehicleAvailableExistsValidator;

    public void verify() {
        vehicleAvailableExistsValidator.validate(
                listAvailableDomainVehiclesService.list()
        );
    }
}
