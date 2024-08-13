#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Personagem {
  char *id;
  char *name;
  char *alternate_names;
  char *house;
  char *ancestry;
  char *species;
  char *patronus;
  bool hogwartsStaff;
  bool hogwartsStudent;
  char *actorName;
  bool alive;
  char *alternateActor;
  char *dateOfBirth;
  int yearOfBirth;
  char *eyeColour;
  char *gender;
  char *hairColour;
  bool wizard;
} Personagem;

void construtorPersonagem(Personagem *p, char *id, char *name,
                          char *alternate_names, char *house, char *ancestry,
                          char *species, char *patronus, bool hogwartsStaff,
                          bool hogwartsStudent, char *actorName, bool alive,
                          char *alternateActor, char *dateOfBirth,
                          int yearOfBirth, char *eyeColour, char *gender,
                          char *hairColour, bool wizard) {
  if (p != NULL) {
    p->id = id;
    p->name = name;
    p->alternate_names = alternate_names;
    p->house = house;
    p->ancestry = ancestry;
    p->species = species;
    if (strcmp(patronus, "null") == 0) {
      p->patronus = "";
    } else {
      p->patronus = patronus;
    }
    p->hogwartsStaff = hogwartsStaff;
    p->hogwartsStudent = hogwartsStudent;
    if (strcmp(actorName, "null") == 0) {
      p->actorName = "";
    } else {
      p->actorName = actorName;
    }
    p->alive = alive;
    p->alternateActor = alternateActor;
    p->dateOfBirth = dateOfBirth;
    p->yearOfBirth = yearOfBirth;
    p->eyeColour = eyeColour;
    p->gender = gender;
    p->hairColour = hairColour;
    p->wizard = wizard;
  }
}

Personagem newPersonagem() {
  Personagem p;
  construtorPersonagem(&p, "", "", "", "", "", "", "", 0, 0, "", 0, "", "", 0,
                       "", "", "", 0);
  return p;
}

// getters
const char *getId(const Personagem *p) { return p->id; }

const char *getName(const Personagem *p) { return p->name; }

const char *getAlternateNames(const Personagem *p) {
  return p->alternate_names;
}

const char *getHouse(const Personagem *p) { return p->house; }

const char *getAncestry(const Personagem *p) { return p->ancestry; }

const char *getSpecies(const Personagem *p) { return p->species; }

const char *getPatronus(const Personagem *p) { return p->patronus; }

bool getHogwartsStaff(const Personagem *p) { return p->hogwartsStaff; }

bool getHogwartsStudent(const Personagem *p) { return p->hogwartsStudent; }

const char *getActorName(const Personagem *p) { return p->actorName; }

bool getAlive(const Personagem *p) { return p->alive; }

const char *getAlternateActor(const Personagem *p) { return p->alternateActor; }

const char *getDateOfBirth(const Personagem *p) { return p->dateOfBirth; }

int getYearOfBirth(const Personagem *p) { return p->yearOfBirth; }

const char *getEyeColour(const Personagem *p) { return p->eyeColour; }

const char *getGender(const Personagem *p) { return p->gender; }

const char *getHairColour(const Personagem *p) { return p->hairColour; }

bool getWizard(const Personagem *p) { return p->wizard; }

// setters
void setId(Personagem *p, const char *id) {
  if (p->id != NULL)
    free(p->id);
  p->id = strdup(id);
}

void setName(Personagem *p, const char *name) {
  if (p->name != NULL)
    free(p->name);
  p->name = strdup(name);
}

void setAlternateNames(Personagem *p, const char *alternate_names) {
  if (p->alternate_names != NULL)
    free(p->alternate_names);
  p->alternate_names = strdup(alternate_names);
}

void setHouse(Personagem *p, const char *house) {
  if (p->house != NULL)
    free(p->house);
  p->house = strdup(house);
}

void setAncestry(Personagem *p, const char *ancestry) {
  if (p->ancestry != NULL)
    free(p->ancestry);
  p->ancestry = strdup(ancestry);
}

void setSpecies(Personagem *p, const char *species) {
  if (p->species != NULL)
    free(p->species);
  p->species = strdup(species);
}

void setPatronus(Personagem *p, const char *patronus) {
  if (p->patronus != NULL)
    free(p->patronus);
  p->patronus = strdup(patronus);
}

void setHogwartsStaff(Personagem *p, bool hogwartsStaff) {
  p->hogwartsStaff = hogwartsStaff;
}

void setHogwartsStudent(Personagem *p, bool hogwartsStudent) {
  p->hogwartsStudent = hogwartsStudent;
}

void setActorName(Personagem *p, const char *actorName) {
  if (p->actorName != NULL)
    free(p->actorName);
  p->actorName = strdup(actorName);
}

void setAlive(Personagem *p, bool alive) { p->alive = alive; }

void setAlternateActor(Personagem *p, const char *alternateActor) {
  if (p->alternateActor != NULL)
    free(p->alternateActor);
  p->alternateActor = strdup(alternateActor);
}

void setDateOfBirth(Personagem *p, const char *dateOfBirth) {
  if (p->dateOfBirth != NULL)
    free(p->dateOfBirth);
  p->dateOfBirth = strdup(dateOfBirth);
}

void setYearOfBirth(Personagem *p, int yearOfBirth) {
  p->yearOfBirth = yearOfBirth;
}

void setEyeColour(Personagem *p, const char *eyeColour) {
  if (p->eyeColour != NULL)
    free(p->eyeColour);
  p->eyeColour = strdup(eyeColour);
}

