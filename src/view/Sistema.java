package view;

import java.util.Scanner;

import control.MarcaController;
import control.ProdutoController;
import model.Marca;
import model.Produto;
import model.Venda;

public class Sistema {
    private static Sistema instance;
    private static Scanner scanner;
    private Produto[] produtos;
    private Venda[] vendas;

    public static Sistema getInstance(){
        if(instance == null)
            instance = new Sistema();
        return instance;
    }

    private Sistema(){
        this.scanner = new Scanner(System.in);
        this.produtos = new Produto[10];
        this.vendas = new Venda[10]; 
    }

    // INICIALIZAR COM 5 PRODUTOS E 2 VENDAS CADASTRADAS
    public void init(ProdutoController pController, MarcaController mController) {
        Marca marca = Marca.getInstance("Minas Mais");
        mController.add(marca);
        Produto produto = Produto.getInstance("Arroz", 28.50f, marca, 500);
        inserir(pController, produto);
        produto = Produto.getInstance("Feijão", 11, marca, 2500);
        inserir(pController, produto);
        produto = Produto.getInstance("Macarrão", 8.70f, marca, 1000);
        inserir(pController, produto);
        produto = Produto.getInstance("Suco 1L", 7.99f, marca, 550);
        inserir(pController, produto);
        produto = Produto.getInstance("Café", 13.5f, marca, 1200);
        inserir(pController, produto);        
    }

    public void trocarUsuario(ProdutoController pController, ProdutoView vProduto, MarcaController mController){
        int modulo = 0;
        do {
            System.out.println("\n------------ MÓDULO DO USUÁRIO ------------ ");
            System.out.println("1 - Atendente");
            System.out.println("2 - Administrador");
            System.out.println("3 - Encerrar o programa");
            System.out.println(" ------------------------------------------- ");
            System.out.print("Opção desejada: ");
            modulo = scanner.nextInt();
        } while (modulo < 1 || modulo > 3);
        
        System.out.println();

        switch (modulo) {
            case 1:
                System.out.println("ATENDENTE");
                menuAtendente(pController, vProduto, mController);
                break;
            case 2:
                System.out.println("ADMINISTRADOR");
                menuAdministrador(pController, vProduto, mController);
                break;
            default:
                System.out.println("FIM DO PROGRAMA");
                return;
        }
    }

