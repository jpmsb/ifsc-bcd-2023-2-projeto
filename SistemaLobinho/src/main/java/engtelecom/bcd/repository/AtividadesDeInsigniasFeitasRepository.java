package engtelecom.bcd.repository;

import engtelecom.bcd.model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AtividadesDeInsigniasFeitasRepository extends CrudRepository<AtividadesDeInsigniasFeitas, Integer> {
    ArrayList<AtividadesDeInsigniasFeitas> findAllByPessoaOrderByData(Pessoa pessoa);

    AtividadesDeInsigniasFeitas findAtividadesDeInsigniasFeitasByPessoaAndAtividadeDeInsignia(Pessoa pessoa, AtividadesDeInsignias atividadeDeInsignia);
}
