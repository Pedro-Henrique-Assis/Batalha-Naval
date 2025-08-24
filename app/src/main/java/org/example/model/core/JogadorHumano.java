package org.example.model.core;

import org.example.factory.FrotaFactory;
import org.example.model.embarcacoes.*;
import org.example.model.enums.Dificuldade;
import org.example.model.enums.Orientacao;
import org.example.utils.ConsoleUtils;
import org.example.utils.PosicionamentoUtils;

import java.util.List;

public class JogadorHumano extends Jogador {

    private final Dificuldade dificuldade;

    public JogadorHumano(String nome, Dificuldade dificuldade) {
        super(nome, dificuldade);
        this.dificuldade = dificuldade;
    }

    /**
     * Realiza o posicionamento manual das embarcações
     */
    @Override
    public void posicionarFrota() {
        System.out.println("\n" + this.nome + ", posicione sua frota.");
        List<Embarcacao> frotaParaPosicionar = FrotaFactory.criarFrota(dificuldade);

        for (Embarcacao modelo : frotaParaPosicionar) {
            boolean posicionado = false;
            while (!posicionado) {
                System.out.println("\nSeu tabuleiro atual:");
                tabuleiro.exibir();
                System.out.println("Posicionando: " + modelo.getNome() + " (Tamanho: " + modelo.getTamanho() + ")");

                Coordenada inicio = ConsoleUtils.lerCoordenada(tabuleiro.getTamanho());
                Orientacao orientacao = ConsoleUtils.lerOrientacao();

                List<Coordenada> posicoes = PosicionamentoUtils.calcularPosicoes(modelo, inicio, orientacao);
                Embarcacao novaEmbarcacao = PosicionamentoUtils.criarEmbarcacaoFinal(modelo, posicoes, dificuldade);

                if (tabuleiro.posicionarEmbarcacao(novaEmbarcacao)) {
                    System.out.println(modelo.getNome() + " posicionado com sucesso!");
                    posicionado = true;
                } else {
                    System.out.println("Posição inválida! A embarcação sairia do tabuleiro ou se sobrepõe a outra. Tente novamente.");
                }
            }
        }
        System.out.println("\nSua frota foi posicionada! Tabuleiro final:");
        tabuleiro.exibir();
    }

    /**
     * Método para atirar com uma embarcação
     * @param adversario O jogador que receberá o tiro.
     */
    @Override
    public void realizarJogada(Jogador adversario) {
        System.out.println("\nSua vez de atirar, " + this.nome + "!");
        // TODO: Implementar a lógica para o jogador escolher embarcação, tipo de tiro e alvo.
        System.out.println("(Lógica de tiro a ser implementada)");
    }
}
