package engtelecom.bcd.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class DadosDeSaude {
    @EmbeddedId
    private DadosDeSaudeId id;

    @ManyToOne
    @MapsId("idPessoa")
    private Pessoa pessoa;

    @ManyToOne
    @MapsId("idProblemaDeSaude")
    private ProblemasDeSaude problemaDeSaude;
}
