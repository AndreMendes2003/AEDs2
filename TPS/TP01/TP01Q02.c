/*Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo.
 Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NÃO indicando se a linha é um palíndromo. 
 Destaca-se que uma linha de entrada pode ter caracteres não letras.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool verificaPalindromo(char texto[]) {
    int tamanho = strlen(texto);
    int r = true;
    for(int i = 0; i < tamanho; i++) {
        if(texto[i] != texto[tamanho - 1 - i]){
            r = false;
            i = tamanho;
        }
    }
    return r;
}

int main()
{
    char texto[500];
    int fim = 0;
    do {
       // scanf(" %[^\n\r]", texto);
        scanf(" %[^\n]", texto);
       
        if(strcmp(texto, "FIM") == 0) {
            fim = 1;
        } else {
            bool resp = verificaPalindromo(texto);
            if(resp) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    } while(!fim);

    return 0;
}