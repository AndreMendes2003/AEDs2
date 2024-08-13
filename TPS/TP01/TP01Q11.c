/*Refaça a questão anterior na linguagem C.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool verificaPalindromo(char texto[], int inicio, int fim) {
    // Caso base: quando a string tem tamanho 0 ou 1, é um palíndromo.
    if (inicio >= fim) {
        return true;
    }

    
    if (texto[inicio] != texto[fim]) {
        return false;
    }

    // Chamada recursiva com a string restante.
    return verificaPalindromo(texto, inicio + 1, fim - 1);
}

int main() {
    char texto[500];
    int fim = 0;
    do {
        scanf(" %[^\n]", texto);
       
        if (strcmp(texto, "FIM") == 0) {
            fim = 1;
        } else {
            int tamanho = strlen(texto);
            bool resp = verificaPalindromo(texto, 0, tamanho - 1);
            if (resp) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    } while (!fim);

    return 0;
}
