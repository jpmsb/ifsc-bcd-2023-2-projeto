package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AtividadesDeInsignias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtividade;

    @NonNull
    @Column(nullable = false)
    private String descricao;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idInsignia", nullable = false)
    private Insignias insignia;

    @OneToMany(mappedBy = "atividadeDeInsignia")
    public List<AtividadesDeInsigniasFeitas> atividades = new ArrayList<>();
}
