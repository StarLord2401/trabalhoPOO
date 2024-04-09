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
}
