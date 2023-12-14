package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(AtividadesDeInsigniasFeitasId.class)
public class AtividadesDeInsigniasFeitas implements Serializable {
    @Id
    @NonNull
    @ManyToOne
    private AtividadesDeInsignias atividadeDeInsignia;

    @Id
    @NonNull
    @ManyToOne
    private Pessoa pessoa;

    @NonNull
    @Column(nullable = false)
    private Date data;
}
