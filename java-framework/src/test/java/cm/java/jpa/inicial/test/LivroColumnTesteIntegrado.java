package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.LivroColumn;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class LivroColumnTesteIntegrado extends TestePersistenciaAbstrato {

    // ======================================
    // =           Testes Unitários         =
    // ======================================
    @Test
    public void shouldCreateABook() throws Exception {

        LivroColumn livro = new LivroColumn("O Santo Graal", 12.5F, "nononononono", "1-65650-742-2", 155, false);
        tx.begin();
        em.persist(livro);
        tx.commit();
        assertNotNull("O ID não deveria ser nulo", livro.getId());
    }

    @Test
    //@Ignore("updatable = false não funciona")
    public void titleShouldNotBeUpdatable() throws Exception {

        LivroColumn livro = new LivroColumn("O Santo Graal", 12.5F, "nononononono", "1-65650-742-2", 155, false);
        tx.begin();
        em.persist(livro);
        tx.commit();
        assertNotNull("o ID não deveria ser nulo", livro.getId());
        assertEquals("O titulo deveria ser O Santro Graal", "O Santo Graal", livro.getTitulo());

       
    }
}
