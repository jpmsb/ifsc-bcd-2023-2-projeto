package engtelecom.bcd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AtividadesDeInsigniasFeitasId implements Serializable {
    private Integer atividadeDeInsignia;
    private Integer pessoa;
}
