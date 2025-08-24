package org.example.model.embarcacoes;

import org.example.model.habilidades.PodeAtirarSimples;
import org.example.model.core.Coordenada;
import org.example.model.enums.Dificuldade;
import org.example.model.enums.TipoTiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Destroier extends Embarcacao implements PodeAtirarSimples {
    public Destroier(List<Coordenada> posicoes, Dificuldade dificuldade) {
        super("Destroier", 3, posicoes, dificuldade);
    }

    /**
     * Define qual a quantidade de tiros disponíveis a embarcação terá.
     * Nesse caso, terá uma quantidade ilimitada de tiros simples.
     * @return Set com os tiros simples
     */
    @Override
    public Set<TipoTiro> getTirosDisponiveis() {
        Set<TipoTiro> tiros = new HashSet<>();
        PodeAtirarSimples.super.adicionarTiroSimples(tiros);
        return tiros;
    }
}