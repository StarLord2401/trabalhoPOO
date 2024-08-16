package view;

import java.util.Scanner;

import control.MarcaController;
import control.ProdutoController;
import control.VendaController;
import model.Carrinho;
import model.Item;
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
    public void init(ProdutoController pController, MarcaController mController, VendaController vController) {
        // criando marca do produto
        Marca marca = Marca.getInstance("Minas Mais");
        mController.add(marca);
        // criando produtos
        Produto produto = Produto.getInstance("Arroz", 28.50f, marca, 500);
        pController.add(produto, this.produtos);
        produto = Produto.getInstance("Feijão", 11, marca, 2500);
        pController.add(produto, this.produtos);
        produto = Produto.getInstance("Macarrão", 8.70f, marca, 1000);
        pController.add(produto, this.produtos);
        produto = Produto.getInstance("Suco 1L", 7.99f, marca, 550);
        pController.add(produto, this.produtos);
        produto = Produto.getInstance("Café", 13.5f, marca, 1200);
        pController.add(produto, this.produtos);

        // cadastro venda 1
        Carrinho carrinho = Carrinho.getInstance();
        carrinho.addItem(Item.getInstance(this.produtos[0], 30, 2));
        carrinho.addItem(Item.getInstance(this.produtos[1], 10, 1));
        carrinho.addItem(Item.getInstance(this.produtos[2], 9, 5));
        Venda venda = Venda.getInstance(carrinho.getItens(), "João Paulo");
        vController.add(this.vendas, venda); // inserir venda no vetor vendas
        carrinho.resetCarrinho();
        // venda 2
        carrinho.addItem(Item.getInstance(this.produtos[3], 10, 1));
        carrinho.addItem(Item.getInstance(this.produtos[4], 15, 2));
        venda = Venda.getInstance(carrinho.getItens(), "Caio Francisco");
        vController.add(this.vendas, venda);
        carrinho.resetCarrinho();
    }

    public void trocarUsuario(ProdutoController pController, ProdutoView vProduto, MarcaController mController, VendaView vVenda){
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
                menuAtendente(pController, vProduto, mController, vVenda);
                break;
            case 2:
                System.out.println("ADMINISTRADOR");
                menuAdministrador(pController, vProduto, mController, vVenda);
                break;
            default:
                System.out.println("FIM DO PROGRAMA");
                return;
        }
    }

    public void menuAtendente(ProdutoController pController, ProdutoView vProduto, MarcaController mController, VendaView vVenda){
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
                trocarUsuario(pController, vProduto, mController, vVenda);
                return;
        }
        scanner.nextLine();
        menuAtendente(pController, vProduto, mController, vVenda);
    }

    public void menuAdministrador(ProdutoController pController, ProdutoView vProduto, MarcaController mController, VendaView vVenda){
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
                if (pController.add(produto, this.produtos))
                    System.out.println("Novo produto inserido!");
                else
                    System.out.println("Falha ao inserir novo produto!");
                break;

            case 2:
                // excluir produto da loja
                System.out.print("Informe o código do produto a ser excluído: ");
                int idProduto = scanner.nextInt();
                if (pController.delete(idProduto, produtos))
                    System.out.println("Produto excluído!");
                else
                    System.out.println("Falha ao excluir produto!");
                break;

            case 3:
                // alterar dados de um produto
                if (alterar(pController, mController, vProduto, vVenda))
                    System.out.println("Produto alterado!");
                else
                    System.out.println("Falha ao alterar produto!");
                break;
            
            case 4:
                // trocar o usuário
                trocarUsuario(pController, vProduto, mController, vVenda);
                return;

            case 5:
                // listar todos os produtos
                vProduto.showAll(this.produtos);
                break;

            case 6:
                // listar todas as vendas
                vVenda.showAll(this.vendas);
                break;
            
            case 7:
                // listar todas as vendas de uma data
                break;
            
            default:
                // buscar venda pelo codigo
                break;
        }
        scanner.nextLine();
        menuAdministrador(pController, vProduto, mController, vVenda);
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

    private boolean alterar(ProdutoController pController, MarcaController mController, ProdutoView vProduto, VendaView vVenda) {
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
                    menuAdministrador(pController, vProduto, mController, vVenda);

            }

            if (pController.update(idProduto, produto, produtos))
                return true;
        }
        return false;
    }
}
