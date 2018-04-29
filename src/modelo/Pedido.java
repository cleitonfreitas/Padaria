/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.JpaUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
@Entity
@Table
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;
    @Column(name = "total")
    private double total;
    
    @OneToMany(mappedBy = "pedido")
    private List<ItensPedido>itens;

    public Pedido() {
    }

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", data=" + data + ", total=" + total + ", itens=" + itens + '}';
    }
 
    public void leituraCodigoBarras(String barras){
        EntityManager manager = JpaUtil.getEm();
        EntityTransaction tx = manager.getTransaction();
        
        tx.begin();
        Fichas ficha = manager.find(Fichas.class, barras);
        tx.commit();
        
        if (!ficha.isSituacao()){
            JOptionPane.showMessageDialog(null, " Ficha não Cadastrada! ");
        }
            
        manager.close();
        JpaUtil.close();
    }
    
    public void adicionarItensPedido(String barras){
        EntityManager manager = JpaUtil.getEm();
        EntityTransaction tx = manager.getTransaction();
        
        tx.begin();
        
    }
    
}
