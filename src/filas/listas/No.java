package filas.listas;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class No {

    String valor;
    No anterior;
    No proximo;

    public No(String valor){
        this.valor = valor;
    }
}
