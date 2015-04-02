package cm.java.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Exemplo usando anotação nos Campos
 * @author Mauro Silva
 * @version 1.0
 */
@Entity
public class ConsumidorCampo {
  // ======================================
  // =             Attributos             =
  // ======================================    
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "primeiro_nome", nullable = false, length = 50)
    private String primeiroNome;
    @Column(name = "ultimo_nome", nullable = false, length = 50)
    private String ultimoNome;
    private String email;
    @Column(name = "numero_telefone", length = 15)
    private String numeroTelefone;    
        
    // ======================================
    // =            Construtores            =
    // ======================================
    
    public ConsumidorCampo () {        
    }
    
    public ConsumidorCampo(Long idParam, String primeiroNomeParam, String ultimoNomeParam,
            String emailParam, String numeroTelefoneParam) {
        this.id = idParam;
        this.primeiroNome = primeiroNomeParam;
        this.ultimoNome = ultimoNomeParam;
        this.email = emailParam;
        this.numeroTelefone = numeroTelefoneParam;
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
    

    
}
