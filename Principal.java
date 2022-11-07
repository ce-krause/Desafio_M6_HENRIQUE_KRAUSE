import java.util.Scanner;

import construtores.MEC;
import exceptions.DadoInvalidoException;
import universidade.Universidade;
import universidade.filhas.Privada;
import universidade.filhas.Publica;

public class Principal {

    public static void main(String[] args) {

        MEC mec = new MEC();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDefina o tamanho:");

        int tamanho = scanner.nextInt();

        if (tamanho <= 0) {

            scanner.close();

            throw new DadoInvalidoException("\nTamanho inválido.");

        } else {

            Scanner scannerCidade = new Scanner(System.in);
            Scanner scannerEstado = new Scanner(System.in);
            Universidade[] universidades = new Universidade[tamanho];

            while (true) {

                System.out.println("\nDigite o índice:");

                int indice = scanner.nextInt();

                if (indice < 0 || indice > universidades.length) {

                    scanner.close();

                    throw new DadoInvalidoException("Índice inválido.");

                } else {

                    System.out.println("\n(1) Público");
                    System.out.println("(2) Privado");
                    System.out.println("\nDigite o tipo da universidade:");

                    int tipoUniversidade = scanner.nextInt();

                    if (tipoUniversidade == 1) {

                        mec.setDados();

                        String nome = mec.getNome();
                        int quantidadeAlunos = mec.getQuantidadeAlunos();
                        int quantidadeProfessores = mec.getQuantidadeProfessores();

                        System.out.println("\nDefina o estado:");

                        String estado = scannerEstado.nextLine();

                        if (estado.isEmpty()) {

                            throw new DadoInvalidoException("Estado inválido.");

                        } else {

                            System.out.println("\nDefina a cidade:");

                            String cidade = scannerCidade.nextLine();

                            if (cidade.isEmpty()) {

                                throw new DadoInvalidoException("Cidade inválida.");

                            } else {

                                universidades[indice] = new Publica(nome, quantidadeAlunos, quantidadeProfessores,
                                        estado, cidade);
                                        
                            }

                        }

                    } else if (tipoUniversidade == 2) {

                        mec.setDados();

                        String nome = mec.getNome();
                        int quantidadeAlunos = mec.getQuantidadeAlunos();
                        int quantidadeProfessores = mec.getQuantidadeProfessores();

                        System.out.println("\nDefina o valor da mensalidade:");

                        double mensalidade = scanner.nextDouble();

                        if (mensalidade <= 0) {

                            throw new DadoInvalidoException("Mensalidade inválida.");

                        } else {

                            universidades[indice] = new Privada(nome, quantidadeAlunos, quantidadeProfessores, mensalidade);

                        }

                    }

                }

            }

            // scannerCidade.close();
            // scannerEstado.close();

        }

        // scanner.close();

    }

}
