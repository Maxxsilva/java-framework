package cm.java.jpa.inicial.test;


import cm.java.jpa.entidades.ConsumidorUmParaUmUni;
import cm.java.jpa.entidades.EnderecoEnt;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class ConsumidorUmParaUmUniTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmConsumidorComUmEndereco() throws Exception {

    ConsumidorUmParaUmUni consumidor = new ConsumidorUmParaUmUni("Joao", "da Silva", "sunda@gmail.com", "3434");
    EnderecoEnt endereco = new EnderecoEnt("Rua A", "Bairro B", "RIO", "RJ", "21200-000", "BR");
    consumidor.setEndereco(endereco);
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();
    assertNotNull("O ID não deveria ser nulo...", consumidor.getId());

    consumidor = em.find(ConsumidorUmParaUmUni.class, consumidor.getId());
    assertNotNull("O endereco do consumidor não deveria ser nulo", consumidor.getEndereco());
  }
}