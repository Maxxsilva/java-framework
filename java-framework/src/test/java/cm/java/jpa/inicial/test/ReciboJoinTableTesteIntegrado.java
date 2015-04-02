package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ItemCompraJoinTable;
import cm.java.jpa.entidades.ReciboJoinTable;
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

public class ReciboJoinTableTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmReciboComDoisItens() throws Exception {

    ReciboJoinTable recibo = new ReciboJoinTable();
    ItemCompraJoinTable ic1 = new ItemCompraJoinTable("COCA-COLA", 3.5d, 1);
    ItemCompraJoinTable ic2 = new ItemCompraJoinTable("FANDANGOS", 2d, 2);
    List<ItemCompraJoinTable> itensCompra = new ArrayList<ItemCompraJoinTable>();
    itensCompra.add(ic1);
    itensCompra.add(ic2);
    recibo.setItensCompra(itensCompra);
    tx.begin();
    em.persist(recibo);
    em.persist(ic1);
    em.persist(ic2);
    tx.commit();
    assertNotNull("O id do recibo não deveria ser nulo", recibo.getId());
    assertNotNull("O id do ic1 não deveria ser nulo", ic1.getId());
    assertNotNull("O id do ic2 não deveria ser nulo", ic2.getId());

    Long chaveBuscada = recibo.getId();
    ReciboJoinTable reciboBuscado = em.find(ReciboJoinTable.class, chaveBuscada);
    assertNotNull("ItensCompra não deveria ser nulo", reciboBuscado.getItensCompra());
    assertEquals("Deveriam haver dois items de compra", reciboBuscado.getItensCompra().size(), 2);
  }
}