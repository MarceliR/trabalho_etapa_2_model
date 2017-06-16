package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class TestePersistirCurso {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirCurso() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("trabalho_etapa_2PU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Curso c = new Curso();
            c.setNome("A");
           
           Curso c2 = new Curso();
           c2.setNome("B");
          
            em.getTransaction().begin();
            em.persist(c);
           em.persist(c2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
