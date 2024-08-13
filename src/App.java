import control.ProdutoController;
import control.MarcaController;

import view.ProdutoView;
import view.Sistema;

public class App {

    public static void main(String[] args) throws Exception {
        ProdutoController pController = new ProdutoController();
        MarcaController mController = new MarcaController();
        ProdutoView vProduto = new ProdutoView();

        Sistema system = Sistema.getInstance();
        system.init(pController, mController);
        system.trocarUsuario(pController, vProduto, mController);
        // system.menuPrincipal(produtoController, marcaController, vProduto);
    }

    

}
