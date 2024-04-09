package view;

import java.util.Scanner;

import control.*;
import model.*;

public class ProdutoView {
    private static Scanner scanner = new Scanner(System.in);
    private static MarcaController mController = new MarcaController();
    private ProdutoController pController;
    
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
        else{
            marca = Marca.getInstance(texto);
            mController.add(marca);
            produto.setMarca(marca);
        }
        System.out.print("Quantidade em estoque: ");
        produto.setEstoque(scanner.nextInt());

        return produto;
    }

    public void show(Produto produto){
        System.out.println("---------- PRODUTO -----------");
        System.out.println("Código do produto: " + produto.getIdProduto());
        System.out.println("Nome do produto: " + produto.getNome());
        System.out.println("Preço do produto: " + produto.getPreco());
        System.out.println("Marca do produto: " + produto.getMarca());
        System.out.println("Quantidade em estoque: " + produto.getEstoque());
    }

    public void showAll(Produto[] vetor){
        for (int i = 0; i < vetor.length; i++) 
            if (vetor[i] != null) {
                System.out.println();
                show(vetor[i]);
            }
    }
}
