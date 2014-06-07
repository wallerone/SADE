package com.sade.teste;

import com.sade.model.Atividade;
import com.sade.model.Resolucao;
import java.awt.geom.Area;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eurismar Pires Borges
 */
public class TesteJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SADEPU");
        EntityManager em = emf.createEntityManager();
        
        Resolucao resolucao = new Resolucao();
        resolucao.setCodigo_Resolucao("codigo 1");
        
        Calendar c = Calendar.getInstance();
        c.set(2014, 6, 07);
        
        resolucao.setPeriodo_Inicial(c);
        resolucao.setPeriodo_Final(c);
        
        Atividade a1 = new Atividade();
        a1.setNome("Atividade 1");
        a1.setPontuacao(10.0);
        a1.setResolucao(resolucao);
        
        em.getTransaction().begin();
        em.persist(resolucao);
        em.persist(a1);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
