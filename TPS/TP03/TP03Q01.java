import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.text.ParseException;
import java.io.IOException;

class Celula {
    Personagem p;
    Celula prox;
    int count = 0;

    public Celula() {
        this.p = null;
        this.prox = null;
    }

    public Celula(Personagem personagem) {
        this.p = personagem;
        this.prox = null;
    }
}

class Lista {
    Celula primeiro, ultimo;
    int count = 0;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    void printar() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print("[" + count++ + " ");
            i.p.imprimir();
        }
    }

    void inserirInicio(Personagem personagem) {
        Celula tmp = new Celula(personagem);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
    }

    void inserir(Personagem personagem, int pos) throws Exception {
        Celula i = primeiro;
        for (int c = 0; c < pos; i = i.prox, c++)
            ;
        Celula tmp = new Celula(personagem);
        tmp.prox = i.prox;
        i.prox = tmp;
        if (tmp.prox == null) {
            ultimo = tmp;
        }
    }

    void inserirFim(Personagem personagem) {
        Celula tmp = new Celula(personagem);
        ultimo.prox = tmp;
        ultimo = tmp;
    }

    Personagem removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        Celula tmp = primeiro.prox;
        primeiro.prox = tmp.prox;
        if (primeiro.prox == null) {
            ultimo = primeiro;
        }
        return tmp.p;
    }

    Personagem remover(int pos) throws Exception {
        Celula tmp = new Celula();
        Celula i = primeiro;
        for (int c = 0; c < pos; i = i.prox, c++)
            ;
        tmp = i.prox;
        i.prox = tmp.prox;
        if (tmp == ultimo) {
            ultimo = i;
        }
        return tmp.p;
    }

    Personagem removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        Celula i = primeiro;
        while (i.prox != ultimo) {
            i = i.prox;
        }
        Celula tmp = ultimo;
        ultimo = i;
        ultimo.prox = null;
        return tmp.p;
    }

    int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }
}

class Personagem {

    private String id, name, house, ancestry, species, patronus, actorName, eyeColour, hairColor, gender;
    private ArrayList<String> alternate_names;
    private boolean hogwartsStudent, hogwartsStaff, alive, wizard;
    private Date dateOfBirth;
    private int yearOfBirth;

    // Construtores
    public Personagem() {
        this.id = "";
        this.name = "";
        this.ancestry = "";
        this.species = "";
        this.patronus = "";
        this.actorName = "";
        this.eyeColour = "";
        this.hairColor = "";
        this.gender = "";
        this.house = "";
        this.yearOfBirth = 0;
        this.alternate_names = new ArrayList<String>();
    }

