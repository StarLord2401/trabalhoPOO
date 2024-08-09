package model;

import java.util.Date;

public class Venda {
    private static int geraId = 0;
    private int idVenda;
    private Date data;
    private Item[] itensVendidos;
    private String cliente;

    public static Venda getInstance(Date data, Item[] itensVendidos, String cliente){
        if (itensVendidos != null)
            return new Venda(data, itensVendidos, cliente);
        return null;
    }

    public static Venda getInstance(Item[] itensVendidos, String cliente){
        if (itensVendidos != null)
            return new Venda(itensVendidos, cliente);
        return null;
    }

    private Venda(Date data, Item[] itensVendidos, String cliente){
        geraId++;
        this.idVenda = geraId;
        this.data = data;
        this.itensVendidos = itensVendidos;
        this.cliente = cliente;
    }

    private Venda(Item[] itensVendidos, String cliente){
        geraId++;
        this.idVenda = geraId;
        this.data = new Date();
        this.itensVendidos = itensVendidos;
        this.cliente = cliente;
    }
}
