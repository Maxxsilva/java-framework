package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ComentarioIndexado;
import cm.java.jpa.entidades.NoticiaIndexado;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class NoticiaIndexadoTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================
  @Test
  //@Ignore("@OrderColumn parece não funcionar")
  public void deveriacriarNoticiasComComentarios() throws Exception {

    NoticiaIndexado noticia = new NoticiaIndexado("Os evangelhos da Biblia");
    noticia.adicionaComentario(new ComentarioIndexado("lucas", "Terceiro livro", 1));
    noticia.adicionaComentario(new ComentarioIndexado("mateus", "Primeiro livro", 3));
    noticia.adicionaComentario(new ComentarioIndexado("marcos", "Segundo livro", 5));
    noticia.adicionaComentario(new ComentarioIndexado("joao", "Quarto livro", 2));

    tx.begin();
    em.persist(noticia);
    tx.commit();
    
          
    
    Long idNoticiaQueQueroEncontrar = noticia.getId();

    tx.begin();
    NoticiaIndexado noticiaProcurada = em.find(NoticiaIndexado.class, idNoticiaQueQueroEncontrar);

    // Sem a chamada do metodo refresh, o teste não irá funcionar
    // A anotação OrderColumn especifica a ordenação dos elementos de uma coleção
    // A chave aqui é a frase "quando a associação é recuperada".  
    // Nessa caso, quando o método find for executado, a associação ainda estará gerenciado e nenhuma recuperação lógica é feita.
    em.refresh(noticiaProcurada);

    tx.commit();
    
  
    assertEquals("Os evangelhos da Biblia", noticiaProcurada.getConteudo());
    assertEquals(4, noticiaProcurada.getComentarios().size());
    assertEquals("Quarto livro", noticiaProcurada.getComentarios().get(0).getConteudo());
    assertEquals("Terceiro livro", noticiaProcurada.getComentarios().get(1).getConteudo());
    assertEquals("Segundo livro", noticiaProcurada.getComentarios().get(2).getConteudo());
    assertEquals("Primeiro livro", noticiaProcurada.getComentarios().get(3).getConteudo());
  }
}