    public Personagem(String id, String name, String house, String ancestry, String species,
            String patronus, String actorName, String eyeColour, String hairColor,
            String gender, ArrayList<String> alternate_names, boolean hogwartsStudent,
            boolean hogwartsStaff, boolean alive, boolean wizard, Date dateOfBirth,
            int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.actorName = actorName;
        this.eyeColour = eyeColour;
        this.hairColor = hairColor;
        this.gender = gender;
        this.alternate_names = alternate_names;
        this.hogwartsStudent = hogwartsStudent;
        this.hogwartsStaff = hogwartsStaff;
        this.alive = alive;
        this.wizard = wizard;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Get
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getHouse() {
        return this.house;
    }

    public String getAncestry() {
        return this.ancestry;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getPatronus() {
        return this.patronus;
    }

    public String getActorname() {
        return this.actorName;
    }

    public String getEyeColour() {
        return this.eyeColour;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public String getGender() {
        return this.gender;
    }

    public ArrayList<String> getAlternateNames() {
        return this.alternate_names;
    }

    public boolean getHogwartsStudent() {
        return this.hogwartsStudent;
    }

    public boolean getHogwartsStaff() {
        return this.hogwartsStaff;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public boolean getWizard() {
        return this.wizard;
    }

    public int getYear() {
        return this.yearOfBirth;
    }

    public Date getDate() {
        return this.dateOfBirth;
    }

    // Set
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(String housename) {
        this.house = housename;
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

    public void setActorName(String name) {
        this.actorName = name;
    }

    public void setEyeColor(String color) {
        this.eyeColour = color;
    }

    public void setHairColor(String color) {
        this.hairColor = color;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAlternateNames(ArrayList<String> names) {
        this.alternate_names = names;
    }

    public void setHogwartsStudent(boolean isStudent) {
        this.hogwartsStudent = isStudent;
    }

    public void setHogwartsStaff(boolean haveStaff) {
        this.hogwartsStaff = haveStaff;
    }

    public void setAlive(boolean isAlive) {
        this.alive = isAlive;
    }

    public void setWizard(boolean isWizard) {
        this.wizard = isWizard;
    }

    public void setYear(int newYear) {
        this.yearOfBirth = newYear;
    }

    public void setDate(Date newDate) {

        this.dateOfBirth = newDate;
    }

    // clone
    public void clone(Personagem newClone) {
        newClone.setYear(this.getYear());
        newClone.setDate(this.getDate());
        newClone.setHogwartsStaff(this.getHogwartsStaff());
        newClone.setAlive(this.getAlive());
        newClone.setWizard(this.getWizard());
        newClone.setGender(this.getGender());
        newClone.setAlternateNames(this.getAlternateNames());
        newClone.setGender(this.getGender());
        newClone.setHogwartsStudent(this.getHogwartsStudent());
        newClone.setHairColor(this.getHairColor());
        newClone.setEyeColor(this.getEyeColour());
        newClone.setPatronus(this.getPatronus());
        newClone.setSpecies(this.getSpecies());
        newClone.setAncestry(this.getAncestry());
        newClone.setHouse(this.getHouse());
        newClone.setName(this.getName());
        newClone.setId(this.getId());

    }

    // imprimir
    public void imprimir() {
        String arrayPrintado = "{";
        if (!this.getAlternateNames().isEmpty()) {
            for (int i = 0; i < this.getAlternateNames().size(); i++) {
                arrayPrintado += this.getAlternateNames().get(i);
                if (i < this.getAlternateNames().size() - 1) {
                    arrayPrintado += ", ";
                }
            }
        }

        arrayPrintado += "}";
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = "";
        if (this.getDate() != null) {
            dataFormatada = formato.format(this.getDate());
        } else {
            dataFormatada = "Data não disponível";
        }
        System.out.println("## " + this.getId() + " ## " + this.getName() + " ## " + arrayPrintado + " ## "
                + this.getHouse() + " ## " + this.getAncestry() + " ## " + this.getSpecies() + " ## "
                + this.getPatronus() + " ## " + this.getHogwartsStaff() + " ## " + this.getHogwartsStudent() + " ## "
                + this.getActorname() + " ## " + this.getAlive() + " ## " + dataFormatada + " ## " + this.getYear()
                + " ## " + this.getEyeColour() + " ## " + this.getGender() + " ## " + this.getHairColor() + " ## "
                + this.getWizard() + "]");
    }

    // Ler
    public void ler(String id) {
        String path = "/tmp/characters.csv";
        try {
            File dados = new File(path);
            Scanner sc = new Scanner(dados);

            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                int p = 0;
                while (linha.charAt(p) != '[') {
                    p++;
                }
                int j = p;
                while (linha.charAt(j) != ']') {
                    j++;
                }
                int ind = p;
                int end = j;

                String[] colunas = linha.split(";");

                if (colunas.length > 0 && colunas[0].equals(id)) {
                    this.setId(colunas[0]);
                    this.setName(colunas[1]);
                    this.setHouse(colunas[3]);
                    this.setAncestry(colunas[4]);
                    this.setSpecies(colunas[5]);
                    this.setPatronus(colunas[6]);
                    if (colunas[7].compareTo("VERDADEIRO") == 0) {
                        this.setHogwartsStaff(true);
                    } else {
                        this.setHogwartsStaff(false);
                    }
                    if (colunas[8].compareTo("VERDADEIRO") == 0) {
                        this.setHogwartsStudent(true);
                    } else {
                        this.setHogwartsStudent(false);
                    }
                    this.setActorName(colunas[9]);
                    if (colunas[10].compareTo("VERDADEIRO") == 0) {
                        this.setAlive(true);
                    } else {
                        this.setAlive(false);
                    }
                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        this.setDate(formato.parse(colunas[12]));
                    } catch (ParseException e) {
                        System.err.println("Formato de data inválido.");
                    }
                    this.setYear(Integer.parseInt(colunas[13]));
                    this.setEyeColor(colunas[14]);
                    this.setGender(colunas[15]);
                    this.setHairColor(colunas[16]);
                    this.setWizard("VERDADEIRO".equals(colunas[17]));
                    String nomesAlternativos = colunas[2];
                    String nomes[] = nomesAlternativos.split(",");
                    // padronizar

                    for (int n = 0; n < nomes.length; n++) {
                        if (nomes[n].length() > 0) {
                            if (nomes[n].charAt(0) == ' ') {
                                String aux = "";
                                for (int x = 0; x < nomes[n].length() - 1; x++) {
                                    aux += nomes[n].charAt(x + 1);
                                }
                                nomes[n] = aux;
                            }
                            if (nomes[n].charAt(0) == '[') {
                                String aux = "";
                                for (int x = 0; x < nomes[n].length() - 1; x++) {
                                    aux += nomes[n].charAt(x + 1);
                                }
                                nomes[n] = aux;
                            }
                            if (nomes[n].charAt(nomes[n].length() - 1) == ']') {
                                String aux = "";
                                for (int x = 0; x < nomes[n].length() - 1; x++) {
                                    aux += nomes[n].charAt(x);
                                }
                                nomes[n] = aux;
                            }
                            if (nomes[n].length() > 0 && nomes[n].charAt(0) == '\'') {
                                String aux = "";
                                for (int x = 0; x < nomes[n].length() - 1; x++) {
                                    aux += nomes[n].charAt(x + 1);
                                }
                                nomes[n] = aux;
                            }
                            if (nomes[n].length() > 0 && nomes[n].charAt(nomes[n].length() - 1) == '\'') {
                                String aux = "";
                                for (int x = 0; x < nomes[n].length() - 1; x++) {
                                    aux += nomes[n].charAt(x);
                                }
                                nomes[n] = aux;
                            }
                        }
                    }

                    ArrayList<String> Alternativos = new ArrayList<String>();
                    for (int i = 0; i < nomes.length; i++) {
                        Alternativos.add(nomes[i]);
                    }
                    this.setAlternateNames(Alternativos);
                }
            }
            sc.close();
        } catch (FileNotFoundException erro) {
            erro.printStackTrace();
        }
    }

    public void addName(String name) {
        this.alternate_names.add(name);
    }

}

public class TP03Q01{

    public static boolean checkEnd(String entrada) {
        boolean check = true;
        if (entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M') {
            check = false;
        }
        return check;
    }

    public static boolean checkEqual(String s1, String s2) {
        boolean check = false;
        int count = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    count++;
                }
            }
        }
        if (count == s1.length()) {
            check = true;
        }
        return check;
    }

    public static Personagem[] aumentaArray(Personagem[] array, Personagem novoPersonagem) {
        Personagem[] newArray = new Personagem[array.length + 1];
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
        }
        newArray[array.length] = novoPersonagem;
        return newArray;
    }


