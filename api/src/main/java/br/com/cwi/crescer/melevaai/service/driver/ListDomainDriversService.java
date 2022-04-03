package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListDomainDriversService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> list() {
        return driverRepository.findAll();
    }
}
