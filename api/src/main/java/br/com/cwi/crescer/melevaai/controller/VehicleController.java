package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.VehicleRequest;
import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Brand;
import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Color;
import br.com.cwi.crescer.melevaai.service.vehicle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VehicleController {

    private final SaveVehicleService saveVehicleService;

    private final ListVehiclesService listVehiclesService;

    private final ListAvailableVehiclesService listAvailableVehiclesService;

    private final ListVehicleCategoriesService listVehicleCategoriesService;

    private final ListVehicleColorsService listVehicleColorsService;

    private final ListVehicleBrandsService listVehicleBrandsService;

    @Autowired
    public VehicleController(SaveVehicleService saveVehicleService, ListVehiclesService listVehiclesService, ListAvailableVehiclesService listAvailableVehiclesService, ListVehicleCategoriesService listVehicleCategoriesService, ListVehicleColorsService listVehicleColorsService, ListVehicleBrandsService listVehicleBrandsService) {
        this.saveVehicleService = saveVehicleService;
        this.listVehiclesService = listVehiclesService;
        this.listAvailableVehiclesService = listAvailableVehiclesService;
        this.listVehicleCategoriesService = listVehicleCategoriesService;
        this.listVehicleColorsService = listVehicleColorsService;
        this.listVehicleBrandsService = listVehicleBrandsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleResponse addVehicle(@RequestBody @Valid VehicleRequest vehicleRequest) {
        return saveVehicleService.save(vehicleRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleResponse> listVehicles() {
        return listVehiclesService.list();
    }

    @GetMapping("veiculos-disponiveis")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleResponse> listAvailableVehicles() {
        return listAvailableVehiclesService.list();
    }

    @GetMapping("categorias")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> listCategories() {
        return listVehicleCategoriesService.list();
    }

    @GetMapping("cores")
    @ResponseStatus(HttpStatus.OK)
    public List<Color> listColors() {
        return listVehicleColorsService.list();
    }

    @GetMapping("marcas")
    @ResponseStatus(HttpStatus.OK)
    public List<Brand> listBrands() {
        return listVehicleBrandsService.list();
    }


}
