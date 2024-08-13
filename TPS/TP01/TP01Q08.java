import java.io.*;

public class TP01Q08 {
    public static void main(String[] args) {
        try {
            // Leitura do número de valores a serem lidos
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
          
            int n = Integer.parseInt(reader.readLine());

            // Abrindo arquivo para escrita
            RandomAccessFile file = new RandomAccessFile("valores.txt", "rw");

         
            for (int i = 0; i < n; i++) {
                double value = Double.parseDouble(reader.readLine());
                file.writeDouble(value);
            }

            // Fechando o arquivo
            file.close();

            // Reabrindo o arquivo para leitura reversa
            file = new RandomAccessFile("valores.txt", "r");

            // Navegando para o final do arquivo
            long filePointer = file.length();

            
            while (filePointer > 0) {
                filePointer -= 8; // Cada número real ocupa 8 bytes
                file.seek(filePointer);
                double value = file.readDouble();
                if (value % 1 == 0) { // Verifica se é um número inteiro
                    MyIO.println((int)value); // Imprime apenas a parte inteira
                } else {
                    MyIO.println(value);
                }
            }

            // Fechando o arquivo
            file.close();

        } catch (IOException e) {
            MyIO.println(e.getMessage());
        } 
    }
}
