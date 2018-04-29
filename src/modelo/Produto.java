/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cleiton
 */
@Entity
@Table(name = "produto")
public class Produto implements EntidadeBase, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "barras")
    private String codigoBarras;
    @Column(name = "nome")
    private String nome;
    @Column(name = "unid_med")
    private String unidadeMedida;
    @Column(name = "valor")
    private double valor;
    @Column(name = "categ")
    private String categoria;
    
    @OneToMany(mappedBy = "produto")
    private List<ItensPedido>itens;

    public Produto() {}

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", codigoBarras=" + codigoBarras + ", nome=" + nome + ", unidadeMedida=" + unidadeMedida + ", valor=" + valor + ", categoria=" + categoria + ", itens=" + itens + '}';
    }
    
    
}
