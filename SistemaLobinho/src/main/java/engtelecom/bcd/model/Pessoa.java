package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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

    @OneToMany(mappedBy = "pessoa")
    private List<Vinculos> vinculos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa")
    private List<NoitesAcampadas> noitesAcampadas;

    @OneToMany(mappedBy = "pessoa")
    private List<DadosDeSaude> dadosDeSaude = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa")
    public List<AtividadesDeInsigniasFeitas> atividades = new ArrayList<>();
}
