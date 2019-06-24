/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.dao;

import br.com.clinicamap2.model.Consulta;
import br.com.clinicamap2.util.MensagensUtil;
import br.com.clinicamap2.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Luís Henrique
 */
public class ConsultaDAO {
    EntityManager em;

    public void inserir(Consulta consulta) throws Exception {

        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_SALVAR));
        } finally {
            em.close();
        }
    }

    public void atualizar(Consulta consulta) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
        } finally {
            em.close();
        }
    }

    public void remover(Consulta consulta) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            consulta = em.find(Consulta.class, consulta.getId());
            em.remove(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
        } finally {
            em.close();
        }
    }

    public Consulta buscarPorId(int id) throws Exception {
        Consulta consulta = null;
        try {
            em = PersistenceUtil.createEntityManager();
            consulta = em.find(Consulta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }

        return consulta;
    }

    public List<Consulta> listar() throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("select c from Consulta c");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }

    public List<Consulta> buscar(String busca) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT c FROM Consulta c WHERE c.nome LIKE :c");
            query.setParameter("c", busca + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }
}
