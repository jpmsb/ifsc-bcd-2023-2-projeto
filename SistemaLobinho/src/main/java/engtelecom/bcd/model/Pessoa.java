package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Vinculo",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idResponsavel")
    )
    private Set<Responsavel> responsaveis = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "NoitesAcampadas",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idAcampamento")
    )
    private Set<Acampamentos> acampamentos = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "DadosDeSaude",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idProblemaDeSaude")
    )
    private Set<ProblemasDeSaude> problemasDeSaude = new HashSet<>();

    @OneToMany(mappedBy = "pessoa")
    public List<AtividadesDeInsigniasFeitas> atividades = new ArrayList<>();

    public boolean adicionarResponsavel(Responsavel responsavel){
        return this.responsaveis.add(responsavel);
    }

    public boolean adicionarDadoSaude(ProblemasDeSaude problemaDeSaude){
        return this.problemasDeSaude.add(problemaDeSaude);
    }
}
