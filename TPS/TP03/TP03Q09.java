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
    public int elemento;
    public Celula dir;
    public Celula esq;
    public Celula sup;
    public Celula inf;

    public Celula() {
        this.elemento = 0;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }

    public Celula(int x) {
        this.elemento = x;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
}

class MatrizFlexivel {
    private Celula inicio;
    private int linha, coluna;

    public MatrizFlexivel() {
        this(3, 3);
    }

    public MatrizFlexivel(int linhas, int colunas) {
        inicio = new Celula(0);
        this.linha = linhas;
        this.coluna = colunas;
        Celula i = inicio;
        for (int j = 1; j < this.coluna; j++) {
            Celula nova = new Celula(0);
            i.dir = nova;
            nova.esq = i;
            i = nova;
        }

        Celula linhaAnterior = inicio;
        for (int k = 1; k < this.linha; k++) {
            Celula novaLinha = new Celula(0);
            linhaAnterior.inf = novaLinha;
            novaLinha.sup = linhaAnterior;

            Celula celulaAtualLinha = novaLinha;
            Celula celulaAcima = linhaAnterior;
            for (int j = 1; j < this.coluna; j++) {
                Celula novaCelula = new Celula(0);
                celulaAtualLinha.dir = novaCelula;
                novaCelula.esq = celulaAtualLinha;

                celulaAcima = celulaAcima.dir;
                celulaAcima.inf = novaCelula;
                novaCelula.sup = celulaAcima;

                celulaAtualLinha = novaCelula;
            }
            linhaAnterior = novaLinha;
        }

    }

    public void printar() {
        Celula i = inicio;
        Celula sentinela = inicio;
        for (int j = 0; j < linha; j++) {
            for (int k = 0; k < coluna; k++) {
                System.out.print(i.elemento + " ");
                i = i.dir;
            }
            sentinela = sentinela.inf;
            i = sentinela;
            System.out.println();
        }
    }

    public void diagPrincipal() {
        Celula j = inicio;
        while (j.dir != null) {
            System.out.print(j.elemento + " ");
            j = j.inf;
            j = j.dir;
        }
        System.out.print(j.elemento + " ");
    }

    public void insert(int x) {
        Celula j = inicio;
        Celula acompanharInicio = inicio;
        while (j.elemento != 0) {
            j = j.dir;
            if (j == null) {
                acompanharInicio = acompanharInicio.inf;
                j = acompanharInicio;
                if (j == null && acompanharInicio == null) {
                    System.out.println("LISTA CHEIA");
                    break;
                }
            }
        }
        j.elemento = x;
    }

    public void diagSecundaria() {
        System.out.println();
        Celula j = inicio;
        int count = 0;
        while (j.dir != null) {
            j = j.dir;
        }
        while (j.esq != null) {
            System.out.print(j.elemento + " ");
            j = j.inf;
            j = j.esq;
        }
        System.out.println(j.elemento);

    }

    public MatrizFlexivel somarComOutraMatriz(MatrizFlexivel outra) {
        MatrizFlexivel soma = new MatrizFlexivel(this.linha, this.coluna);
        Celula percorreSoma = soma.inicio;
        Celula percorreMatriz = this.inicio;
        Celula percorreOutra = outra.inicio;
        Celula percorreLinhaMatriz = this.inicio;
        Celula percorreLinhaSoma = soma.inicio;
        Celula percorreLinhaOutra = outra.inicio;
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                percorreSoma.elemento = percorreMatriz.elemento + percorreOutra.elemento;
                percorreSoma = percorreSoma.dir;
                percorreOutra = percorreOutra.dir;
                percorreMatriz = percorreMatriz.dir;
            }
            percorreLinhaMatriz = percorreLinhaMatriz.inf;
            percorreLinhaOutra = percorreLinhaOutra.inf;
            percorreLinhaSoma = percorreLinhaSoma.inf;
            percorreSoma = percorreLinhaSoma;
            percorreOutra = percorreLinhaOutra;
            percorreMatriz = percorreLinhaMatriz;
        }
        return soma;
    }

    public MatrizFlexivel multiplicarComOutraMatriz(MatrizFlexivel outra) {
        if (this.coluna != outra.linha) {
            throw new IllegalArgumentException("As matrizes não podem ser multiplicadas");
        }

        MatrizFlexivel produto = new MatrizFlexivel(this.linha, outra.coluna);

        Celula percorreProdutoLinha = produto.inicio;
        Celula percorreMatrizLinha = this.inicio;
        Celula OutraSentinela = outra.inicio;

        for (int i = 0; i < this.linha; i++) {
            Celula percorreProdutoColuna = percorreProdutoLinha;
            for (int j = 0; j < outra.coluna; j++) {
                int soma = 0;
                Celula percorreMatriz = percorreMatrizLinha;
                Celula percorreOutra = OutraSentinela;

                for (int k = 0; k < this.coluna; k++) {
                    soma += percorreMatriz.elemento * percorreOutra.elemento;
                    percorreMatriz = percorreMatriz.dir;
                    percorreOutra = percorreOutra.inf;
                }

                percorreProdutoColuna.elemento = soma;
                percorreProdutoColuna = percorreProdutoColuna.dir;
                OutraSentinela = OutraSentinela.dir;
            }

            percorreMatrizLinha = percorreMatrizLinha.inf;
            OutraSentinela = outra.inicio;
            percorreProdutoLinha = percorreProdutoLinha.inf;
        }

        return produto;
    }

}

class Personagem {
    // Elementos

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

    // Métodos Get
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

    // Métodos Set
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

    // Método clone
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

    // Método de imprimir
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

    // Método de Ler
    public void ler(String id) {
        String path = "tmp/characters.csv";
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

}

public class TP03Q09 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            int linhaMatriz1 = sc.nextInt();
            int colunaMatriz1 = sc.nextInt();
            sc.nextLine();
            MatrizFlexivel Matriz1 = new MatrizFlexivel(linhaMatriz1, colunaMatriz1);
            for (int j = 0; j < linhaMatriz1; j++) {
                String elementosPorLinha = sc.nextLine();
                String[] elementos = elementosPorLinha.split(" ");
                for (String elemento : elementos) {
                    Matriz1.insert(Integer.parseInt(elemento));
                }
            }
            int linhaMatriz2 = sc.nextInt();
            int colunaMatriz2 = sc.nextInt();
            sc.nextLine();
            MatrizFlexivel Matriz2 = new MatrizFlexivel(linhaMatriz2, colunaMatriz2);
            for (int j = 0; j < linhaMatriz2; j++) {
                String elementosPorLinha = sc.nextLine();
                String[] elementos = elementosPorLinha.split(" ");
                for (String elemento : elementos) {
                    Matriz2.insert(Integer.parseInt(elemento));
                }
            }
            Matriz1.diagPrincipal();
            Matriz1.diagSecundaria();
            MatrizFlexivel somaDasMatrizes = Matriz1.somarComOutraMatriz(Matriz2);
            somaDasMatrizes.printar();
            MatrizFlexivel multiplicarMatrizes = Matriz1.multiplicarComOutraMatriz(Matriz2);
            multiplicarMatrizes.printar();

        }

        sc.close();

    }

}