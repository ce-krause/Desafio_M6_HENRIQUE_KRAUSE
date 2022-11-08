package construtores;

import universidade.Universidade;

public class MEC extends ConstrutorUniversidade {

    public void imprimeUniversidades(Universidade[] universidades) {

        System.out.println("\nImprimindo dados das universidades instanciadas:\n");

        for (Universidade universidade : universidades) {
            
            universidade.imprimeInfo();
        
        }

    }

}
