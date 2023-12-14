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
@IdClass(AtividadesDeDistintivosFeitasId.class)
public class AtividadesDeDistintivosFeitas implements Serializable {
    @Id
    @ManyToOne
    private AtividadesDeDistintivos atividadeDeDistintivo;

    @Id
    @ManyToOne
    private Pessoa pessoa;

    @NonNull
    @Column(nullable = false)
    private Date data;
}
