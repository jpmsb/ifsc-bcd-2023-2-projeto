package engtelecom.bcd.repository;

import engtelecom.bcd.model.AtividadesDeDistintivos;
import engtelecom.bcd.model.Distintivos;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AtividadesDeDistintivosRepository extends CrudRepository<AtividadesDeDistintivos, Integer> {
    ArrayList<AtividadesDeDistintivos> findAllByDistintivoOrderByIdAtividade(Distintivos distintivo);
}
