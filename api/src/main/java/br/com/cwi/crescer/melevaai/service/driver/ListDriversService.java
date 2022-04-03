package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.mapper.driver.ToDriverResponseMapper;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListDriversService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ToDriverResponseMapper toDriverResponseMapper;

    public List<DriverResponse> list() {
        return driverRepository.findAll().stream()
                .map(d -> toDriverResponseMapper.map(d))
                .collect(Collectors.toList());
    }
}
