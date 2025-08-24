package org.example;

import org.example.model.enums.Dificuldade;

public class App {

    public static void main(String[] args) {
        // Por enquanto, vamos iniciar o jogo diretamente no modo FÁCIL.
        // Mais tarde, implementaremos o menu para o jogador escolher.
        Dificuldade dificuldadeEscolhida = Dificuldade.FACIL;

        Jogo jogo = new Jogo(dificuldadeEscolhida);
        jogo.iniciar();
    }
}
