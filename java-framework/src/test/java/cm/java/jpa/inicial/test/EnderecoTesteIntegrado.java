package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.Endereco;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class EnderecoTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes Unitarios            =
  // ======================================

  @Test
  public void deveriaCriarUmEndereco() throws Exception {

    Endereco endereco = new Endereco(getIdRandomico(), "Rua A", "Lote B", "Rio", "RJ", "223232-000", "BR");
    tx.begin();
    em.persist(endereco);
    tx.commit();
    assertNotNull("O Id não deveria ser nulo", endereco.getId());
  }
}