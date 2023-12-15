package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
