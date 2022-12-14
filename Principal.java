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

        boolean continuar = true;

        System.out.println("\nDefina o tamanho: (Ex: 10)");

        int tamanho = scanner.nextInt();

        if (tamanho <= 0) {

            scanner.close();

            throw new DadoInvalidoException("Tamanho inválido.");

        } else {

            Scanner scannerCidade = new Scanner(System.in);
            Scanner scannerEstado = new Scanner(System.in);
            Universidade[] universidades = new Universidade[tamanho];

            while (continuar) {

                mec.getDivisoria();

                System.out.println("Digite o índice: (Ex: 0)");

                int indice = scanner.nextInt();

                if (indice < 0 || indice >= universidades.length) {

                    scanner.close();
                    scannerCidade.close();
                    scannerEstado.close();

                    throw new DadoInvalidoException("Índice inválido.");

                } else {

                    System.out.println("\nDigite o tipo da universidade:\n");
                    System.out.println("(1) Pública");
                    System.out.println("(2) Privada");

                    int tipo = scanner.nextInt();

                    if (tipo == 1) {

                        mec.setDados();

                        String nome = mec.getNome();
                        int alunos = mec.getAlunos();
                        int professores = mec.getProfessores();

                        System.out.println("\nDefina o estado: (Ex: RS)");

                        String estado = scannerEstado.nextLine();

                        if (estado.isEmpty()) {

                            scanner.close();
                            scannerCidade.close();
                            scannerEstado.close();

                            throw new DadoInvalidoException("Estado inválido.");

                        } else {

                            System.out.println("\nDefina a cidade: (Ex: São Leopoldo)");

                            String cidade = scannerCidade.nextLine();

                            if (cidade.isEmpty()) {

                                scanner.close();
                                scannerCidade.close();
                                scannerEstado.close();

                                throw new DadoInvalidoException("Cidade inválida.");

                            } else {

                                universidades[indice] = new Publica(nome, alunos, professores,
                                        estado, cidade);

                                if (estado.contains("RS") || estado.contains("SC") || estado.contains("PR")) {

                                    mec.setPublicasSul();

                                }

                            }

                        }

                    } else if (tipo == 2) {

                        mec.setDados();

                        String nome = mec.getNome();
                        int alunos = mec.getAlunos();
                        int professores = mec.getProfessores();

                        System.out.println("\nDefina o valor da mensalidade: (Ex: 1000)");

                        double mensalidade = scanner.nextDouble();

                        if (mensalidade <= 0) {

                            scanner.close();
                            scannerCidade.close();
                            scannerEstado.close();

                            throw new DadoInvalidoException("Mensalidade inválida.");

                        } else {

                            universidades[indice] = new Privada(nome, alunos, professores,
                                    mensalidade);

                            mec.setPrivadas();
                        }

                    } else {

                        scanner.close();
                        scannerCidade.close();
                        scannerEstado.close();

                        throw new DadoInvalidoException("Tipo inválido.");

                    }

                }

                mec.getDivisoria();

                System.out.printf("Universidade instanciada no índice %d.%n%n", indice);
                System.out.println("Deseja instanciar outra universidade?");
                System.out.println("\n(1) Sim");
                System.out.println("(2) Não");

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

            }

            mec.imprimeUniversidades(universidades);

            System.out.println("---\n");

            mec.maisCara(universidades);
            mec.universidadesDoSul(universidades);

        }

        scanner.close();

    }

}
