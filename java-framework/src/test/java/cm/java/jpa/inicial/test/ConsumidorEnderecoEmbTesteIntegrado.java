
package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ConsumidorEmb;
import cm.java.jpa.entidades.EnderecoEmb;
import cm.java.jpa.entidades.LivroColecao;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */
public class ConsumidorEnderecoEmbTesteIntegrado extends TestePersistenciaAbstrato{
    
   @Test
  public void deveriaCriarUmConsumidorComEndereco() throws Exception { 
      
    ConsumidorEmb consumidor = new ConsumidorEmb(); 
    consumidor.setId(getIdRandomico());
    consumidor.setPrimeiroNome("SUNDA");
    consumidor.setUltimoNome("SAURO");
    consumidor.setEmail("sunda@locha.com");
    EnderecoEmb endereco = new EnderecoEmb();
    endereco.setEndereco1("RUA DAS FLORES");
    endereco.setCidade("CIDADE1");
    endereco.setEstado("RJ");
    consumidor.setEndereco(endereco);
        
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    assertNotNull("Ultimo nome não pode ser nulo", consumidor.getUltimoNome());  
    assertNotNull("O Id não deveria ser nulo", consumidor.getId());
  }
    
}
