package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ComentarioOrdenado;
import cm.java.jpa.entidades.NoticiaOrdenado;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mauro Silva
 * @version 1.0
 */

public class NoticiaOrdenadoTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================
  @Test
  public void deveriacriarNoticiasComComentarios() throws Exception {

    NoticiaOrdenado noticia = new NoticiaOrdenado("Os evangelhos da Biblia");
    noticia.adicionaComentario(new ComentarioOrdenado("lucas", "Terceiro livro", 1, "03-07-2009"));
    noticia.adicionaComentario(new ComentarioOrdenado("mateus", "Primeiro livro", 3, "01-07-2009"));
    noticia.adicionaComentario(new ComentarioOrdenado("marcos", "Segundo livro", 5, "02-07-2009"));
    noticia.adicionaComentario(new ComentarioOrdenado("joao", "Quarto livro", 2, "06-07-2009"));

    tx.begin();
    em.persist(noticia);
    tx.commit();
    
    Long idNoticiaQueQueroEncontrar = noticia.getId();

    tx.begin();
    NoticiaOrdenado noticiaProcurada = em.find(NoticiaOrdenado.class, idNoticiaQueQueroEncontrar);

    // Sem a chamada do metodo refresh, o teste não irá funcionar
    // A anotação OrderBy especifica a ordenação dos elementos de uma coleção
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