package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(AtividadesDeEspecialidadesFeitasId.class)
public class AtividadesDeEspecialidadesFeitas {
    @Id
    @ManyToOne
    private AtividadesDeEspecialidades atividadeDeEspecialidade;

    @Id
    @ManyToOne
    private Pessoa pessoa;

    @NonNull
    @Column(nullable = false)
    private Date data;
}
