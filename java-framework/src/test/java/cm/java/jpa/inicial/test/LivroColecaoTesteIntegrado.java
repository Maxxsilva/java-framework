
package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.LivroColecao;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class LivroColecaoTesteIntegrado extends TestePersistenciaAbstrato{
   
  @Test
  public void deveriaCriarUmLivroColecao() throws Exception {
     
    LivroColecao livro = new LivroColecao();

    livro.setId(getIdRandomico());
    livro.setTitulo("BIBLIA");
    livro.setPreco(75.0f);
    tx.begin();
    em.persist(livro);
    tx.commit();
    
    assertNotNull("O Id não deveria ser nulo", livro.getId());
  }
}
