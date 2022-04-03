package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.mapper.driver.ToDriverResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchDriverCpfService {

    @Autowired
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Autowired
    private ToDriverResponseMapper toDriverResponseMapper;

    public DriverResponse fetch(String cpf) {
        return toDriverResponseMapper.map(
                fetchDomainDriverByCpfService.fetch(cpf)
        );
    }
}
