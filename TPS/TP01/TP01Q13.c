#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *alteracaoRecursiva(char* entrada, char letra, char aux, int pos, int tam) {

  if(pos >= tam){
    return entrada;
  }

  if (entrada[pos] == letra) {
    entrada[pos] = aux; 
  } 

  return (alteracaoRecursiva(entrada, letra, aux, pos+1, tam)); 
}

int main() {
  srand(4);
  char letra = (char)('a' + (rand() % 26));
  char aux = (char)('a' + (rand() % 26));

  char *entrada = (char *)malloc(10000 * sizeof(char));

  // loop infinito até digitar FIM
  while (1) {
    scanf(" %[^\n]", entrada);
    if (strcmp(entrada, "FIM") == 0) {
      break;
    }
    int tam = strlen(entrada);
    printf("%s\n",(alteracaoRecursiva(entrada, letra, aux, 0, tam-1)));
  }

  free(entrada);

  return 0;
}