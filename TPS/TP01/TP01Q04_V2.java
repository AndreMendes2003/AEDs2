import java.util.Random;


public class TP01Q04_V2 {
    
    public static String alteracaoAleatoria(String palavra, char letra1, char letra2) {
        StringBuilder resultado = new StringBuilder();

        for (char c : palavra.toCharArray()) {
            if (c == letra1) {
                resultado.append(letra2); // substitui a letra se for igual a letra1
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
    public static void main(String[] args) {
       
        Random gerador = new Random();
        gerador.setSeed(4);

        while (true) {
            String palavra = MyIO.readLine();

            if (palavra.equals("FIM")) {
                break;
            }

            // gera duas letras minúsculas aleatórias
            char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            String resultado = alteracaoAleatoria(palavra, letra1, letra2);
            MyIO.println(resultado);
        }

    }

}
