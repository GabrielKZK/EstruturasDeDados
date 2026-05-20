package pilhas.desafio;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Parentese {

    private char valor;
    Parentese proximo;
}
