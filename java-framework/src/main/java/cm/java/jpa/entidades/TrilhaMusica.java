package cm.java.jpa.entidades;

/**
 * Exemplo usando @Basic LAZY
 * @author Mauro Silva
 * @version 1.0
 */

import javax.persistence.*;


@Entity
@Table(name = "T_Trilha_Musica")
public class TrilhaMusica {

  // ======================================
  // =             Attributos             =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private Float duracao;
  @Basic(fetch = FetchType.LAZY)
  @Lob
  private byte[] musica;
  private String descricao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public TrilhaMusica() {
  }

  public TrilhaMusica(String tituloParam, Float duracaoParam, String descricaoParam) {
    titulo = tituloParam;
    duracao = duracaoParam;
    descricao = descricaoParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Float getDuracao() {
    return duracao;
  }

  public void setDuracao(Float duracao) {
    this.duracao = duracao;
  }

  public byte[] getMusica() {
    return musica;
  }

  public void setMusica(byte[] musica) {
    this.musica = musica;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
