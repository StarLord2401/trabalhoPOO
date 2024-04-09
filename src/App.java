import control.ProdutoController;
import control.MarcaController;

import model.Produto;
import view.ProdutoView;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Produto[] produtos = new Produto[10];
    public static void main(String[] args) throws Exception {

        ProdutoController produtoController = new ProdutoController();
        MarcaController marcaController = new MarcaController();
        ProdutoView vProduto = new ProdutoView();

        menuPrincipal(produtoController, marcaController, vProduto);
    }

    public static void menuPrincipal(ProdutoController pController, MarcaController mController, ProdutoView vProduto){
        int escolha;
        do {
            System.out.println("---------- MENU PRINCIPAL -----------");
            System.out.println("1 - Inserir produtos");
            System.out.println("2 - Excluir produto");
            System.out.println("3 - Alterar produto");
            System.out.println("LISTAGENS");
            System.out.println("4 - Ver detalhes de um produto");
            System.out.println("5 - Ver produtos cadastrados");
            System.out.println("6 - Ver produtos em ordem alfabética");
            System.out.println("-------------------------------------");
            System.out.print("Opção desejada: ");
            escolha = scanner.nextInt();
        } while (escolha > 6 || escolha < 1);

        switch (escolha) {
            case 1:
                Produto produto = vProduto.lerProduto();
                if (inserir(pController, produto)) 
                    System.out.println("Produto inserido!");
                else
                    System.out.println("Falha ao inserir!");
                
                break;
            
            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            default:

                break;
        }
    }

    private static boolean inserir(ProdutoController pController, Produto produto) {
        if (produto != null) 
            if (pController.add(produto, produtos))
                return true;
        return false;
        
    }

    
}
