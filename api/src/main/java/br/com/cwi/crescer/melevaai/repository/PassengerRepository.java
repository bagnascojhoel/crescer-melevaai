package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends Repository<Passenger, Long> {

    void save(Passenger passenger);

    List<Passenger> findAll();

    Optional<Passenger> findByCpf(String cpf);

}
