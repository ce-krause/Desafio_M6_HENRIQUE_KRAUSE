package construtores;

import exceptions.ArrayInvalidoException;
import universidade.Universidade;
import universidade.filhas.Privada;
import universidade.filhas.Publica;

public class MEC extends ConstrutorUniversidade {

    private int quantidadePublicaSul;
    private int quantidadePrivada;

    public void setQuantidadePublicaSul() {

        this.quantidadePublicaSul++;

    }

    public void setQuantidadePrivada() {

        this.quantidadePrivada++;

    }

    public void imprimeUniversidades(Universidade[] universidades) {

        this.getDivisoria();
        this.getDivisoria();
        this.getDivisoria();
        this.getDivisoria();
        this.getDivisoria();

        System.out.println("Imprimindo dados das universidades instanciadas:\n");

        for (Universidade universidade : universidades) {

            try {

                System.out.println(universidade.toString());
                universidade.imprimeInfo();

            } catch (NullPointerException nullPointerException) {

            }

        }

    }

    public void maisCara(Universidade[] universidades) {

        if (this.quantidadePrivada == 0) {

            throw new ArrayInvalidoException("Array inválido. Nenhuma universidade privada instanciada.");

        } else {

            Privada universidadePrivada = null;

            double mensalidade = 0;

            System.out.println("Imprimindo dados da universidade privada mais cara instanciada:\n");

            for (Universidade universidade : universidades) {

                if (universidade.toString().contains("Universidade Privada")) {

                    universidadePrivada = (Privada) universidade;

                    if (universidadePrivada.getValorMensalidade() > mensalidade) {

                        mensalidade = universidadePrivada.getValorMensalidade();

                    }

                }

            }

            universidadePrivada.imprimeInfo();
            
            System.out.println("---\n");

        }

    }

    public void universidadesDoSul(Universidade[] universidades) {

        if (this.quantidadePublicaSul == 0) {

            throw new ArrayInvalidoException("Array inválido. Nenhuma universidade pública da região sul instanciada.");

        } else {

            System.out.println("Imprimindo dados das universidades públicas da região Sul instanciadas:\n");

            for (Universidade universidade : universidades) {

                if (universidade.toString().contains("Universidade Pública")) {
    
                    Publica universidadePublica = (Publica) universidade;
                    String estado = universidadePublica.getEstado().toUpperCase();
    
                    if (estado.contains("RS") || estado.contains("SC")
                            || estado.contains("PR")) {
    
                        universidadePublica.imprimeInfo();
    
                    }
    
                }
    
            }

        }

    }

}
