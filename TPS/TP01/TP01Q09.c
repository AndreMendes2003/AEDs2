#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *file;
    int n;
    double valor;

    scanf("%d", &n);

    // Abrindo arquivo para escrita
    file = fopen("valores.txt", "wb");

    if (file == NULL)
    {
        return 1;
    }

    // Inserindo valores no arquivo
    for (int i = 0; i < n; i++)
    {
        scanf("%lf", &valor);
        fwrite(&valor, sizeof(double), 1, file);
    }

    // Fechando o arquivo
    fclose(file);

    // Reabrindo o arquivo para leitura reversa
    file = fopen("valores.txt", "rb");

    if (file == NULL)
    {
        return 1;
    }

    // Navegando para o final do arquivo
    fseek(file, 0, SEEK_END);
    long filePointer = ftell(file);

    while (filePointer > 0)
    {
        filePointer -= sizeof(double);
        fseek(file, filePointer, SEEK_SET);
        fread(&valor, sizeof(double), 1, file);
        // Convertendo o número para uma string para remover os zeros extras
        char str[50];
        snprintf(str, 50, "%.15g", valor);
        printf("%s\n", str);
    }

    // Fechando o arquivo
    fclose(file);

    return 0;
}
