public class TP01Q10 {
    public static boolean verificaPalindromo(String texto) {
        int tamanho = texto.length();
        // Caso base: se o texto tiver 0 ou 1 caracteres, é um palíndromo
        if (tamanho <= 1) {
            return true;
        }
        
     
        if (texto.charAt(0) != texto.charAt(tamanho - 1)) {
            return false;
        }
        
        // Chamada recursiva: verifique o palíndromo sem o primeiro e último caractere
        return verificaPalindromo(texto.substring(1, tamanho - 1));
    }

    public static void main(String[] args) {
        String texto;
        int fim = 0;
        do {
            texto = MyIO.readLine();
            if (texto.equals("FIM")) {
                fim = 1;
            } else {
                boolean resp = verificaPalindromo(texto);
                if (resp) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        } while (fim != 1);
    }
}

