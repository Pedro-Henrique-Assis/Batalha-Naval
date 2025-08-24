package org.example;

import org.example.model.enums.Dificuldade;

public class App {

    public static void main(String[] args) {
        // Por enquanto, o jogo iniciará diretamente no modo FÁCIL.
        Dificuldade dificuldadeEscolhida = Dificuldade.FACIL;

        Jogo jogo = new Jogo(dificuldadeEscolhida);
        jogo.iniciar();
    }
}
