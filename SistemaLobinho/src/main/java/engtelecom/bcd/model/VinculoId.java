package engtelecom.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VinculoId implements Serializable {
    @Column
    private Integer idPessoa;

    @Column
    private Integer idResponsavel;
}
