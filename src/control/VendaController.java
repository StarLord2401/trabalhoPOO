package control;

import model.Venda;

public class VendaController {
    
    public boolean add(Venda[] vetor, Venda venda){
        if (venda != null && vetor != null) 
            for (int i = 0; i < vetor.length; i++) 
                if (vetor[i] == null) {
                    vetor[i] = venda;
                    return true;
                }
        return false;
    }

    public Venda findById(int idVenda, Venda[] vetor){
        Venda venda;
        for (int i = 0; i < vetor.length; i++) 
            if (vetor[i] != null && vetor[i].getIdVenda() == idVenda) 
                return vetor[i];
        return venda = null;
    }

    public Venda[] findByDate(String dataString, Venda[] vetor){
        Venda[] answer = new Venda[vetor.length];
        int k = 0;
        for (int i = 0; i < vetor.length; i++) 
            if (vetor[i] != null && dataString.equals(vetor[i].getData())){
                answer[k] = vetor[i];
                k++;
            }
        return answer;
    }
}
