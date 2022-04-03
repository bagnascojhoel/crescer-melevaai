package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Category;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ListVehicleCategoriesService {

    public List<Category> list() {
        return Arrays.asList(Category.values());
    }
}
