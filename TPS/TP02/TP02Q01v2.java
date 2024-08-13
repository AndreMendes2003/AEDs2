import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
//import java.io.InputStreamReader;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/*
 * Crie uma classe Personagem seguindo todas as regras apresentadas no slide
 * unidade01g_conceitosBasicos_introducaoOO.pdf. Sua classe terá os atributos
 * privados id (String), name (String), alternate_names (Lista), house (String),
 * ancestry (String), species (String), patronus (String), hogwartsStaff
 * (Boolean), hogwartsStudent (String), actorName (String), alive (Boolean),
 * dateOfBirth (DateTime), yearOfBirth (int), eyeColour (String), gender
 * (String), hairColour (String), wizard (Boolean). Sua classe também terá pelo
 * menos dois construtores, e os métodos gets, sets, clone, imprimir e ler.
 * 
 * 
 * 
 * O método imprimir mostra os atributos do registro (ver cada linha da saída
 * padrão) e o ler lê os atributos de um registro. Atenção para o arquivo de
 * entrada, pois em alguns registros faltam valores e esse foi substituído pelo
 * valor 0 (zero) ou vazio.
 * 
 * 
 * 
 * A entrada padrão é composta por várias linhas e cada uma contém uma string
 * indicando o id do Personagem a ser lido. A última linha da entrada contém a
 * palavra FIM. A saída padrão também contém várias linhas, uma para cada
 * registro contido em uma linha da entrada padrão
 */
// André Mendes Rodrigues - 780371
/**
 * TP02Q01
 */
public class TP02Q01v2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String line;
        HashMap<String, String[]> characterMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/tmp/characters.csv"))) {
            String lineCSV;
            while ((lineCSV = bufferedReader.readLine()) != null) {
                String[] data = lineCSV.split(";");
                // Verifica se a linha possui o formato correto
                if (data.length >= 17) {
                    characterMap.put(data[0], data); // Armazena a linha do CSV em um mapa usando o ID como chave
                }
                // else {
                // }
            }
        }

        line = br.readLine();
        while (!Fim(line)) {
            String[] characterData = characterMap.get(line);
            if (characterData != null) {
                Personagem personagem = new Personagem();
                personagem.ler(characterData); // Passa os dados do personagem diretamente
                personagem.imprimir();
            } else {
                Personagem personagem = new Personagem();
                personagem.ler(characterData); // Passa os dados do personagem diretamente
                personagem.imprimir();
                // System.out.println("Personagem nao encontrado para o ID: " + line);
            }
            line = br.readLine();
        }

        br.close();
    }

    private static boolean Fim(String str) {
        return str.equals("FIM");
    }
}

class Personagem {
    private String id;
    private String name;
    private List<String> alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private boolean alive;
    private String alternateActor;
    private LocalDate dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;

    public Personagem() {
        this.id = this.name = this.house = this.ancestry = this.species = this.patronus = this.hogwartsStudent = this.actorName = this.alternateActor = this.eyeColour = this.gender = this.hairColour = null;
        this.hogwartsStaff = this.alive = this.wizard = false;
        this.yearOfBirth = 0;
        this.alternateNames = new ArrayList<>();
        this.dateOfBirth = null;
    }

    public Personagem(String id, String name, List<String> alternateNames, String house, String ancestry,
            String species, String patronus,
            boolean hogwartsStaff, String hogwartsStudent, String actorName, boolean alive, String alternateActor,
            LocalDate dateOfBirth,
            int yearOfBirth,
            String eyeColour, String gender, String hairColour, boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternateNames = alternateNames;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.alternateActor = alternateActor;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public String getPatronus() {
        return patronus;
    }

    public boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public String getHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getAlternateActor() {
        return alternateActor;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public boolean isWizard() {
        return wizard;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setAlternateActor(String alternateActor) {
        this.alternateActor = alternateActor;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setWizard(boolean wizard) {
        this.wizard = wizard;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    public Personagem clone() {
        Personagem clonado = new Personagem();
        // Clonando todas as variáveis
        clonado.setId(this.id);
        clonado.setName(this.name);
        // ---------------------
        // Clonando o arrayList
        List<String> alternateNamesClonados = new ArrayList<>(this.alternateNames);
        clonado.setAlternateNames(alternateNamesClonados);
        // ---------------------
        clonado.setHouse(this.house);
        clonado.setAncestry(this.ancestry);
        clonado.setSpecies(this.species);
        clonado.setPatronus(this.patronus);
        clonado.setHogwartsStaff(this.hogwartsStaff);
        clonado.setHogwartsStudent(this.hogwartsStudent);
        clonado.setActorName(this.actorName);
        clonado.setAlive(this.alive);
        clonado.setAlternateActor(this.alternateActor);
        clonado.setDateOfBirth(this.dateOfBirth);
        clonado.setYearOfBirth(this.yearOfBirth);
        clonado.setEyeColour(this.eyeColour);
        clonado.setGender(this.gender);
        clonado.setHairColour(this.hairColour);
        clonado.setWizard(this.wizard);

        return clonado;
    }

    public void imprimir() {
        // Construindo a representação da lista alternateNames
        StringBuilder alternateNamesString = new StringBuilder("{");
        for (int i = 0; i < alternateNames.size(); i++) {
            alternateNamesString.append(alternateNames.get(i));
            if (i < alternateNames.size() - 1) {
                alternateNamesString.append(", ");
            }
        }
        alternateNamesString.append("}");
    
        // Imprimindo os atributos formatados
        System.out.println(
            "[" + this.id + " ## " + this.name + " ## " + alternateNamesString.toString() + " ## " + this.house + " ## "
                + this.ancestry + " ## "
                + this.species + " ## " + this.patronus + " ## " + this.hogwartsStaff  + " ## "
                + (this.hogwartsStudent == "VERDADEIRO" ? "false" : "true") + " ## "
                + this.actorName + " ## " + this.alive  + " ## " + this.dateOfBirth + " ## " + this.yearOfBirth
                + " ## " + this.eyeColour
                + " ## " + this.gender + " ## " + this.hairColour + " ## " + this.wizard + "]");
    }
    

    public void ler(String[] dados) {
        try {
            if (dados != null && dados.length >= 18) {
                this.id = dados[0];
                this.name = dados[1];
                
                // Removendo os colchetes e as aspas dos elementos da lista alternateNames
                String alternateNamesString = dados[2].replace("[", "").replace("]", "").replace("'", "");
                String[] alternateNamesArray = alternateNamesString.split(", ");
                this.alternateNames = Arrays.asList(alternateNamesArray);
                
                this.house = dados[3];
                this.ancestry = dados[4];
                this.species = dados[5];
                this.patronus = dados[6];
                this.hogwartsStaff = Boolean.parseBoolean(dados[7]);
                this.hogwartsStudent = dados[8];
                this.actorName = dados[9];
                this.alive = Boolean.parseBoolean(dados[10]);
                this.alternateActor = dados[11];
                
                // Lidando com a data de nascimento
                DateTimeFormatter[] formatters = {
                    DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                    DateTimeFormatter.ofPattern("dd-M-yyyy")
                };
                for (DateTimeFormatter formatter : formatters) {
                    try {
                        this.dateOfBirth = LocalDate.parse(dados[12], formatter);
                        break;
                    } catch (DateTimeParseException e) {
                    }
                }
                
                this.yearOfBirth = Integer.parseInt(dados[13]);
                this.eyeColour = dados[14];
                this.gender = dados[15];
                this.hairColour = dados[16];
                this.wizard = Boolean.parseBoolean(dados[17]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}