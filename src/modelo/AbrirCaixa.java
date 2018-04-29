/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Cleiton
 */
public class AbrirCaixa {
    
    private Integer id;
    private Date data;
    private double valorInicial;
    private boolean aberto;

    public AbrirCaixa() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    @Override
    public String toString() {
        return "AbrirCaixa{" + "id=" + id + ", data=" + data + ", valorInicial=" + valorInicial + ", aberto=" + aberto + '}';
    }
     
}
