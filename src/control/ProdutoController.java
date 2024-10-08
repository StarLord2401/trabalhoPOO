package control;

import model.Marca;
import model.Produto;
import view.ProdutoView;

public class ProdutoController {

    public boolean add(Produto produto, Produto[] vetor) {
        if (produto != null && vetor != null)
            for (int i = 0; i < vetor.length; i++)
                if (vetor[i] == null) {
                    vetor[i] = produto;
                    return true;
                }
        return false;
    }

    public boolean delete(int idProduto, Produto[] vetor) {
        int position = -1;
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] != null && vetor[i].getIdProduto() == idProduto) {
                vetor[i] = null;
                position = i;
            }
        if (position != -1) {
            for (int i = position; i < vetor.length - 1; i++)
                vetor[position] = vetor[i + 1];
            return true;
        }
        return false;
    }

    public Produto findById(int idProduto, Produto[] vetor) {
        Produto p;
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] != null && vetor[i].getIdProduto() == idProduto)
                return vetor[i];
        return p = null;
    }

    public boolean alterar(Produto produto, ProdutoView vProduto, Produto[] vetor){
        if (produto != null) {
            vProduto.show(produto);
            vProduto.menuAlterar(produto);
            if (this.update(produto.getIdProduto(), produto, vetor))
                return true;
        }
        return false;
    }

    private boolean update(int idProduto, Produto novo, Produto[] vetor) {
        if (novo != null) 
            for (int i = 0; i < vetor.length; i++)
                if (vetor[i] != null && vetor[i].getIdProduto() == idProduto) {
                    vetor[i].setNome(novo.getNome());
                    vetor[i].setPreco(novo.getPreco());
                    vetor[i].setMarca(Marca.getInstance(novo.getMarca()));
                    vetor[i].setEstoque(novo.getEstoque());
                    return true;
                }
        return false;
    }
}
