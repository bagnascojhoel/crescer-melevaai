package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Brand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ListVehicleBrandsService {
    public List<Brand> list() {
        return Arrays.asList(Brand.values());
    }
}
