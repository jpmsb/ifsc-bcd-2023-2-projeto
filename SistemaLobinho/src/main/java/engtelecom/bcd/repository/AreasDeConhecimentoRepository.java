package engtelecom.bcd.repository;

import engtelecom.bcd.model.AreasDeConhecimento;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AreasDeConhecimentoRepository extends CrudRepository<AreasDeConhecimento, Integer> {
    Optional<AreasDeConhecimento> findAreasDeConhecimentoByNome(String area);
}