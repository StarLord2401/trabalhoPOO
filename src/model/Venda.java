package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Venda {
    private static SimpleDateFormat mascara;
    private static int geraId = 0;
    private int idVenda;
    private Date data;
    private Item[] itensVendidos;
    private String cliente;

    public static Venda getInstance(String dataString, Item[] itensVendidos, String cliente){
        if (itensVendidos != null){
            try {
                mascara = new SimpleDateFormat("dd/MM/yyyy");
                Date data = mascara.parse(dataString);
                return new Venda(data, itensVendidos, cliente);
            } catch (Exception e) {
                return new Venda(itensVendidos, cliente);
            }
        }
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

    public int getIdVenda() {
        return idVenda;
    }

    public String getData() {
        return mascara.format(data);
    }

    public Item[] getItensVendidos() {
        return itensVendidos;
    }

    public String getCliente() {
        return cliente;
    }
}
