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
public class FecharCaixa {
    
    private Integer id;
    private Date data;
    private double diferenca;
    private double acerto;
    private boolean fechado;

    public FecharCaixa() {}

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

    public double getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(double diferenca) {
        this.diferenca = diferenca;
    }

    public double getAcerto() {
        return acerto;
    }

    public void setAcerto(double acerto) {
        this.acerto = acerto;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    @Override
    public String toString() {
        return "FecharCaixa{" + "id=" + id + ", data=" + data + ", diferenca=" + diferenca + ", acerto=" + acerto + ", fechado=" + fechado + '}';
    }
    
}
