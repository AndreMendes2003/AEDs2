public class TP01Q03 {
    public static String Ciframento (String palavra){
        String palavraCifrada = "";
        int tam = palavra.length();

        for (int i = 0; i < tam; i++){
            int pos = (int)palavra.charAt(i) + 3;
            palavraCifrada += (char)pos;
        }
        return palavraCifrada;
    }

    public static void main(String[] args) {
        String palavra;

        while (true) {
            palavra = MyIO.readLine();

            if (palavra.equals("FIM")){
                break;
            }
            
            String s = Ciframento(palavra);
            MyIO.println(s);
        }
    }
}
