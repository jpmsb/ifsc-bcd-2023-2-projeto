package engtelecom.bcd.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class NoitesAcampadas {
    @EmbeddedId
    private NoitesAcampadasId id;

    @ManyToOne
    @MapsId("idPessoa")
    private Pessoa pessoa;

    @ManyToOne
    @MapsId("idAcampamento")
    private Acampamentos acampamento;
}