    public static void swap(Personagem[] registros, int i, int j) {
        Personagem aux = registros[i];
        registros[i] = registros[j];
        registros[j] = aux;
    }

    static String parseOption(String s) {
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            aux.append(s.charAt(i));
        }
        return aux.toString();
    }

    static String parseID(String s) {
        StringBuilder aux = new StringBuilder();
        for (int i = 3; i < s.length(); i++) {
            aux.append(s.charAt(i));
        }
        return aux.toString();
    }

    static Personagem search(Personagem[] registros, int n, String id) {
        Personagem tmp = new Personagem();
        for (int i = 0; i < n; i++) {
            if (registros[i].getId().compareTo(id) == 0) {
                tmp = registros[i];
            }
        }
        return tmp;
    }

    static boolean parseSuccess(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Personagem[] registros = new Personagem[0];
        Personagem[] removidos = new Personagem[0];
        int count = 0;
        Lista newLista = new Lista();
        int n = 0;
        String id = sc.nextLine();
        while (checkEnd(id)) {
            Personagem teste = new Personagem();
            teste.ler(id);
            newLista.inserirFim(teste);
            registros = aumentaArray(registros, teste);
            n++;
            id = sc.nextLine();
        }
        int pos = sc.nextInt();
        sc.nextLine();
        String selection;
        String id2;
        String opt;
        for (int i = 0; i < pos; i++) {
            Personagem novoPersonagem = new Personagem();
            selection = sc.nextLine();
            id2 = parseID(selection);
            opt = parseOption(selection);
            novoPersonagem.ler(id2);
        
            if (opt.equals("II")) {
                newLista.inserirInicio(novoPersonagem);
            } else if (opt.equals("I*")) {
                opt = parseOption(id2);
                id2 = parseID(id2);
                novoPersonagem.ler(id2);
                newLista.inserir(novoPersonagem, Integer.parseInt(opt));
            } else if (opt.equals("IF")) {
                newLista.inserirFim(novoPersonagem);
            } else if (opt.equals("RI")) {
                removidos = aumentaArray(removidos, newLista.removerInicio());
                count++;
            } else if (opt.equals("R*")) {
                removidos = aumentaArray(removidos, newLista.remover(Integer.parseInt(id2)));
                count++;
            } else if (opt.equals("RF")) {
                removidos = aumentaArray(removidos, newLista.removerFim());
                count++;
            } else {
                System.out.println("Incorreta");
            }
        }
        
        for (int i = 0; i < count; i++) {
            System.out.println("(R) " + removidos[i].getName());
        }
        newLista.printar();

        sc.close();

    }

}