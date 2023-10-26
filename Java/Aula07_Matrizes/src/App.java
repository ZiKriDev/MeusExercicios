/*
 * 
 * Estudo de caso 04: Fazer um programa para ler dois números inteiros M e N, e depois ler uma matriz de 
 * M linhas por N colunas contendo números inteiros, podendo haver repetições. Em seguida, ler um número 
 * inteiro X que pertence à matriz. Para cada ocorrência de X, mostrar os valores à esquerda, acima, à 
 * direita e abaixo de X, quando houver.
 * 
 * 
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int x = input.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == x) {
                    System.out.println("Position " + i + "," + j);

                    if (!(j == 0)) {
                        System.out.println("Left: " + matrix[i][j - 1]);
                    }

                    if (!(j == (matrix[i].length - 1))) {
                        System.out.println("Right: " + matrix[i][j + 1]);
                    }

                    if (!(i == 0)) {
                        System.out.println("Up: " + matrix[i - 1][j]);
                    }

                    if (!(i == (matrix.length - 1))) {
                        System.out.println("Down: " + matrix[i + 1][j]);
                    }
                }
            }
        }

        input.close();
    }
}
