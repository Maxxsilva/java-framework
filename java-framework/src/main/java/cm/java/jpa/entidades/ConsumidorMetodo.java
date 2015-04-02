package cm.java.jpa.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Exemplo usando anotação nos Métodos
 * @author Mauro Silva
 * @version 1.0
 */
@Entity
public class ConsumidorMetodo {
  // ======================================
  // =             Attributos             =
  // ======================================    
    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String numeroTelefone;

  // ======================================
  // =            Construtores            =
  // ======================================
    public ConsumidorMetodo () {        
    }    
    
    public ConsumidorMetodo(Long idParam, String primeiroNomeParam, String ultimoNomeParam,
            String emailParam, String numeTelefoneParam) {
        this.id = idParam;
        this.primeiroNome = primeiroNomeParam;
        this.ultimoNome = ultimoNomeParam;
        this.email = emailParam;
        this.numeroTelefone = numeTelefoneParam;
    }
    
    
  // ======================================
  // =          Getters & Setters         =
  // ======================================
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "primeiro_nome", nullable = false, length = 50)
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNomeParam) {
        this.primeiroNome = primeiroNomeParam;
    }
    @Column(name = "ultimo_nome", nullable = false, length = 50)
    public String getUltimoNome() {
        return ultimoNome;
    }
    public void setUltimoNome(String ultimoNomeParam) {
        this.ultimoNome = ultimoNomeParam;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "numero_telefone", length = 15)
    public String getNumeroTelefone() {
        return numeroTelefone;
    }
    public void setNumeroTelefone(String numeroTelefoneParam) {
        this.numeroTelefone = numeroTelefoneParam;
    }
}
