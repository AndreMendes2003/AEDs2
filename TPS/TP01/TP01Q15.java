public class TP01Q15 {

    public static void main(String[] args) {
        processarEntrada();
    }

    public static void processarEntrada() {
        String entrada = MyIO.readLine();
        if (!entrada.isEmpty()) {
            boolean vogal = verificaVogal(entrada);
            boolean consoante = verificaConsoante(entrada);
            boolean inteiro = verificaNumInteiro(entrada);
            boolean real = verificaNumReal(entrada);

            MyIO.println(
                (vogal ? "SIM" : "NAO") + " " +
                (consoante ? "SIM" : "NAO") + " " +
                (inteiro ? "SIM" : "NAO") + " " +
                (real ? "SIM" : "NAO")
            );

            processarEntrada();
        }
    }

    public static boolean verificaVogal(String str) {
        for (char c : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificaConsoante(String str) {
        for (char c : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1 || !Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificaNumInteiro(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean verificaNumReal(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
