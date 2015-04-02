package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.Livro;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class LivroTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
    // =           Teste Unitario           =
    // ======================================


    @Test
    public void deveriaCriarUmLivro() throws Exception {

        Livro livro = new Livro(getIdRandomico(), "O Santo Graal", 12.5F, "nononononono", "1-65650-742-2", 155, false);
        tx.begin();
        em.persist(livro);
        tx.commit();
        assertNotNull("O ID não deveria ser nulo", livro.getId());
    }
}
