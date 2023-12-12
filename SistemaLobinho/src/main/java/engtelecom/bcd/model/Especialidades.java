package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Especialidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidade;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idAreaDeConhecimento", nullable = false)
    private AreasDeConhecimento areaDeConhecimento;
}