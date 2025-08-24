package org.example.model.core;

import org.example.factory.FrotaFactory;
import org.example.model.embarcacoes.*;
import org.example.model.enums.Dificuldade;
import org.example.model.enums.Orientacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class JogadorComputador extends Jogador {

    private final Dificuldade dificuldade;

    public JogadorComputador(Dificuldade dificuldade) {

        super("Computador", dificuldade);
        this.dificuldade = dificuldade;
    }

    /**
     * Realiza o posicionamento automático das embarcações.
     */
    @Override
    public void posicionarFrota() {
        System.out.println("\n" + this.nome + " está posicionando a frota...");
        List<Embarcacao> frotaParaPosicionar = FrotaFactory.criarFrota(dificuldade);
        Random random = ThreadLocalRandom.current();

        for (Embarcacao modelo : frotaParaPosicionar) {
            boolean posicionado = false;
            while (!posicionado) {
                int linha = random.nextInt(tabuleiro.getTamanho());
                int coluna = random.nextInt(tabuleiro.getTamanho());
                Orientacao orientacao = Orientacao.values()[random.nextInt(Orientacao.values().length)];

                List<Coordenada> posicoes = calcularPosicoes(modelo, new Coordenada(linha, coluna), orientacao);

                // Cria a instância final da embarcação com as posições
                Embarcacao novaEmbarcacao = criarEmbarcacaoFinal(modelo, posicoes);

                if (tabuleiro.posicionarEmbarcacao(novaEmbarcacao)) {
                    posicionado = true;
                }
            }
        }
        System.out.println("Frota do " + this.nome + " posicionada.");
    }

    /**
     * Calcula a posição que cada embarcação ocupará no reticulado.
     * @param embarcacao Objeto do tipo Embarcacao
     * @param inicio Coordenada da primeira posição da embarcação.
     * @param orientacao Vertical ou Horizontal.
     * @return Lista com as coordenadas da embarcação.
     */
    private List<Coordenada> calcularPosicoes(Embarcacao embarcacao, Coordenada inicio, Orientacao orientacao) {
        List<Coordenada> posicoes = new ArrayList<>();
        for (int i = 0; i < embarcacao.getTamanho(); i++) {
            if (orientacao == Orientacao.HORIZONTAL) {
                posicoes.add(new Coordenada(inicio.linha(), inicio.coluna() + i));
            } else { // VERTICAL
                posicoes.add(new Coordenada(inicio.linha() + i, inicio.coluna()));
            }
        }
        return posicoes;
    }

    /**
     * Cria a embarcação, seguindo as particularidades de cada dificuldade e de
     * cada tipo de embarcação.
     * @param modelo Objeto do tipo Embarcacao.
     * @param posicoes Lista com as coordenadas que a embarcação ocupará no reticulado.
     * @return Objeto do tipo Embarcacao com os atributos preenchidos.
     */
    private Embarcacao criarEmbarcacaoFinal(Embarcacao modelo, List<Coordenada> posicoes) {
        if (modelo instanceof PortaAvioes) return new PortaAvioes(posicoes, dificuldade);
        if (modelo instanceof Cruzador) return new Cruzador(posicoes, dificuldade);
        if (modelo instanceof Fragata) return new Fragata(posicoes, dificuldade);
        if (modelo instanceof Destroier) return new Destroier(posicoes, dificuldade);
        if (modelo instanceof Submarino) return new Submarino(posicoes, dificuldade);
        throw new IllegalArgumentException("Tipo de embarcação desconhecido");
    }

    /**
     * Método para atirar aleatóriamente com uma embarcação.
     * @param adversario O jogador que receberá o tiro.
     */
    @Override
    public void realizarJogada(Jogador adversario) {
        System.out.println("\n" + this.nome + " está realizando uma jogada...");
        // TODO: Implementar a lógica para o computador escolher um alvo aleatoriamente.
        System.out.println("(Lógica de tiro aleatório a ser implementada)");
    }
}