    public void menuAtendente(ProdutoController pController, ProdutoView vProduto, MarcaController mController){
        /* 
        O atendente realiza a busca e insere os produtos no carrinho, relacionando o preço de venda
        e a quantidade (Item). Esse carrinho conterá referências para diversos itens vendidos. O carrinho
        deverá ficar aberto enquanto o atendente realiza a venda.
        Após encerrar a etapa de inserção de produtos do carrinho, é gerada uma venda. O sistema
        deverá então realizar as operações de baixa no estoque dos produtos que estão no carrinho. A venda
        tem informações sobre o código, data, itens comprados e o nome do cliente.
        */

        int escolha = 0;
        do {
            System.out.println("\n---------- MENU ATENDENTE -----------");
            System.out.println("1 - Inserir produto no carrinho");
            System.out.println("2 - Excluir produto do carrinho");
            System.out.println("3 - Finalizar venda");
            System.out.println("4 - Trocar o usuário");
            System.out.println("-------------------------------------");
            System.out.print("Opção desejada: ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > 4);

        System.out.println();

        switch (escolha) {
            case 1:
                // inserir produto no carrinho
                break;

            case 2:
                // excluir produto do carrinho
                break;

            case 3:
                // finalizar a venda
                break;

            default:
                // trocar o usuário
                trocarUsuario(pController, vProduto, mController);
                return;
        }
        scanner.nextLine();
        menuAtendente(pController, vProduto, mController);
    }

    public void menuAdministrador(ProdutoController pController, ProdutoView vProduto, MarcaController mController){
        /*
        O administrador pode realizar as seguintes operações:
        1. Inserir produtos;
        2. Excluir produtos;
        3. Alterar dados de um produto;
        4. Gerar as listagens:
            a) todos os produtos (exibir: código, nome, marca, preço e quantidade); // LISTAGEM 5
            b) todas as vendas realizadas (exibir: código, data, valor da venda);
            c) todas as vendas de um determinado dia (exibir: código, data, valor da venda);
            d) Pesquisar por uma venda através do código da venda (exibir: código, data, nome do cliente,
            relação dos produtos vendidos e a respectiva quantidade e valor total da venda).
        */

        int escolha = 0;
        do {
            System.out.println("\n---------- MENU ADMINISTRADOR -----------");
            System.out.println("1 - Inserir novo produto");
            System.out.println("2 - Excluir produto");
            System.out.println("3 - Alterar dados de um produto");
            System.out.println("4 - Trocar o usuário");
            System.out.println("--------------- LISTAGENS ----------------");
            System.out.println("5 - Todos os produtos");
            System.out.println("6 - Todas as vendas");
            System.out.println("7 - Todas vendas de uma data");
            System.out.println("8 - Buscar venda pelo código");
            System.out.println("------------------------------------------");
            System.out.print("Opção desejada: ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > 8);

        System.out.println();

        switch (escolha) {
            case 1:
                // inserir novo produto na loja
                Produto produto = vProduto.lerProduto();
                if (inserir(pController, produto))
                    System.out.println("Novo produto inserido!");
                else
                    System.out.println("Falha ao inserir novo produto!");
                break;

            case 2:
                // excluir produto da loja
                if (excluir(pController))
                    System.out.println("Produto excluído!");
                else
                    System.out.println("Falha ao excluir produto!");
                break;

            case 3:
                // alterar dados de um produto
                if (alterar(pController, mController, vProduto))
                    System.out.println("Produto alterado!");
                else
                    System.out.println("Falha ao alterar produto!");
                break;
            
            case 4:
                // trocar o usuário
                trocarUsuario(pController, vProduto, mController);
                return;

            case 5:
                // listar todos os produtos
                listarTodos(vProduto);
                break;

            case 6:
                // listar todas as vendas
                break;
            
            case 7:
                // listar todas as vendas de uma data
                break;
            
            default:
                // buscar venda pelo codigo
                break;
        }
        scanner.nextLine();
        menuAdministrador(pController, vProduto, mController);
    }

    // MENU PRINCIPAL ANTIGO --- NAO SERAH MAIS USADO
    // public void menuPrincipal(ProdutoController pController, MarcaController mController, ProdutoView vProduto) {
    //     int escolha;
    //     do {
    //         System.out.println("\n\n");
    //         System.out.println("---------- MENU PRINCIPAL -----------");
    //         System.out.println();
    //         System.out.println("1 - Inserir produtos");
    //         System.out.println("2 - Excluir produto");
    //         System.out.println("3 - Alterar produto");
    //         System.out.println();
    //         System.out.println("------------- LISTAGENS -------------");
    //         System.out.println();
    //         System.out.println("4 - Ver detalhes de um produto");
    //         System.out.println("5 - Ver produtos cadastrados");
    //         System.out.println("6 - Ver produtos em ordem alfabética");
    //         System.out.println("7 - Encerrar o programa");
    //         System.out.println();
    //         System.out.println("-------------------------------------");
    //         System.out.println();
    //         System.out.print("Opção desejada: ");
    //         escolha = scanner.nextInt();
    //     } while (escolha > 7 || escolha < 1);

    //     System.out.println();

    //     switch (escolha) {
    //         case 1:
    //             Produto produto = vProduto.lerProduto();
    //             if (inserir(pController, produto))
    //                 System.out.println("Produto inserido!");
    //             else
    //                 System.out.println("Falha ao inserir!");

    //             break;

    //         case 2:
    //             if (excluir(pController))
    //                 System.out.println("Produto excluído!");
    //             else
    //                 System.out.println("Falha ao excluir!");
    //             break;

    //         case 3:
    //             if (alterar(pController, mController, vProduto))
    //                 System.out.println("Produto alterado!");
    //             else
    //                 System.out.println("Falha ao alterar!");
    //             break;

    //         case 4:
    //             buscarProduto(pController, vProduto);
    //             break;

    //         case 5:
    //             listarTodos(vProduto);
    //             break;

    //         case 6:
    //             listarOrdenados(vProduto);
    //             break;

    //         default:
    //             return;
    //     }
    //     scanner.nextLine();
    //     menuPrincipal(pController, mController, vProduto);
    // }

    private boolean inserir(ProdutoController pController, Produto produto) {
        if (produto != null)
            if (pController.add(produto, produtos))
                return true;

        return false;
    }

    private boolean excluir(ProdutoController pController) {
        System.out.print("Informe o código do produto a ser excluído: ");
        int idProduto = scanner.nextInt();

        if (pController.delete(idProduto, produtos))
            return true;

        return false;
    }

    private void buscarProduto(ProdutoController pController, ProdutoView vProduto) {
        System.out.print("Informe o código do produto a ser exibido: ");
        int idProduto = scanner.nextInt();
        Produto produto = pController.findById(idProduto, produtos);

        if (produto != null)
            vProduto.show(produto);
        else
            System.out.println("Falha ao exibir!");
    }

    private void listarTodos(ProdutoView vProduto) {
        vProduto.showAll(produtos);
    }

    private void listarOrdenados(ProdutoView vProduto) {
        vProduto.showAllInOrder(produtos);
    }

    private boolean alterar(ProdutoController pController, MarcaController mController, ProdutoView vProduto) {
        System.out.print("Informe o código do produto a ser alterado: ");
        int idProduto = scanner.nextInt();
        Produto produto = pController.findById(idProduto, produtos);

        if (produto != null) {
            vProduto.show(produto);
            int escolha;
            do {
                System.out.println("\n\n");
                System.out.println("---------- MENU DE ALTERAR ----------");
                System.out.println();
                System.out.println("1 - NOME");
                System.out.println("2 - PREÇO");
                System.out.println("3 - MARCA");
                System.out.println("4 - ESTOQUE");
                System.out.println("5 - Retornar ao MENU PRINCIPAL");
                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println();
                System.out.print("Opção desejada: ");
                escolha = scanner.nextInt();
            } while (escolha > 6 || escolha < 1);

            System.out.println();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do produto: ");
                    scanner.nextLine();
                    produto.setNome(scanner.next());
                    break;

                case 2:
                    System.out.print("Preço do produto: ");
                    scanner.nextLine();
                    produto.setPreco(scanner.nextFloat());
                    break;

                case 3:
                    System.out.print("Marca do produto: ");
                    scanner.nextLine();
                    String texto = scanner.next();
                    Marca marca = mController.verificarMarca(texto);
                    if (marca != null)
                        produto.setMarca(marca);
                    else {
                        marca = Marca.getInstance(texto);
                        mController.add(marca);
                        produto.setMarca(marca);
                    }
                    break;

                case 4:
                    System.out.print("Quantidade em estoque: ");
                    scanner.nextLine();
                    produto.setEstoque(scanner.nextInt());
                    break;

                default:
                    menuAdministrador(pController, vProduto, mController);

            }

            if (pController.update(idProduto, produto, produtos))
                return true;
        }
        return false;
    }
}
