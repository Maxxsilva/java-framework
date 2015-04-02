package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.TrilhaMusica;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Mauro Silva
 * @version 1.0
 */
public class TrilhaMusicaTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void devericaCriarUmaTrilha() throws Exception {

    TrilhaMusica trilha = new TrilhaMusica("Heaven in Tears", 3.22f, "Versão de tras pra frente rsrs");
    tx.begin();
    em.persist(trilha);
    tx.commit();
    assertNotNull("O ID não deve ser nulo", trilha.getId());
  }
}