package model;

public class Produto {
    private static int geraId = 0;
    private int idProduto;
    private String nome;
    private float preco;
    private Marca marca;
    private int estoque;

    static public Produto getInstance(String nome, float preco, Marca marca, int estoque){
        if (nome.length() > 2 && preco > 0 && marca != null && estoque > 0){
            geraId++;
            return new Produto(nome, preco, marca, estoque);
        }else
            return null;
    }

    static public Produto getInstace(){
        return new Produto(null, 0, null, 0);
    }

    private Produto(String nome, float preco, Marca marca, int estoque){
        this.idProduto = geraId;
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getMarca() {
        return marca.getNome();
    }

    public void setMarca(Marca marca) {
        if (marca != null)
            this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco > 0.0)
            this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 2)
            this.nome = nome;         
    }

    public int getIdProduto() {
        return idProduto;
    }
}
