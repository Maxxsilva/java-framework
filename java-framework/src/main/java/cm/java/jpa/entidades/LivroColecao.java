package cm.java.jpa.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Exemplo usando Coleções de tipos básicos
 * @author Mauro Silva
 * @version 1.0
*/
@Entity
public class LivroColecao {
  // ======================================
  // =             Attributos             =
  // ======================================    
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private Float preco;
    private String descricao;
    private String isbn;
    private Integer nroDePaginas;
    private Boolean ilustracoes;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Etiqueta")
    @Column(name = "Valor")
    private List<String> etiqueta = new ArrayList<String>();
    
  // ======================================
  // =            Construtores            =
  // ======================================
    
    public LivroColecao () {        
    }
    
    public LivroColecao (Long idParam, String tituloParam, Float precoParam, String descricaoParam,
            String isbnParam, Integer nroPaginasParam, Boolean ilustracoesParam, List<String> etiquetaParam) {        
        this.id = idParam;
        this.titulo = tituloParam;
        this.preco = precoParam;
        this.descricao = descricaoParam;
        this.isbn = isbnParam;
        this.nroDePaginas = nroPaginasParam;
        this.ilustracoes = ilustracoesParam;
        this.etiqueta = etiquetaParam;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNroDePaginas() {
        return nroDePaginas;
    }

    public void setNroDePaginas(Integer nroDePaginas) {
        this.nroDePaginas = nroDePaginas;
    }

    public Boolean getIlustracoes() {
        return ilustracoes;
    }

    public void setIlustracoes(Boolean ilustracoes) {
        this.ilustracoes = ilustracoes;
    }

    public List<String> getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(List<String> etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
}
