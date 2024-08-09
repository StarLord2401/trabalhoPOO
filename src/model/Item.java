package model;

public class Item{
    private static int geraId = 0;
    private int idItem;
    private Produto produto;
    private double valor;
    private int quantidade;

    public static Item getInstance(Produto produto, double valor, int quantidade){
        if (produto != null && valor > 0.0 && quantidade > 0)
            return new Item(produto, valor, quantidade);
        return null;
    }

    private Item(Produto produto, double valor, int quantidade){
        geraId++;
        this.idItem = geraId;
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
}
