package construtores;

import java.util.Scanner;

import exceptions.DadoInvalidoException;

public abstract class ConstrutorUniversidade {

    private String nome;
    private int alunos, professores;

    Scanner scanner = new Scanner(System.in);
    Scanner scannerNome = new Scanner(System.in);

    public String getNome() {

        return this.nome;

    }

    public int getAlunos() {

        return this.alunos;

    }

    public int getProfessores() {

        return this.professores;

    }

    public void setDados() {

        System.out.println("\nDefina o nome: (Ex: Universidade)");

        this.nome = scannerNome.nextLine();

        if (this.nome.isEmpty()) {

            throw new DadoInvalidoException("Nome inválido.");

        }

        System.out.println("\nDefina a quantidade de alunos: (Ex: 100)");

        this.alunos = scanner.nextInt();

        if (this.alunos < 0) {

            throw new DadoInvalidoException("Quantidade de alunos inválida.");

        }

        System.out.println("\nDefina a quantidade de professores: (Ex: 10)");

        this.professores = scanner.nextInt();

        if (this.professores < 0) {

            throw new DadoInvalidoException("Quantidade de professores inválida.");

        }

    }

    public void getDivisoria() {

        System.out.println("\n---\n");

    }

}
