package engtelecom.bcd.repository;

import engtelecom.bcd.model.AtividadesDeEspecialidades;
import engtelecom.bcd.model.AtividadesDeInsignias;
import engtelecom.bcd.model.Especialidades;
import engtelecom.bcd.model.Insignias;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AtividadesDeInsigniasRepository extends CrudRepository<AtividadesDeInsignias, Integer> {
    ArrayList<AtividadesDeInsignias> findAllByInsigniaOrderByIdAtividade(Insignias insignia);
}
