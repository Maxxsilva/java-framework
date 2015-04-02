package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ItemCompraJoinColumn;
import cm.java.jpa.entidades.ReciboJoinColumn;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class ReciboJoinColumnTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================
  @Test
  public void deveriaCriarUmReciboComDoisItens() throws Exception {

    ReciboJoinColumn recibo = new ReciboJoinColumn();
    ItemCompraJoinColumn ic1 = new ItemCompraJoinColumn("COCA-COLA", 3.5d, 1);
    ItemCompraJoinColumn ic2 = new ItemCompraJoinColumn("FANDANGOS", 2d, 2);
    List<ItemCompraJoinColumn> itensComprados = new ArrayList<ItemCompraJoinColumn>();
    itensComprados.add(ic1);
    itensComprados.add(ic2);
    recibo.setItensCompra(itensComprados);
    tx.begin();
    em.persist(recibo);
    em.persist(ic1);
    em.persist(ic2);
    tx.commit();
    assertNotNull("O id do recibo não deveria ser nulo", recibo.getId());
    assertNotNull("O id ic1 não deveria ser nulo", ic1.getId());
    assertNotNull("O id ic2 não deveria ser nulo", ic2.getId());

    Long chaveProcurada = recibo.getId();
    ReciboJoinColumn reciboBuscado = em.find(ReciboJoinColumn.class, chaveProcurada);
    assertNotNull("O ItensCompra não deveria ser nulo", reciboBuscado.getItensCompra());
    assertEquals("Deveriam haver dois ItemCompra", reciboBuscado.getItensCompra().size(), 2);
  }
}