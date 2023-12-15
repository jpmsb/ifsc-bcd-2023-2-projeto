package engtelecom.bcd.repository;

import engtelecom.bcd.model.Insignias;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InsigniasRepository extends CrudRepository<Insignias, Integer> {
    Optional<Insignias> findInsigniasByNome(String nome);
}
