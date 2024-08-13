/*
Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo da Bolha,
fazendo com que a chave de pesquisa seja o atributo hairColour. O nome do arquivo de log será matrícula_bolha.txt.
*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

#define TAM 200

// Contagem de comparações
int comp = 0;
// Contagem de movimentações
int mov = 0;
// Atributos
typedef struct Personagem
{
    char id[TAM];
    char name[TAM];
    char alternateNames[TAM];
    char house[TAM];
    char ancestry[TAM];
    char species[TAM];
    char patronus[TAM];
    char hogwartsStaff[TAM];
    char hogwartsStudent[TAM];
    char actorName[TAM];
    char alive[TAM];
   // char alternateActor[TAM];
    char dateOfBirth[TAM];
    int yearOfBirth;
    char eyeColour[TAM];
    char gender[TAM];
    char hairColour[TAM];
    char wizard[TAM];
} Personagem;

// Construtores
Personagem newPersonagem(char id[], char name[], char alternateNames[], char house[], char ancestry[], char species[],
                         char patronus[], char hogwartsStaff[], char hogwartsStudent[], char actorName[],
                         char alive[], 
                         //char alternateActor[], 
                         char dateOfBirth[], int yearOfBirth,
                         char eyeColour[], char gender[], char hairColour[], char wizard[])
{
    Personagem p;
    strcpy(p.id, id);
    strcpy(p.name, name);
    strcpy(p.alternateNames, alternateNames);
    strcpy(p.house, house);
    strcpy(p.ancestry, ancestry);
    strcpy(p.species, species);
    strcpy(p.patronus, patronus);
    strcpy(p.hogwartsStaff, hogwartsStaff);
    strcpy(p.hogwartsStudent, hogwartsStudent);
    strcpy(p.actorName, actorName);
    strcpy(p.alive, alive);
    //strcpy(p.alternateActor, alternateActor);
    strcpy(p.dateOfBirth, dateOfBirth);
    p.yearOfBirth = yearOfBirth;
    strcpy(p.eyeColour, eyeColour);
    strcpy(p.gender, gender);
    strcpy(p.hairColour, hairColour);
    strcpy(p.wizard, wizard);
    return p;
}

Personagem newPersonagemDefault()
{
    Personagem p;
    strcpy(p.id, "");
    strcpy(p.name, "");
    strcpy(p.alternateNames, "");
    strcpy(p.house, "");
    strcpy(p.ancestry, "");
    strcpy(p.species, "");
    strcpy(p.patronus, "");
    strcpy(p.hogwartsStaff, "");
    strcpy(p.hogwartsStudent, "");
    strcpy(p.actorName, "");
    strcpy(p.alive, "");
    //strcpy(p.alternateActor, "");
    strcpy(p.dateOfBirth, "");
    p.yearOfBirth = 0;
    strcpy(p.eyeColour, "");
    strcpy(p.gender, "");
    strcpy(p.hairColour, "");
    strcpy(p.wizard, "");
    return p;
}

// Getters
char *getId(Personagem *p)
{
    return p->id;
}

char *getName(Personagem *p)
{
    return p->name;
}

char *getAlternate_names(Personagem *p)
{
    return p->alternateNames;
}

char *getHouse(Personagem *p)
{
    return p->house;
}

char *getAncestry(Personagem *p)
{
    return p->ancestry;
}

char *getSpecies(Personagem *p)
{
    return p->species;
}

char *getPatronus(Personagem *p)
{
    return p->patronus;
}

char *getHogwartsStaff(Personagem *p)
{
    return strcmp(p->hogwartsStaff, "VERDADEIRO") == 0 ? "true" : "false";
}

char *getHogwartsStudent(Personagem *p)
{
    return strcmp(p->hogwartsStudent, "VERDADEIRO") == 0 ? "true" : "false";
}

char *getActorName(Personagem *p)
{
    return p->actorName;
}

char *getAlive(Personagem *p)
{
    return strcmp(p->alive, "VERDADEIRO") == 0 ? "true" : "false";
}
/*
char *getAlternateActor(Personagem *p)
{
    return p->alternateActor;
}
*/

char *getDateOfBirth(Personagem *p)
{
    return p->dateOfBirth;
}

int getYearOfBirth(Personagem *p)
{
    return p->yearOfBirth;
}

char *getEyeColour(Personagem *p)
{
    return p->eyeColour;
}

char *getGender(Personagem *p)
{
    return p->gender;
}

char *getHairColor(Personagem *p)
{
    return p->hairColour;
}

char *getWizard(Personagem *p)
{
    return strcmp(p->wizard, "VERDADEIRO") == 0 ? "true" : "false";
}

// Setters
void setId(char *id, Personagem *p)
{
    strcpy(p->id, id);
}

void setName(char *name, Personagem *p)
{
    strcpy(p->name, name);
}

void setAlternate_names(char *alternateNames, Personagem *p)
{
    strcpy(p->alternateNames, alternateNames);
}

void setHouse(char *house, Personagem *p)
{
    strcpy(p->house, house);
}

void setAncestry(char *species, Personagem *p)
{
    strcpy(p->species, species);
}

void setSpecies(char *species, Personagem *p)
{
    strcpy(p->species, species);
}

void setPatronus(char *patronus, Personagem *p)
{
    strcpy(p->patronus, patronus);
}

void setHogwartsStaff(char *hogwartsStaff, Personagem *p)
{
    strcpy(p->hogwartsStaff, hogwartsStaff);
}

void setHogwartsStudent(char *hogwartsStudent, Personagem *p)
{
    strcpy(p->hogwartsStaff, hogwartsStudent);
}

void setActorName(char *actorName, Personagem *p)
{
    strcpy(p->actorName, actorName);
}

