package view;

import model.Venda;

public class VendaView {
    ItemView vItem = new ItemView();

    public void showAll(Venda[] vetor) {
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] != null) 
                showInList(vetor[i], vetor[i].getIdVenda());
    }

    public void show(Venda venda){
        this.showInList(venda, venda.getIdVenda());
    }

    private void showInList(Venda venda, int id) {
        header(id);
        System.out.printf("%-17s", venda.getIdVenda());
        System.out.printf("%-17s", venda.getData());
        System.out.printf("%-17s", venda.getCliente());
        System.out.println("\n--------------------- ITENS VENDIDOS --------------------------");
        this.vItem.showItensVendidos(venda.getItensVendidos());
        System.out.println("------------------------------------------------------------");
    }

    private void header(int id) {
        System.out.println("\n\n------------------------- VENDA " + id + " ----------------------------");
        System.out.printf("%-17s", "CÓDIGO");
        System.out.printf("%-17s", "DATA");
        System.out.printf("%-17s", "CLIENTE\n");
    }
}
