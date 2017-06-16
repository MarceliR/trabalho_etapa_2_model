/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Publicacao;
import br.edu.ifsul.modelo.Orientador;
import br.edu.ifsul.modelo.Aluno;
import java.util.Calendar;

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
 * @author Marcely
 */
public class TestePersistirPublicacao {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirPublicacao() {
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
            Publicacao s = new Publicacao();
            s.setTipo("A");
            s.setTitulo("A");
            s.setDataPublicacao(Calendar.getInstance());
            s.setOrientador(em.find(Orientador.class, 1));
            s.setAluno(em.find(Aluno.class, 1));
           
       
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();

        }
        //verifica se o atributo exception ainda é falso para passar no teste
        Assert.assertEquals(false, exception);
    }

}
