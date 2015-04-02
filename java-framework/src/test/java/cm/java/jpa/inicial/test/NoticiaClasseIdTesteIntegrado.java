package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.NoticiaClasseId;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
/**
 * @author Mauro Silva
 * @version 1.0
 */

public class NoticiaClasseIdTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmaNoticia() throws Exception {

    NoticiaClasseId noticia = new NoticiaClasseId("Flamengo vence Jogo e segue invicto", "PT", "Flamengo vence mais um jogo e segue invicto no campeonato estadual de 2015.");
    tx.begin();
    em.persist(noticia);
    tx.commit();
    assertNotNull("O Id não deveria ser nulo", noticia.getTitulo());
  }
}