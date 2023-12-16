package engtelecom.bcd.repository;

import engtelecom.bcd.model.Distintivos;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DistintivosRepository extends CrudRepository<Distintivos, Integer> {
    Optional<Distintivos> findDistintivosByNome(String nomeDistintivo);
}
