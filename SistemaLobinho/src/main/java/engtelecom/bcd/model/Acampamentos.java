package engtelecom.bcd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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

    @ManyToMany(mappedBy = "acampamentos")
    private List<Pessoa> pessoas;
}