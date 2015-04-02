
package cm.java.jpa.inicial.test;
import cm.java.jpa.entidades.Pessoa;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import javax.validation.ConstraintViolationException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class PessoaTesteIntegrado extends TestePersistenciaAbstrato{

  // ======================================
  // =           Testes Unitarios         =
  // ======================================
    
    @Test
    public void deveriaEncontrarPessoaMaria() throws Exception {
        Pessoa pessoa = em.find(Pessoa.class, 1001L);
        assertEquals("Maria", pessoa.getPrimeiroNome());
    }

    @Test
    public void deveriaCriarPessoaJose() throws Exception {
        Pessoa pessoa = new Pessoa("222222","Joao", "Silva");
        tx.begin();
        em.persist(pessoa);
        tx.commit();

        assertNotNull("A ID não deveria ser nula", pessoa.getId());

        pessoa = em.createNamedQuery("encontrePessoaJoao", Pessoa.class).getSingleResult();
        assertEquals("Joao Silva", pessoa.getPrimeiroNome() + " " + pessoa.getUltimoNome());
    }  
    

    @Test(expected = ConstraintViolationException.class)
    public void deveriaDarExcecaoViolacaoConstraint() {
        Pessoa pessoa = new Pessoa(null,"Sem Primeiro Nome ", "ultimo nome nulo");
        em.persist(pessoa);
    }
    
  
   
    
   
}
