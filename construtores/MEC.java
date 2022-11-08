package construtores;

import universidade.Universidade;
import universidade.filhas.Publica;

public class MEC extends ConstrutorUniversidade {

    public void imprimeUniversidades(Universidade[] universidades) {

        System.out.println("\nImprimindo dados das universidades instanciadas:\n");

        for (Universidade universidade : universidades) {

            try {

                System.out.println(universidade.toString());
                universidade.imprimeInfo();

            } catch (NullPointerException nullPointerException) {

            }

        }

    }

    public void universidadesDoSul(Universidade[] universidades) {

        System.out.println("\nImprimindo dados das universidades públicas da região Sul instanciadas:\n");

        for (Universidade universidade : universidades) {

            if (universidade.toString() == "Universidade Pública") {

                Publica universidadePublica = (Publica) universidade;

                if (universidadePublica.getEstado().contains("RS") || universidadePublica.getEstado().contains("SC")
                        || universidadePublica.getEstado().contains("PR")) {

                    universidadePublica.imprimeInfo();

                }

            }

        }

    }

}
