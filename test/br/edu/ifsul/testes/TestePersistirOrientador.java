package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;

import br.edu.ifsul.modelo.Orientador;


import br.edu.ifsul.modelo.Publicacao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirOrientador {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirOrientador() {

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
            Orientador obj = new Orientador();
            obj.setNome("Mario");
            obj.setCpf("32839674");
            obj.setInstituicao("IFSUL");
            obj.setTitulacao("A");
          //  obj.setPublicacoes((List<Publicacao>) em.find(Publicacao.class, 1));
           
            Publicacao p = new Publicacao();
            p.setAluno(em.find(Aluno.class, 1));
            p.setTipo("Livro");
            p.setTitulo("Livro A");
            obj.adicionarPublicacao(p);
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
