package engtelecom.bcd.repository;

import engtelecom.bcd.model.TipoSanguineo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TipoSanguineoRepository extends CrudRepository<TipoSanguineo, Integer> {
    Optional<TipoSanguineo> findTipoSanguineoByTipo(String tipo);
}
