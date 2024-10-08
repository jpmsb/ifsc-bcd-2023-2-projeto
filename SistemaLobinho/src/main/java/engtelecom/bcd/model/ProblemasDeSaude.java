package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"pessoas"})
public class ProblemasDeSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProblemaDeSaude;

    @NonNull
    @Column(nullable = false)
    private String tipoDeProblema;

    @NonNull
    @Column(nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "problemasDeSaude", fetch = FetchType.EAGER)
    private Set<Pessoa> pessoas;
}