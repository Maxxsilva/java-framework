package cm.java.jpa.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Exemplo usado pelo ConsumidorEmb  
 * @author Mauro Silva
 * @version 1.0
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class EnderecoEmb {
  // ======================================
  // =             Attributos             =
  // ======================================  
  private String endereco1;
  private String endereco2;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;

      
  // ======================================
  // =            Construtores            =
  // ======================================
  
  public EnderecoEmb() {      
  }
  
  public EnderecoEmb(String endereco1Param, String endereco2Param, String cidadeParam,
          String estadoParam, String cepParam, String paisParam) {
      this.endereco1 = endereco1Param;
      this.endereco2 = endereco2Param;
      this.cidade = cidadeParam;
      this.estado = estadoParam;
      this.cep = cepParam;
      this.pais = paisParam;
  }
  
  
  // ======================================
  // =          Getters & Setters         =
  // ======================================  
     @Column(nullable = false)
    public String getEndereco1() {
        return endereco1;
    }
 
    public void setEndereco1(String endereco1) {
        this.endereco1 = endereco1;
    }
    
    public String getEndereco2() {
        return endereco2;
    }
    
      public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}