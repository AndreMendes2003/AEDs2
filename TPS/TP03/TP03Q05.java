import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

class Personagem {
    private String id;
    private String name;
    private String alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private String hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private String alive;
    private String alternateActor;
    private LocalDate dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private String wizard;

    public Personagem() {
        this.id = this.name = this.house = this.ancestry = this.species = this.patronus = this.hogwartsStudent = this.actorName = this.alternateActor = this.eyeColour = this.gender = this.hairColour = this.hogwartsStaff = this.alive = this.wizard = this.alternateNames = null;
        this.yearOfBirth = 0;
        this.dateOfBirth = null;
    }

    public Personagem(String id, String name, String alternateNames, String house, String ancestry,
            String species, String patronus,
            String hogwartsStaff, String hogwartsStudent, String actorName, String alive, String alternateActor,
            LocalDate dateOfBirth,
            int yearOfBirth,
            String eyeColour, String gender, String hairColour, String wizard) {
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

    public String isHogwartsStaff() {
        return hogwartsStaff;
    }

    public String getHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public String isAlive() {
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

    public String isWizard() {
        return wizard;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAlternateNames() {
        return alternateNames;
    }

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

    public void setHogwartsStaff(String hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setAlive(String alive) {
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

    public void setWizard(String wizard) {
        this.wizard = wizard;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAlternateNames(String alternateNames) {
        this.alternateNames = alternateNames;
    }

    public Personagem clone() {
        Personagem clonado = new Personagem();
        clonado.setId(this.id);
        clonado.setName(this.name);
        clonado.setAlternateNames(this.alternateNames);
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

        System.out.println(
                this.id + " ## " + this.name + " ## {" + this.alternateNames + "} ## " + this.house
                        + " ## "
                        + this.ancestry + " ## "
                        + this.species + " ## " + this.patronus + " ## "
                        + (this.hogwartsStaff.equals("VERDADEIRO") ? "true" : "false") + " ## "
                        + (this.hogwartsStudent.equals("VERDADEIRO") ? "true" : "false") + " ## "
                        + this.actorName + " ## " + (this.alive.equals("VERDADEIRO") ? "true" : "false") + " ## "
                        + this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ## " + this.yearOfBirth
                        + " ## " + this.eyeColour
                        + " ## " + this.gender + " ## " + this.hairColour + " ## "
                        + (this.wizard.equals("VERDADEIRO") ? "true" : "false") + "]");
    }

    public void ler() throws IOException {
        try {
            String nomeArquivo = "/tmp/characters.csv";
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            boolean primeiraLinha = true; // Flag para controlar a primeira linha

            while ((linha = bufferedReader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Ignora a primeira linha com cabeçalhos
                }

                String[] campos = linha.split(";");
                String id;
                try {
                    id = campos[0]; // id do personagem

                    if (id.equals(this.id)) {// O personagem com o ID desejado foi encontrado

                        this.name = campos[1]; // Nome do personagem

                        if (campos.length > 2 && campos[2] != null && !campos[2].isEmpty()) {
                            String apelidosArray = campos[2].trim(); // Remove os espaços em branco extras

                            if (apelidosArray.startsWith("[") && apelidosArray.endsWith("]")) {
                                apelidosArray = apelidosArray.substring(1, apelidosArray.length() - 1);

                            }

                            if (!apelidosArray.isEmpty()) {
                                StringBuilder nomeAlternativoBuilder = new StringBuilder();
                                String[] apelidosFinal = apelidosArray.split("',\\s*'");
                                for (String apelido : apelidosFinal) {

                                    StringBuilder apelidoSemAspas = new StringBuilder();
                                    for (int i = 0; i < apelido.length(); i++) {
                                        if (apelido.charAt(i) != '\'') {
                                            apelidoSemAspas.append(apelido.charAt(i));
                                        }
                                    }
                                    nomeAlternativoBuilder.append(apelidoSemAspas.toString()).append(", ");

                                }
                                String nomeAlternativo = nomeAlternativoBuilder.toString().trim();
                                nomeAlternativo = nomeAlternativo.substring(0, nomeAlternativo.length() - 1);

                                this.alternateNames = nomeAlternativo;
                            } else {
                                this.alternateNames = "";
                            }
                        } else {
                            this.alternateNames = "";
                        }

                        this.house = campos[3];

                        this.ancestry = campos[4];

                        this.species = campos[5];

                        this.patronus = campos[6];

                        this.hogwartsStaff = campos[7];

                        this.hogwartsStudent = campos[8];

                        this.actorName = campos[9];

                        this.alive = campos[10];

                        this.alternateActor = campos[11];

                        DateTimeFormatter[] formatters = {
                                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                                DateTimeFormatter.ofPattern("dd-M-yyyy")
                        };

                        for (DateTimeFormatter formatter : formatters) {
                            try {
                                this.dateOfBirth = LocalDate.parse(campos[12], formatter);
                                break;
                            } catch (DateTimeParseException e) {

                            }
                        }
                        if (this.dateOfBirth == null) {
                            this.dateOfBirth = null;
                        }

                        this.yearOfBirth = Integer.parseInt(campos[13]);
                        this.eyeColour = campos[14];

                        this.gender = campos[15];

                        this.hairColour = campos[16];
                        this.wizard = campos[17];

                        break;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter um número: " + e.getMessage());
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

public class TP03Q05 {

    static int comp = 0;
    static int mov = 0;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Personagem> lista = new ArrayList<>();

        while (true) {
            String search = sc.nextLine();
            if (search.equals("FIM"))
                break;

            Personagem personagem = new Personagem();
            personagem.setId(search);

            try {
                personagem.ler();
                lista.add(personagem);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        int qtde = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < qtde; i++) {
            String operacao = sc.nextLine();
            String[] partes = operacao.split(" ");

            switch (partes[0]) {
                case "RI":
                    if (!lista.isEmpty()) {
                        Personagem removido = lista.remove(0);
                        System.out.println("(R) " + removido.getName());
                    }
                    break;
                case "RF":
                    if (!lista.isEmpty()) {
                        Personagem removido = lista.remove(lista.size() - 1);
                        System.out.println("(R) " + removido.getName());
                    }
                    break;
                case "R*":
                    int posicaoRemover = Integer.parseInt(partes[1]);
                    if (posicaoRemover >= 0 && posicaoRemover < lista.size()) {
                        Personagem removido = lista.remove(posicaoRemover);
                        System.out.println("(R) " + removido.getName());
                    }
                    break;
                case "I*":
                    int posicaoInserir = Integer.parseInt(partes[1]);
                    String idInserir = partes[2];
                    Personagem personagem = new Personagem();
                    personagem.setId(idInserir);
                    try {
                        personagem.ler();
                        if (posicaoInserir >= 0 && posicaoInserir <= lista.size()) {
                            lista.add(posicaoInserir, personagem);
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "II":
                    String idInserirInicio = partes[1];
                    Personagem personagemInicio = new Personagem();
                    personagemInicio.setId(idInserirInicio);
                    try {
                        personagemInicio.ler();
                        lista.add(0, personagemInicio);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "IF":
                    String idInserirFim = partes[1];
                    Personagem personagemFim = new Personagem();
                    personagemFim.setId(idInserirFim);
                    try {
                        personagemFim.ler();
                        lista.add(personagemFim);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.print("[" + i + " ## ");
            lista.get(i).imprimir();
        }
        sc.close();
    }
}