package gnia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GNIA {
    private static ArrayList<Integer> numeros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
 
        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Adicionar Número");
            System.out.println("2. Listar Números");
            System.out.println("3. Listar Pares");
            System.out.println("4. Listar Ímpares");
            System.out.println("5. Atualizar Número");
            System.out.println("6. Deletar Número");
            System.out.println("7. Buscar Número");
            System.out.println("8. Exibir Média dos Números");
            System.out.println("9. Exibir Número Máximo e Mínimo");
            System.out.println("10. Ordenar Lista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido!");
                scanner.next(); 
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarNumero();
                    break;
                case 2:
                    listarNumeros();
                    break;
                case 3:
                    listarPares();
                    break;
                case 4:
                    listarImpares();
                    break;
                case 5:
                    atualizarNumero();
                    break;
                case 6:
                    deletarNumero();
                    break;
                case 7:
                    buscarNumero();
                    break;
                case 8:
                    exibirMedia();
                    break;
                case 9:
                    exibirMinMax();
                    break;
                case 10:
                    ordenarLista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarNumero() {
        System.out.print("Digite um número para adicionar: ");
        int numero = scanner.nextInt();
        numeros.add(numero);
        System.out.println("Número adicionado!");
    }

    private static void listarNumeros() {
        System.out.println("Lista de Números: " + numeros);
    }

    private static void listarPares() {
        System.out.print("Números Pares: ");
        numeros.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void listarImpares() {
        System.out.print("Números Ímpares: ");
        numeros.stream().filter(n -> n % 2 != 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void atualizarNumero() {
        System.out.print("Digite o índice do número a ser atualizado: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < numeros.size()) {
            System.out.print("Digite o novo valor: ");
            int novoValor = scanner.nextInt();
            numeros.set(indice, novoValor);
            System.out.println("Número atualizado!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void deletarNumero() {
        System.out.print("Digite o índice do número a ser removido: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < numeros.size()) {
            numeros.remove(indice);
            System.out.println("Número removido!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void buscarNumero() {
        System.out.print("Digite o número a ser buscado: ");
        int numero = scanner.nextInt();
        if (numeros.contains(numero)) {
            System.out.println("Número encontrado na lista!");
        } else {
            System.out.println("Número não encontrado!");
        }
    }

    private static void exibirMedia() {
        if (numeros.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        double media = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Média dos números: " + media);
    }

    private static void exibirMinMax() {
        if (numeros.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        int min = Collections.min(numeros);
        int max = Collections.max(numeros);
        System.out.println("Mínimo: " + min + ", Máximo: " + max);
    }

    private static void ordenarLista() {
        System.out.print("Escolha a ordem (1 - Crescente, 2 - Decrescente): ");
        int ordem = scanner.nextInt();
        switch (ordem) {
            case 1:
                numeros.sort(Comparator.naturalOrder());
                System.out.println("Lista ordenada em ordem crescente!");
                break;
            case 2:
                numeros.sort(Comparator.reverseOrder());
                System.out.println("Lista ordenada em ordem decrescente!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
    }

}
