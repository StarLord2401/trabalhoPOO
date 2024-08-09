import control.ProdutoController;
import control.MarcaController;

import view.ProdutoView;
import view.Sistema;

public class App {

    public static void main(String[] args) throws Exception {
        ProdutoController produtoController = new ProdutoController();
        MarcaController marcaController = new MarcaController();
        ProdutoView vProduto = new ProdutoView();

        Sistema system = Sistema.getInstance();
        system.init(produtoController, marcaController);
        system.trocarUsuario();
        // system.menuPrincipal(produtoController, marcaController, vProduto);
    }

    

}
