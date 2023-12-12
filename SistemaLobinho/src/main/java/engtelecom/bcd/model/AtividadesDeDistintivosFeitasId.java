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
public class AtividadesDeDistintivosFeitasId implements Serializable {
    private Integer atividadeDeDistintivo;
    private Integer pessoa;
}
