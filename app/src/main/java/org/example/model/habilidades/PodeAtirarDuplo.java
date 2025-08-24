package org.example.model.habilidades;

import org.example.model.enums.TipoTiro;
import java.util.Set;

public interface PodeAtirarDuplo {
    default void adicionarTiroDuplo(Set<TipoTiro> tiros) {
        if (getMunicaoTiroDuplo() > 0) {
            tiros.add(TipoTiro.DUPLO);
        }
    }

    int getMunicaoTiroDuplo();
    void usarTiroDuplo();
}
