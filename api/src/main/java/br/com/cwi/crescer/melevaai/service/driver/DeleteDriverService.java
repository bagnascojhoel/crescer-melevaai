package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverLinkedToVehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Autowired
    private DriverLinkedToVehicleValidator driverLinkedToVehicleValidator;

    public void delete(String cpf) {
        Driver driver = fetchDomainDriverByCpfService.fetch(cpf);

        driverLinkedToVehicleValidator.validate(vehicleRepository.findByOwnerCpf(driver.getCpf()));

        driverRepository.delete(driver);
    }
}
