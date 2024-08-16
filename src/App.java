import control.ProdutoController;
import control.VendaController;
import control.MarcaController;

import view.ProdutoView;
import view.Sistema;
import view.VendaView;

public class App {

    public static void main(String[] args) throws Exception {
        ProdutoController pController = new ProdutoController();
        MarcaController mController = new MarcaController();
        VendaController vController = new VendaController();
        
        ProdutoView vProduto = new ProdutoView();
        VendaView vVenda = new VendaView();

        Sistema system = Sistema.getInstance();
        system.init(pController, mController, vController);
        system.trocarUsuario(pController, vProduto, mController, vVenda, vController);
    }
}
