package engtelecom.bcd.repository;

import engtelecom.bcd.model.AtividadesDeEspecialidades;
import engtelecom.bcd.model.Especialidades;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface AtividadesDeEspecialidadesRepository extends CrudRepository<AtividadesDeEspecialidades, Integer> {
    ArrayList<AtividadesDeEspecialidades> findAllByEspecialidadeOrderByIdAtividade(Especialidades especialidades);
}
