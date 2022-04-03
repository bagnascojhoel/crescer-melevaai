package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FetchRandomAvailableVehicleService {

    @Autowired
    private ListAvailableDomainVehiclesService listAvailableDomainVehiclesService;

    public Vehicle fetch() {
        List<Vehicle> veiculosDisponiveis = listAvailableDomainVehiclesService.list();

        int posicaoAleatoria = new Random().nextInt(veiculosDisponiveis.size() - 1);

        return veiculosDisponiveis.get(posicaoAleatoria);
    }
}
