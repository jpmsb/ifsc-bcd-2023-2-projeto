package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private Date dataNascimento;

    private String telefone;

    private String email;

    @NonNull
    @JoinColumn(name = "idTipoSanguineo", nullable = false)
    @ManyToOne
    private TipoSanguineo tipoSanguineo;

    @ManyToMany
    @JoinTable(
            name = "Vinculo",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idResponsavel")
    )
    private List<Responsavel> responsaveis;

    @ManyToMany
    @JoinTable(
            name = "NoitesAcampadas",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idAcampamento")
    )
    private List<Acampamentos> acampamentos;

    @ManyToMany
    @JoinTable(
            name = "DadosDeSaude",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idProblemaDeSaude")
    )
    private List<ProblemasDeSaude> problemasDeSaude;

    @OneToMany(mappedBy = "pessoa")
    public List<AtividadesDeInsigniasFeitas> atividades = new ArrayList<>();
}
