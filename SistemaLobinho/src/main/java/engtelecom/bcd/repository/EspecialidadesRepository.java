package engtelecom.bcd.repository;

import engtelecom.bcd.model.Especialidades;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EspecialidadesRepository extends CrudRepository<Especialidades, Integer> {
    Optional<Especialidades> findEspecialidadesByNome(String nome);
}