package engtelecom.bcd.model;

import jakarta.persistence.*;

@Entity
public class Vinculos {
    @EmbeddedId
    private VinculoId id;

    @ManyToOne
    @MapsId("idPessoa")
    private Pessoa pessoa;

    @ManyToOne
    @MapsId("idResponsavel")
    private Responsavel responsavel;
}
