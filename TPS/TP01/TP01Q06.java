/*Crie um método iterativo que recebe uma string e retorna true se a mesma é composta somente por vogais. 
Crie outro método iterativo que recebe uma string e retorna true se a mesma é composta somente por consoantes. 
Crie um terceiro método iterativo que recebe uma string e retorna true se a mesma corresponde a um número inteiro. 
Crie um quarto método iterativo que recebe uma string e retorna true se a mesma corresponde a um número real.

Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma X1 X2 X3 X4 onde cada Xi é um booleano indicando se a é entrada é: 
composta somente por vogais (X1); composta somente somente por consoantes (X2); um número inteiro (X3); um número real (X4). 
Se Xi for verdadeiro, seu valor será SIM, caso contrário, NÃO. */

public class TP01Q06 {

    public static void main(String[] args) {
        
        while (true) {
            String entrada = MyIO.readLine();
            if (entrada.isEmpty()) {
                break; // Sai do loop quando a entrada estiver vazia
            }

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
