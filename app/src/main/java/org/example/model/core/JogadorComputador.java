package org.example.model.core;

import org.example.factory.FrotaFactory;
import org.example.model.embarcacoes.*;
import org.example.model.enums.Dificuldade;
import org.example.model.enums.Orientacao;
import org.example.utils.PosicionamentoUtils;

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

                List<Coordenada> posicoes = PosicionamentoUtils.calcularPosicoes(modelo, new Coordenada(linha, coluna), orientacao);
                Embarcacao novaEmbarcacao = PosicionamentoUtils.criarEmbarcacaoFinal(modelo, posicoes, dificuldade);

                if (tabuleiro.posicionarEmbarcacao(novaEmbarcacao)) {
                    posicionado = true;
                }
            }
        }
        System.out.println("Frota do " + this.nome + " posicionada.");
    }

    /**
     * Método para atirar aleatoriamente com uma embarcação.
     * @param adversario O jogador que receberá o tiro.
     */
    @Override
    public void realizarJogada(Jogador adversario) {
        System.out.println("\n" + this.nome + " está realizando uma jogada...");
        // TODO: Implementar a lógica para o computador escolher um alvo aleatoriamente.
        System.out.println("(Lógica de tiro aleatório a ser implementada)");
    }
}
