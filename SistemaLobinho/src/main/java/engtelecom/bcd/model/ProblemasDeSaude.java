package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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

    @OneToMany(mappedBy = "problemaDeSaude")
    private List<DadosDeSaude> problemasDeSaude = new ArrayList<>();
}