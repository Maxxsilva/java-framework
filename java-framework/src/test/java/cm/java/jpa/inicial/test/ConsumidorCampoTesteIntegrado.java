
package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ConsumidorCampo;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class ConsumidorCampoTesteIntegrado  extends TestePersistenciaAbstrato{
  
  
  @Test
  public void deveriaCriarUmConsumidor() throws Exception {
     
    ConsumidorCampo consumidor = new ConsumidorCampo();
    consumidor.setId(getIdRandomico());
    consumidor.setPrimeiroNome("Joao");
    consumidor.setUltimoNome("da silva");
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    
    assertNotNull("O Id não deveria ser nulo", consumidor.getId());
  }
    
}
