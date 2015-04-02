
package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ConsumidorMetodo;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */
public class ConsumidorMetodoTesteIntegrado extends TestePersistenciaAbstrato{
    
  @Test
  public void deveriaCriarUmConsumidor() throws Exception {
     
    ConsumidorMetodo consumidor = new ConsumidorMetodo();
    consumidor.setId(getIdRandomico());
    consumidor.setPrimeiroNome("Joao");
    consumidor.setUltimoNome("da silva");
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    
    assertNotNull("O Id não deveria ser nulo", consumidor.getId());
  }
}
