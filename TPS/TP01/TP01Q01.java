
public class TP01Q01 {
    public static boolean verificaPalindromo(String texto) {
        int tamanho = texto.length();
        boolean r = true;
        for (int i = 0; i < tamanho; i++) {
            if (texto.charAt(i) != texto.charAt(tamanho - 1 - i)) {
                r = false;
                i = tamanho;
            }
        }
        return r;
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
