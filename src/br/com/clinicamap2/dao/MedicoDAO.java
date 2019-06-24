/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.dao;

import br.com.clinicamap2.model.Medico;
import br.com.clinicamap2.util.MensagensUtil;
import br.com.clinicamap2.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Luís Henrique
 */
public class MedicoDAO {
    
    EntityManager em;

    public void inserir(Medico medico) throws Exception {

        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_SALVAR));
        } finally {
            em.close();
        }
    }

    public void atualizar(Medico medico) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(medico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
        } finally {
            em.close();
        }
    }

    public void remover(Medico medico) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            medico = em.find(Medico.class, medico.getId());
            em.remove(medico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
        } finally {
            em.close();
        }
    }

    public Medico buscarPorId(int id) throws Exception {
        Medico medico = null;
        try {
            em = PersistenceUtil.createEntityManager();
            medico = em.find(Medico.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
        return medico;
    }

    public List<Medico> listar() throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("Select m From Medico m");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }

    public List<Medico> buscar(String busca) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT m FROM Medico m WHERE m.nome LIKE :m");
            query.setParameter("m", busca + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }
    
}
