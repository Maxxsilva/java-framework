package cm.java.jpa.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Mauro Silva
 * @version 1.0
 */

@Entity
@Table(name = "noticias")
public class NoticiaAgrupado {

  // ======================================
  // =             Attributos             =
  // ======================================

  @EmbeddedId
  private NoticiaIdAgrupado id;
  private String conteudo;

  // ======================================
  // =            Construtores            =
  // ======================================

  public NoticiaAgrupado() {
  }

  public NoticiaAgrupado(NoticiaIdAgrupado id, String content) {
    this.id = id;
    this.conteudo = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public NoticiaIdAgrupado getId() {
    return id;
  }

  public void setId(NoticiaIdAgrupado id) {
    this.id = id;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }
}