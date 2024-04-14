package model;

public class Marca {
    private static int geraId = 0;
    private int idMarca;
    private String nome;

    public static Marca getInstance(String nome) {
        if (nome.length() > 2)
            return new Marca(nome);
        else
            return null;
    }

    private Marca(String nome) {
        geraId++;
        this.idMarca = geraId;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 2)
            this.nome = nome;
    }
}
