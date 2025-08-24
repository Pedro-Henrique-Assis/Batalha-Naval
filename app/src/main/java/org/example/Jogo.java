package org.example;

import org.example.model.core.Jogador;
import org.example.model.core.JogadorComputador;
import org.example.model.core.JogadorHumano;
import org.example.model.enums.Dificuldade;

public class Jogo {

    private final Jogador jogador1;
    private final Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo(Dificuldade dificuldade) {
        // Por enquanto, o jogador humano sempre começa.
        // Podemos adicionar lógica para sortear quem começa depois.
        this.jogador1 = new JogadorHumano("Jogador 1", dificuldade);
        this.jogador2 = new JogadorComputador(dificuldade);
        this.jogadorAtual = jogador1;
    }

    /**
     * Inicia e executa o jogo até que haja um vencedor.
     */
    public void iniciar() {
        System.out.println("--- BEM-VINDO À BATALHA NAVAL ---");
        System.out.println("Dificuldade: " + jogador1.getTabuleiro().getTamanho() + "x" + jogador1.getTabuleiro().getTamanho());

        // Fase 1: Posicionamento das frotas
        System.out.println("\n--- FASE DE POSICIONAMENTO ---");
        jogador1.posicionarFrota();
        jogador2.posicionarFrota();

        // Fase 2: Batalha (Loop do Jogo)
        System.out.println("\n--- QUE A BATALHA COMECE! ---");
        while (true) {
            // Exibe os tabuleiros (perspectiva do jogador humano)
            System.out.println("\n--- SEU TABULEIRO (JOGADOR 1) ---");
            jogador1.getTabuleiro().exibir();
            // TODO: Adicionar um método para exibir o tabuleiro do adversário (com a "névoa de guerra")

            // Jogador atual realiza a jogada
            jogadorAtual.realizarJogada(getAdversario());

            // Verifica se o adversário perdeu
            if (getAdversario().perdeu()) {
                jogadorAtual.setVencedor(true);
                break; // Fim de jogo
            }

            // Troca o turno
            trocarTurno();
        }

        // Fase 3: Fim de Jogo
        anunciarVencedor();
    }

    private Jogador getAdversario() {
        return (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    private void trocarTurno() {
        jogadorAtual = getAdversario();
    }

    private void anunciarVencedor() {
        System.out.println("\n--- FIM DE JOGO ---");
        if (jogador1.isVencedor()) {
            System.out.println("Parabéns, " + jogador1.getNome() + "! Você venceu!");
        } else if (jogador2.isVencedor()) {
            System.out.println("O " + jogador2.getNome() + " venceu. Mais sorte na próxima vez!");
        }
    }
}