void setAlive(char *alive, Personagem *p)
{
    strcpy(p->alive, alive);
}
/*
void setAlternateActor(char *alternateActor, Personagem *p)
{
    strcpy(p->alternateActor, alternateActor);
}
*/
void setDateOfBirth(char *dateOfBirth, Personagem *p)
{
    strcpy(p->dateOfBirth, dateOfBirth);
}

void setYearOfBirth(int yearOfBirth, Personagem *p)
{
    p->yearOfBirth = yearOfBirth;
}

void setEyeColour(char *eyeColour, Personagem *p)
{
    strcpy(p->eyeColour, eyeColour);
}

void setGender(char *gender, Personagem *p)
{
    strcpy(p->gender, gender);
}

void setHairColor(char *hairColor, Personagem *p)
{
    strcpy(p->hairColour, hairColor);
}

void setWizard(char *wizard, Personagem *p)
{
    strcpy(p->wizard, wizard);
}

// Função de leitura
char **ler(char line[])
{
    int tam_line = strlen(line);
    int start = 0;
    int comp_campos = 0;
    char **campos = malloc(18 * sizeof(char *));
    for (int i = 0; i < 18; i++)
    {
        campos[i] = malloc(TAM * sizeof(char));
    }
    for (int i = 0; i < tam_line; i++)
    {
        if (line[i] == ';' && line[i - 1] == ';')
        {
            strcpy(campos[comp_campos], "");
            start = i + 1;
            comp_campos++;
        }
        else if (line[i] == ';')
        {
            strncpy(campos[comp_campos], line + start, i - start);
            campos[comp_campos][i - start] = '\0';
            start = i + 1;
            comp_campos++;
        }
    }
    strncpy(campos[17], line + start, tam_line - start - 1);
    return campos;
}

void imprimir(Personagem *p)
{
    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
           p->id, p->name, p->alternateNames, p->house, p->ancestry, p->species, p->patronus,
           strcmp(p->hogwartsStaff, "VERDADEIRO") == 0 ? "true" : "false",
           strcmp(p->hogwartsStudent, "VERDADEIRO") == 0 ? "true" : "false",
           p->actorName, strcmp(p->alive, "VERDADEIRO") == 0 ? "true" : "false",
           p->dateOfBirth, p->yearOfBirth, p->eyeColour, p->gender, p->hairColour,
           strcmp(p->wizard, "VERDADEIRO") == 0 ? "true" : "false");
}

void preencheVetor(Personagem arr[])
{
    FILE *file;
    char line[1500];
    if ((file = fopen("/tmp/characters.csv", "r")) != NULL)
    {
        int i = 0;
        int tamList;
        fgets(line, 1500, file);
        while (fgets(line, 1500, file) != NULL)
        {
            char **atributos = ler(line);
            for (int i = 0; atributos[2][i] != '\0'; i++)
            {
                if (atributos[2][i] == '[')
                {
                    atributos[2][i] = '{';
                }
                else if (atributos[2][i] == '\'')
                {
                    for (int j = i; atributos[2][j] != '\0'; j++)
                    {
                        atributos[2][j] = atributos[2][j + 1];
                    }
                }
            }
            tamList = strlen(atributos[2]);
            atributos[2][tamList - 1] = '}';

            arr[i] = newPersonagem(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4],
                                        atributos[5], atributos[6], strcmp(atributos[7], "VERDADEIRO") == 0 ? "true" : "false", strcmp(atributos[8], "VERDADEIRO") == 0 ? "true" : "false", atributos[9], atributos[10],
                                        atributos[12], atoi(atributos[13]), atributos[14], atributos[15], atributos[16], strcmp(atributos[17], "VERDADEIRO") == 0 ? "true" : "false");
                    i++;
            free(atributos); // Liberando memória alocada para atributos
        }
        fclose(file);
    }
    else
    {
        printf("Não foi possivel ler o arquivo");
    }
}

void swap(Personagem p[], int i, int j)
{
    Personagem tmp;

    tmp = p[i];
    p[i] = p[j];
    p[j] = tmp;
}

void bubbleSort(Personagem p[], int tamVetor) {
    for (int i = 0; i < tamVetor - 1; i++) {
        for (int j = 0; j < tamVetor - i - 1; j++) {
            if (strcmp(p[j].hairColour, p[j + 1].hairColour) > 0 || 
                (strcmp(p[j].hairColour, p[j + 1].hairColour) == 0 && strcmp(p[j].name, p[j + 1].name) > 0)) {
                swap(p, j, j + 1);
                mov += 3;
            }
            comp++;
        }
    }
}

int main()
{
    clock_t inicio = clock();
    Personagem personagens[405];
    Personagem *selectedPersonagens = malloc(sizeof(Personagem) * 405);
    char id[200];
    int n = 0;
    
    preencheVetor(personagens);

    scanf("%s", id);

    while (strcmp(id, "FIM") != 0)
    {

        for (int i = 0; i < 405; i++)
        {
            if (strcmp(personagens[i].id, id) == 0)
            {

                selectedPersonagens[n] = personagens[i];
                i = 405;
            }
        }

        scanf("%s", id);

        n++;
    }

    bubbleSort(selectedPersonagens,  n);

    clock_t fim = clock();

    double tempoExecucao = (double)(fim - inicio);

    FILE *log;
    if ((log = fopen("matricula_bolha.txt", "w")) != NULL)
    {
        fprintf(log, "780371\t%d Comparacoes\t%d Movimentacoes\t%f Tempo de Execucao", comp, mov, tempoExecucao);
        fclose(log);
    }
    else
    {
        printf("Erro ao abrir arquivo");
    }
    for (int i = 0; i < n; i++)
    {
        imprimir(&selectedPersonagens[i]);
    }
}