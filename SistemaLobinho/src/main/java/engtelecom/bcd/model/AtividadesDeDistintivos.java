package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AtividadesDeDistintivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtividade;

    @NonNull
    @Column(nullable = false)
    private String descricao;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idDistintivo", nullable = false)
    private Distintivos distintivo;
}
