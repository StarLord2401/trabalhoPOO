package control;

import model.Marca;

public class MarcaController {

    private static Marca[] marcas = new Marca[20];

    public boolean add (Marca marca){
        if (marca != null) {
            for (int i = 0; i < marcas.length; i++) 
                if (marcas[i] == null) 
                    marcas[i] = marca;
                    return true;
                }
        return false;
    }

    public Marca verificarMarca(String marca){
        if (marca != null && marca != "") 
            for (int i = 0; i < marcas.length; i++) 
                if (marcas[i] != null && marcas[i].getNome().equals(marca)) 
                    return marcas[i];
        return null;
    }
}
