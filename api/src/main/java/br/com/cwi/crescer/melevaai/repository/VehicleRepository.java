package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VehicleRepository extends Repository<Vehicle, Long> {

    List<Vehicle> findAll();

    void save(Vehicle vehicle);

    List<Vehicle> findByOwnerCpf(String cpf);

}
