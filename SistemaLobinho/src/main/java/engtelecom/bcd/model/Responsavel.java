package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"pessoas"})
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResponsavel;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private String telefone;

    @NonNull
    @Column(nullable = false)
    private String email;

    @ManyToMany(mappedBy = "responsaveis", fetch = FetchType.EAGER)
    private Set<Pessoa> pessoas;
}
