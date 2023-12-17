package engtelecom.bcd.repository;

import engtelecom.bcd.model.AtividadesDeEspecialidades;
import engtelecom.bcd.model.AtividadesDeEspecialidadesFeitas;
import engtelecom.bcd.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

public interface AtividadesDeEspecialidadesFeitasRepository extends CrudRepository<AtividadesDeEspecialidadesFeitas, Integer> {
    Iterable<AtividadesDeEspecialidadesFeitas> findAllByPessoaAndAtividadeDeEspecialidade(Pessoa pessoa, AtividadesDeEspecialidades atividadeDeEspecialidade);
    Iterable<AtividadesDeEspecialidadesFeitas> findAllByPessoa(Pessoa pessoa);

    ArrayList<AtividadesDeEspecialidadesFeitas> findAllByPessoaOrderByData(Pessoa pessoa);
    AtividadesDeEspecialidadesFeitas findAtividadesDeEspecialidadesFeitasByPessoaAndAtividadeDeEspecialidade(Pessoa pessoa, AtividadesDeEspecialidades atividadeDeEspecialidade);
}