void setGender(Personagem *p, const char *gender) {
  if (p->gender != NULL)
    free(p->gender);
  p->gender = strdup(gender);
}

void setHairColour(Personagem *p, const char *hairColour) {
  if (p->hairColour != NULL)
    free(p->hairColour);
  p->hairColour = strdup(hairColour);
}

void setWizard(Personagem *p, bool wizard) { p->wizard = wizard; }

// método de imprimir
void imprimir(Personagem *p) {
  // comparação para verificar se a data tá no modelo dd-MM-yyyy
  if (p->dateOfBirth && strlen(p->dateOfBirth) < 10) {
    char *aux = calloc(11, sizeof(char));
    int dia, mes, ano;

    if (sscanf(p->dateOfBirth, "%d-%d-%d", &dia, &mes, &ano) == 3) {
      sprintf(aux, "%02d-%02d-%d", dia, mes,
              ano); // coloca um zero a esquerda se não tiver
      free(p->dateOfBirth);
      p->dateOfBirth = aux;
    } else {
      free(aux);
    }
  }
  printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## "
         "%s ## %d ## %s ## %s ## %s ## %s]\n",
         p->id, p->name, p->alternate_names, p->house, p->ancestry, p->species,
         p->patronus, p->hogwartsStaff ? "true" : "false",
         p->hogwartsStudent ? "true" : "false", p->actorName,
         p->alive ? "true" : "false", p->dateOfBirth, p->yearOfBirth,
         p->eyeColour, p->gender, p->hairColour,
         (p->wizard == 1 ? "false" : "true"));
}

// método de leitura
Personagem *ler(Personagem *p, char *arquivo, char *searchID) {
  FILE *file = fopen(arquivo, "r");
  if (file == NULL) {
    printf("\nArquivo não encontrado.\n");
  } else {
    char linha[500];     // tamanho máximo da linha
    bool search = false; // controle o while

    // pula a primeira linha
    fgets(linha, sizeof(linha), file);

    int na = 0; // ler o resto das linhas

    while (fgets(linha, sizeof(linha), file) != NULL && !search) {
      char *atributos[18];
      char linha_auxiliar[500] = {0};
      int col = 0;
      int t = 0;
      int k = 0;
      int index = 0;
      // cria um token pra armezanar cada variável da quebra de linha
      char *token = strtok(linha, ";");
      int contador = 0;
      na++;
      int debug = 0;
      // lê até que o token seja null
      while (token != NULL) {
        debug++;
        contador++;
        atributos[index++] = strdup(token);
        token = strtok(NULL, ";");
      }

      // "método" pra trocar [] por {}
      char aux[500] = {0};
      int j = 0;
      for (int i = 0; i < strlen(atributos[2]); i++) {
        if (atributos[2][i] == '[') {
          aux[j] = '{';
        } else if (atributos[2][i] == ']') {
          aux[j] = '}';
        } else if (atributos[2][i] == '\'') {
          continue;
        } else {
          aux[j] = atributos[2][i];
        }
        j++;
      }
      aux[j] = '\0';

      free(atributos[2]);
      atributos[2] = strdup(aux);
      // verifica se o atributo 0 é o ID pesquisado
      if (strcmp(atributos[0], searchID) == 0) {
        // recebe os atributos e coloca eles em ordme
        if (contador < 18) {
          if (contador > 16) {
            construtorPersonagem(
                p, atributos[0], atributos[1], atributos[2], atributos[3],
                atributos[4], atributos[5], "null",
                strcmp(atributos[6], "true") == 0,
                strcmp(atributos[7], "true") == 0, atributos[8],
                strcmp(atributos[9], "true") == 0, atributos[10], atributos[11],
                atoi(atributos[12]), atributos[13], atributos[14],
                atributos[15], strcmp(atributos[16], "true") == 0);
          } else {
            construtorPersonagem(
                p, atributos[0], atributos[1], atributos[2], atributos[3],
                atributos[4], atributos[5], "null",
                strcmp(atributos[6], "true") == 0,
                strcmp(atributos[7], "true") == 0, "null",
                strcmp(atributos[8], "true") == 0, atributos[9], atributos[10],
                atoi(atributos[11]), atributos[12], atributos[13],
                atributos[14], strcmp(atributos[15], "true") == 0);
          }
        } else {
          construtorPersonagem(
              p, atributos[0], atributos[1], atributos[2], atributos[3],
              atributos[4], atributos[5], atributos[6],
              strcmp(atributos[7], "true") == 0,
              strcmp(atributos[8], "true") == 0, atributos[9],
              strcmp(atributos[10], "true") == 0, atributos[11], atributos[12],
              atoi(atributos[13]), atributos[14], atributos[15], atributos[16],
              strcmp(atributos[17], "true") == 0);
        }
        search = true;

        return p;
      }

      // liberar memoria pra receber novos personagens
      for (int x = 0; x < index; x++) {
        free(atributos[x]);
      }
    }
    fclose(file); // fecha o arquivo
  }
}

int main() {
  // alocando local de memoria para o personagem
  Personagem *p = (Personagem *)malloc(1 * sizeof(Personagem));
  char *path = "/tmp/characters.csv";
  char id[100];
  // ler id novo
  scanf("%s", id);

  getchar();
  while (strcmp(id, "FIM") != 0) {
    p = ler(p, path, id);
    imprimir(p);
    // ler id novo
    scanf("%s", id);

    getchar();
  }

  free(p);
  p = NULL;
  return 0;
}
