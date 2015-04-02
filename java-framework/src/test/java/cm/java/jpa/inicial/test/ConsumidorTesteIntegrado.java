
package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.Consumidor;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import java.util.Calendar;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */
public class ConsumidorTesteIntegrado extends TestePersistenciaAbstrato{
  // ======================================
  // =              Testes Unitarios            =
  // ======================================

  @Test
  public void deveriaCriarUmConsumidor() throws Exception {
     
    Consumidor consumidor = new Consumidor();
    consumidor.setId(getIdRandomico());
    consumidor.setPrimeiroNome("Joao");
    Calendar datanasc = Calendar.getInstance();
    datanasc.set(1980, 01, 01);
    consumidor.setDataNascimento(datanasc.getTime());
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    
    assertNotNull("O Id não deveria ser nulo", consumidor.getId());

    assertEquals("Calculando idade ano atual 2016 - 1980", 35, consumidor.getIdade());
  }
}
