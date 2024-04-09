package control;

import model.Produto;

public class ProdutoController {
    
    public boolean add(Produto produto, Produto[] vetor){
        if (produto != null && vetor != null) 
            for (int i = 0; i < vetor.length; i++) 
                if (vetor[i] == null) {
                    vetor[i] = produto;
                    return true;
                }
        return false;
    }

    public boolean delete(int idProduto, Produto[] vetor){
        int position = -1;
        for (int i = 0; i < vetor.length; i++) 
            if (vetor[i] != null && vetor[i].getIdProduto() == idProduto) {
                vetor[i] = null;
                position = i;
            }
        if (position != -1) {
            for (int i = position; i < vetor.length-1; i++)
                vetor[position] = vetor[i+1];
            return true;
        }
        return false;
    }
}
