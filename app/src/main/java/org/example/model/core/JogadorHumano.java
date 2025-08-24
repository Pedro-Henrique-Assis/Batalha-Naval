package org.example.model.core;

import org.example.model.enums.Dificuldade;
public class JogadorHumano extends Jogador {
    public JogadorHumano(String nome, Dificuldade dificuldade) {
        super(nome, dificuldade);
    }

    /**
     * Realiza o posicionamento manual das embarcações
     */
    @Override
    public void posicionarFrota() {
        System.out.println("\n" + this.nome + ", posicione sua frota.");
        // TODO: Implementar a lógica para o jogador humano inserir coordenadas e orientações.
        System.out.println("(Lógica de posicionamento manual a ser implementada)");
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
