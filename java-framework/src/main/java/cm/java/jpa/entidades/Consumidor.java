package cm.java.jpa.entidades;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Exemplo usando anotações @Temporal - para utilizar campos do tipo data
 * e  @Transient - para que o campo não seja mapeado na tabela
 * @author Mauro Silva
 * @version 1.0
 */

@Entity
public class Consumidor {
  // ======================================
  // =             Attributos             =
  // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String numeroTelefone;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Transient
    private Integer Idade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    
  // ======================================
  // =            Construtores            =
  // ======================================

  public Consumidor() {
  }
  
  public Consumidor(Long idParam, String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam,
  Date dataNascimentoParam, Date dataCriacaoParam) {
      this.id = idParam;
      this.primeiroNome = primeiroNomeParam;
      this.ultimoNome = ultimoNomeParam;
      this.email = emailParam;
      this.numeroTelefone = numeroTelefoneParam;
      this.dataNascimento = dataNascimentoParam;
      this.dataCriacao = dataCriacaoParam;          
  }
  
   // ======================================
  // =          Getters & Setters         =
  // ======================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public int getIdade() {
        return this.getIdade(this.getDataNascimento());
    }
    
     public int getIdade(Date nascimento) {
         
        Calendar cn = Calendar.getInstance();
        cn.setTime(nascimento);

        Date dataAtual = new Date(System.currentTimeMillis());
        Calendar ca = Calendar.getInstance();
        ca.setTime(dataAtual);
       
        int idade = ca.get(Calendar.YEAR) - cn.get(Calendar.YEAR);
        if (ca.get(Calendar.MONTH) < cn.get(Calendar.MONTH)) {
            idade--;
        } else if (ca.get(Calendar.MONTH) == cn.get(Calendar.MONTH)) {
            if (ca.get(Calendar.DAY_OF_MONTH) < cn.get(Calendar.DAY_OF_MONTH))
                idade--;
        }
    return idade;
}

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
  
  
  
}