public class TP01Q12 {
    public static String Ciframento(String palavra, int i) {
        if (i == palavra.length()) {
            return "";
        } else {
            int pos = (int) palavra.charAt(i) + 3;
            char caractereCifrado = (char) pos;
            return caractereCifrado + Ciframento(palavra, i + 1);
        }
    }

    public static void main(String[] args) {
        String palavra;

        while (true) {
            palavra = MyIO.readLine();

            if (palavra.equals("FIM")) {
                break;
            }

            String s = Ciframento(palavra, 0);
            MyIO.println(s);
        }
    }
}
