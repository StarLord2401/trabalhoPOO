package view;

import java.util.Scanner;

import control.*;
import model.*;

public class ProdutoView {
    private static Scanner scanner = new Scanner(System.in);
    private static MarcaController mController = new MarcaController();

    public Produto lerProduto() {
        Produto produto = Produto.getInstance();
        System.out.println("---------- PRODUTO -----------");
        System.out.print("Nome do produto: ");
        produto.setNome(scanner.next());
        System.out.print("Preço do produto: ");
        produto.setPreco(scanner.nextFloat());
        System.out.print("Marca do produto: ");
        String texto = scanner.next();
        Marca marca = mController.verificarMarca(texto);
        if (marca != null)
            produto.setMarca(marca);
        else {
            marca = Marca.getInstance(texto);
            mController.add(marca);
            produto.setMarca(marca);
        }
        System.out.print("Quantidade em estoque: ");
        scanner.nextLine();
        produto.setEstoque(scanner.nextInt());

        return produto;
    }

    public void show(Produto produto) {
        System.out.println("\n");
        System.out.println("- - - - - - - - PRODUTO - - - - - - - -");
        System.out.print("Código do produto:    ");
        System.out.printf("%17s", produto.getIdProduto());
        System.out.println();
        System.out.print("Nome do produto:      ");
        System.out.printf("%17s", produto.getNome());
        System.out.println();
        System.out.print("Preço do produto:     ");
        System.out.printf("%17s", produto.getPreco());
        System.out.println();
        System.out.print("Marca do produto:     ");
        System.out.printf("%17s", produto.getMarca());
        System.out.println();
        System.out.print("Quantidade em estoque:");
        System.out.printf("%17s", produto.getEstoque());
        System.out.println();
    }

    public void showInList(Produto produto) {
        System.out.printf("%-17s", produto.getIdProduto());
        System.out.printf("%-17s", produto.getNome());
        System.out.printf("%-17s", produto.getPreco());
        System.out.printf("%-17s", produto.getMarca());
        System.out.printf("%-17s", produto.getEstoque());
    }

    // Listagem em ORDEM DE CADASTRO
    public void showAll(Produto[] vetor) {
        header();
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] != null) {
                System.out.println();
                showInList(vetor[i]);
            }
        System.out.println();
    }

    // Listagem em ORDEM ALFABÉTICA
    public void showAllInOrder(Produto[] produtos) {
        String[] vetAux = new String[cont(produtos)];

        for (int i = 0; i < produtos.length; i++)
            if (produtos[i] != null)
                vetAux[i] = produtos[i].getNome();

        vetAux = order(vetAux);

        header();

        for (int i = 0; i < vetAux.length; i++) {
            System.out.println();
            listByName(vetAux[i], produtos);
        }
    }

    // CONTA O NÚMERO DE PRODUTOS REGISTRADOS
    private int cont(Produto[] produtos) {
        int contador = 0;

        for (int i = 0; i < produtos.length; i++)
            if (produtos[i] != null)
                contador++;

        return contador;
    }

    private void listByName(String string, Produto[] produtos) {
        for (int i = 0; i < produtos.length; i++)
            if (produtos[i] != null && produtos[i].getNome() == string)
                showInList(produtos[i]);
    }

    private String[] order(String[] vetAux) {
        String aux;

        for (int i = 0; i < vetAux.length; i++)
            for (int j = 0; j < vetAux.length; j++)
                if (vetAux[j].compareTo(vetAux[i]) > 0) {
                    aux = vetAux[i];
                    vetAux[i] = vetAux[j];
                    vetAux[j] = aux;
                }

        return vetAux;
    }

    // Bloco de TEXTO
    private void header() {
        System.out.printf("%-17s", "CÓDIGO");
        System.out.printf("%-17s", "NOME");
        System.out.printf("%-17s", "PREÇO");
        System.out.printf("%-17s", "MARCA");
        System.out.printf("%-17s", "ESTOQUE");
        System.out.println();
    }
}
