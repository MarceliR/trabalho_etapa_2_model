/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;

import br.edu.ifsul.modelo.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marcely
 */
public class TestePersistirCursam {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCursam() {
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
    public void teste() {
        boolean exception = false;
        try {

            Curso p = em.find(Curso.class, 1);
            Aluno u = em.find(Aluno.class, 1);
            p.getCursam().add(u);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();

        }
        //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }
}
