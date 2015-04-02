package cm.java.jpa.entidades;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Mauro Silva
 * @version 1.0
 */

@Entity
@Table(name = "noticias")
@IdClass(NoticiaIdClasseId.class)
public class NoticiaClasseId {

  // ======================================
  // =             Attributos             =
  // ======================================

  @Id
  private String titulo;
  @Id
  private String idioma;
  
  private String conteudo;

  // ======================================
  // =            Construtores            =
  // ======================================

  public NoticiaClasseId() {
  }

  public NoticiaClasseId(String tituloParam, String idiomaParam, String conteudoParam) {
    titulo = tituloParam;
    idioma = idiomaParam;
    conteudo = conteudoParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }
}