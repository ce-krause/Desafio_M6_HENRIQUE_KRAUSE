import java.util.Scanner;

import construtores.MEC;
import exceptions.ArrayInvalidoException;
import exceptions.DadoInvalidoException;
import universidade.Universidade;
import universidade.filhas.Privada;
import universidade.filhas.Publica;

public class Principal {

    public static void main(String[] args) {

        MEC mec = new MEC();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        System.out.println("\nDefina o tamanho:");

        int tamanho = scanner.nextInt();

        if (tamanho <= 0) {

            scanner.close();

            throw new DadoInvalidoException("Tamanho inválido.");

        } else {

            ArrayInvalidoException arrayInvalidoException = new ArrayInvalidoException("Array inválido. A quantidade de universidades instanciadas deve ser a mesma do tamanho do array.");
            Scanner scannerCidade = new Scanner(System.in);
            Scanner scannerEstado = new Scanner(System.in);
            Universidade[] universidades = new Universidade[tamanho];

            while (continuar) {

                System.out.println("\nDigite o índice:");

                int indice = scanner.nextInt();

                if (indice < 0 || indice >= universidades.length) {

                    scanner.close();
                    scannerCidade.close();
                    scannerEstado.close();

                    throw new DadoInvalidoException("Índice inválido.");

                } else {

                    System.out.println("\n(1) Público");
                    System.out.println("(2) Privado\n");
                    System.out.println("Digite o tipo da universidade:");

                    int tipoUniversidade = scanner.nextInt();

                    if (tipoUniversidade == 1) {

                        mec.setDados();

                        String nome = mec.getNome();
                        int quantidadeAlunos = mec.getQuantidadeAlunos();
                        int quantidadeProfessores = mec.getQuantidadeProfessores();

                        System.out.println("\nDefina o estado:");

                        String estado = scannerEstado.nextLine();

                        if (estado.isEmpty()) {

                            scanner.close();
                            scannerCidade.close();
                            scannerEstado.close();

                            throw new DadoInvalidoException("Estado inválido.");

                        } else {

                            System.out.println("\nDefina a cidade:");

                            String cidade = scannerCidade.nextLine();

                            if (cidade.isEmpty()) {

                                scanner.close();
                                scannerCidade.close();
                                scannerEstado.close();

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

                            scanner.close();
                            scannerCidade.close();
                            scannerEstado.close();

                            throw new DadoInvalidoException("Mensalidade inválida.");

                        } else {

                            universidades[indice] = new Privada(nome, quantidadeAlunos, quantidadeProfessores, mensalidade);

                        }

                    } else {

                        scanner.close();
                        scannerCidade.close();
                        scannerEstado.close();

                        throw new DadoInvalidoException("Tipo inválido.");

                    }

                }

                System.out.printf("\nUniversidade instanciada no índice %d.", indice);
                System.out.println("\n(1) Sim");
                System.out.println("(2) Não");
                System.out.println("\nDeseja instanciar outra universidade?");

                int opcao = scanner.nextInt();

                if (opcao == 1) {

                    continue;

                } else if (opcao == 2) {

                    scanner.close();
                    scannerCidade.close();
                    scannerEstado.close();
                    
                    continuar = false;

                } else {

                    scanner.close();
                    scannerCidade.close();
                    scannerEstado.close();

                    throw new DadoInvalidoException("Opção inválida.");

                }

                try {

                    mec.imprimeUniversidades(universidades);

                } catch (NullPointerException nullPointerException) {

                    throw arrayInvalidoException;

                }

                System.out.println("continuou");

            }

        }

        scanner.close();

    }

}
