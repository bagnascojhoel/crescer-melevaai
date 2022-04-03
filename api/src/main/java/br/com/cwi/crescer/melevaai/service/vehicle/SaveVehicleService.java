package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.request.VehicleRequest;
import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.mapper.vehicle.FromVehicleRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.vehicle.ToVehicleResponseMapper;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.service.driver.FetchDomainDriverByCpfService;
import br.com.cwi.crescer.melevaai.validators.vehicle.VehicleOwnerSameCategoryValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveVehicleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FromVehicleRequestMapper fromVehicleRequestMapper;

    @Autowired
    private ToVehicleResponseMapper toVehicleResponseMapper;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Autowired
    private VehicleOwnerSameCategoryValidator vehicleOwnerSameCategoryValidator;

    public VehicleResponse save(VehicleRequest vehicleRequest) {

        Driver owner = fetchDomainDriverByCpfService.fetch(vehicleRequest.getOwnerCpf());

        vehicleOwnerSameCategoryValidator.validate(vehicleRequest.getCategory(), owner);

        Vehicle vehicle = fromVehicleRequestMapper.map(vehicleRequest, owner);

        vehicleRepository.save(vehicle);

        return toVehicleResponseMapper.map(vehicle);
    }
}
