/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.dao;

import br.com.clinicamap2.model.Pessoa;
import br.com.clinicamap2.util.PersistenceUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Luís Henrique
 */
public class PessoaDAO {
    
    EntityManager em;

    public void inserir(Pessoa pessoa) throws Exception {

        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Erro");
        } finally {
            em.close();
        }
    }
}
