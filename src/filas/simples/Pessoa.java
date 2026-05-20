package filas.simples;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {

    public String nome;
    public Pessoa proximo;

}
