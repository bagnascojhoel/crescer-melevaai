package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface RideRepository extends Repository<Ride, Long> {

    List<Ride> findAll();

    void save(Ride ride);

    List<Ride> findByStatus(RideStatus status);

    Optional<Ride> findById(Long id);

}
