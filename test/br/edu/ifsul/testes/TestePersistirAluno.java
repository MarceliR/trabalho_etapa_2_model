package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Orientador;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirAluno {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirAluno() {

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
            Aluno obj = new Aluno();
            obj.setMatricula("201013260171");
            obj.setNome("Joao");
            obj.setSexo("M");
            obj.setCpf("1233432342");
            obj.setDataNascimento(Calendar.getInstance());     
         //   obj.setOrientador(em.find(Orientador.class, 1));
            
         Curso c = em.find(Curso.class, "A");
         obj.getCursam().add(c);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
