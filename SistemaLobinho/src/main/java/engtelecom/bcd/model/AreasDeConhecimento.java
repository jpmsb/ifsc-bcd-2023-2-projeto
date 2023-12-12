package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AreasDeConhecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaDeConhecimento;

    @NonNull
    @Column(nullable = false)
    private String nome;
}
