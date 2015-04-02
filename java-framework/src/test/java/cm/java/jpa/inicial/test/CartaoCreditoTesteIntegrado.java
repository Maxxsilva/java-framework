
package cm.java.jpa.inicial.test;

/**
 * @author Mauro Silva
 * @version 1.0
 */

import cm.java.jpa.entidades.CartaoCredito;
import cm.java.jpa.enumeradores.BandeiraCartaoCredito;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CartaoCreditoTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes Unitarios            =
  // ======================================

  @Test
  public void deveriaCriarUmCartaoCredito() throws Exception {
     
    CartaoCredito cartao = new CartaoCredito(String.valueOf(getIdRandomico()), "01/01/2016", 12345, BandeiraCartaoCredito.AMERICAN_EXPRESS);
    tx.begin();
    em.persist(cartao);
    tx.commit();
    
    assertNotNull("O Id não deveria ser nulo", cartao.getNumero());
  }
  
}
