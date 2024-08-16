package view;

import model.Item;

public class ItemView {
    
    public void showItensVendidos(Item[] vetor){
        if(vetor != null){
            header();
            for (int i = 0; i < vetor.length; i++)
                if (vetor[i] != null) {
                    System.out.println();
                    showInList(vetor[i]);
                }
            System.out.println();
        }
    }

    private void header() {
        System.out.printf("%-17s", "CÓDIGO");
        System.out.printf("%-17s", "PRODUTO");
        System.out.printf("%-17s", "VALOR");
        System.out.printf("%-17s", "QUANTIDADE");
        System.out.println();
    }

    private void showInList(Item item) {
        System.out.printf("%-17s", item.getIdItem());
        System.out.printf("%-17s", item.getProduto());
        System.out.printf("%-17s", item.getValor());
        System.out.printf("%-17s", item.getQuantidade());
    }
}
