package model;

public class Carrinho {
    private static int geraId = 0;
    private int idCarrinho;
    private Item[] itens;


    public static Carrinho getInstance(){
        return new Carrinho();
    }

    private Carrinho(){
        geraId++;
        this.idCarrinho = geraId++;
    }

    public boolean addItem(Item item){
        for (int i = 0; i < itens.length; i++)
            if(itens[i] == null){
                itens[i] = item;
                return true;
            }
        return false;
    }

    
}
