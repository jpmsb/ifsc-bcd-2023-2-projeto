package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"pessoas"})
public class Acampamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcampamento;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private Date data;

    @ManyToMany(mappedBy = "acampamentos", fetch = FetchType.EAGER)
    private Set<Pessoa> pessoas;
}