package construtores;

import java.util.Scanner;

import exceptions.DadoInvalidoException;

public abstract class ConstrutorUniversidade {

    private String nome;
    private int quantidadeAlunos, quantidadeProfessores;

    Scanner scanner = new Scanner(System.in);
    Scanner scannerNome = new Scanner(System.in);

    public String getNome() {

        return this.nome;

    }

    public int getQuantidadeAlunos() {

        return this.quantidadeAlunos;

    }

    public int getQuantidadeProfessores() {

        return this.quantidadeProfessores;

    }

    public void setDados() {

        System.out.println("\nDefina o nome:");

        this.nome = scannerNome.nextLine();

        if (this.nome.isEmpty()) {

            throw new DadoInvalidoException("Nome inválido.");

        }

        System.out.println("\nDefina a quantidade de alunos:");

        this.quantidadeAlunos = scanner.nextInt();

        if (this.quantidadeAlunos < 0) {

            throw new DadoInvalidoException("Quantidade de alunos inválida.");

        }

        System.out.println("\nDefina a quantidade de professores:");

        this.quantidadeProfessores = scanner.nextInt();

        if (this.quantidadeProfessores < 0) {

            throw new DadoInvalidoException("Quantidade de professores inválida.");

        }

    }

}
