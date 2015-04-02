package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * @author Mauro Silva
 * @version 1.0
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "encontreTodasPessoas",
            query = "SELECT p from Pessoa p"),
    @NamedQuery(name = "encontrePessoaJoao",
            query = "SELECT p from Pessoa p WHERE p.primeiroNome='Joao'")
        ,})
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String cpf;
    private String primeiroNome;
    private String ultimoNome;

    protected Pessoa() {
    }

    public Pessoa(String cpfParam, String primeiroNomeParam, String ultimoNomeParam) {

        cpf = cpfParam;
        primeiroNome = primeiroNomeParam;
        ultimoNome = ultimoNomeParam;
    }

    // Construtor Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

}
