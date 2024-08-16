package view;

import model.Venda;

public class VendaView {
    ItemView vItem = new ItemView();

    public void showAll(Venda[] vetor) {
        if(vetor != null){
            for (int i = 0; i < vetor.length; i++)
                if (vetor[i] != null) {
                    showInList(vetor[i], i);
                }
            System.out.println();
        }
    }

    private void showInList(Venda venda, int position) {
        header(position);
        System.out.printf("%-17s", venda.getIdVenda());
        System.out.printf("%-17s", venda.getData());
        System.out.printf("%-17s", venda.getCliente());
        System.out.println("\n--------------------- ITENS VENDIDOS --------------------------");
        this.vItem.showItensVendidos(venda.getItensVendidos());
        System.out.println("------------------------------------------------------------");
    }

    private void header(int position) {
        System.out.println("\n\n------------------------- VENDA " + position + " ----------------------------");
        System.out.printf("%-17s", "CÓDIGO");
        System.out.printf("%-17s", "DATA");
        System.out.printf("%-17s", "CLIENTE");
        System.out.println();
    }
}
