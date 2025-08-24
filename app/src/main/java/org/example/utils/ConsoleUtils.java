package org.example.utils;

import org.example.model.core.Coordenada;
import org.example.model.enums.Orientacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lê uma coordenada (linha e coluna) do usuário.
     * @param tamanhoMax O tamanho máximo do tabuleiro para validação.
     * @return A Coordenada lida.
     */
    public static Coordenada lerCoordenada(int tamanhoMax) {
        while (true) {
            try {
                System.out.print("Digite a linha: ");
                int linha = scanner.nextInt();
                System.out.print("Digite a coluna: ");
                int coluna = scanner.nextInt();

                if (linha >= 0 && linha < tamanhoMax && coluna >= 0 && coluna < tamanhoMax) {
                    return new Coordenada(linha, coluna);
                } else {
                    System.out.println("Coordenada fora dos limites do tabuleiro. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite números inteiros.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
    }

    /**
     * Lê a orientação (Horizontal ou Vertical) do usuário.
     * @return A Orientacao escolhida.
     */
    public static Orientacao lerOrientacao() {
        while (true) {
            System.out.print("Digite a orientação (H para Horizontal, V para Vertical): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("H")) {
                return Orientacao.HORIZONTAL;
            } else if (input.equals("V")) {
                return Orientacao.VERTICAL;
            } else {
                System.out.println("Orientação inválida. Tente novamente.");
            }
        }
    }
}
