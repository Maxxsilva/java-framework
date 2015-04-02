package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.NoticiaAgrupado;
import cm.java.jpa.entidades.NoticiaIdAgrupado;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Mauro Silva
 * @version 1.0
 */


public class NoticiaAgrupadoTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmaNoticia() throws Exception {

    NoticiaIdAgrupado noticiaId = new NoticiaIdAgrupado("Flamengo vence Jogo e segue invicto", "PT");
    NoticiaAgrupado noticia = new NoticiaAgrupado(noticiaId, "Flamengo vence mais um jogo e segue invicto no campeonato estadual de 2015.");
    tx.begin();
    em.persist(noticia);
    tx.commit();

    noticia = em.find(NoticiaAgrupado.class, new NoticiaIdAgrupado("Flamengo vence Jogo e segue invicto", "PT"));

    assertEquals("Flamengo vence mais um jogo e segue invicto no campeonato estadual de 2015.", noticia.getConteudo());
  }
}