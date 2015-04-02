package cm.java.jpa.entidades;

import cm.java.jpa.enumeradores.BandeiraCartaoCredito;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exemplo usando anotação @Enumerated para definir um campo o valor de String
 * @author Mauro Silva
 * @version 1.0
 */

@Entity
@Table(name = "cartao_credito")
public class CartaoCredito {
  // ======================================
  // =             Attributos             =
  // ======================================
    @Id
    private String numero;
    private String dataValidade;
    private Integer numeroControle;
    @Enumerated(EnumType.STRING)
    private BandeiraCartaoCredito bandeiraCartaoCredito;
        
    // ======================================
    // =            Construtores            =
    // ======================================
    
    public CartaoCredito() {        
    }
    
    public CartaoCredito(String numeroParam, String dataValidadeParam, Integer numeroControleParam,
            BandeiraCartaoCredito bandeiraCartaoCreditoParam) {
        this.numero = numeroParam;
        this.dataValidade = dataValidadeParam;
        this.numeroControle = numeroControleParam;
        this.bandeiraCartaoCredito = bandeiraCartaoCreditoParam;        
    }
    
  // ======================================
  // =          Getters & Setters         =
  // ======================================

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Integer getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(Integer numeroControle) {
        this.numeroControle = numeroControle;
    }

    public BandeiraCartaoCredito getBandeiraCartaoCredito() {
        return bandeiraCartaoCredito;
    }

    public void setBandeiraCartaoCredito(BandeiraCartaoCredito bandeiraCartaoCredito) {
        this.bandeiraCartaoCredito = bandeiraCartaoCredito;
    }
    
    
    
    
}