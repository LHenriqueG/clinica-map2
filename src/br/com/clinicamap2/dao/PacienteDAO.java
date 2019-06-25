/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.dao;

import br.com.clinicamap2.model.Paciente;
import br.com.clinicamap2.util.MensagensUtil;
import br.com.clinicamap2.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Luís Henrique
 */
public class PacienteDAO {
    
    EntityManager em;

    public void inserir(Paciente paciente) throws Exception {

        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_SALVAR));
        } finally {
            em.close();
        }
    }

    public void atualizar(Paciente paciente) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
        } finally {
            em.close();
        }
    }

    public void remover(Paciente paciente) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            paciente = em.find(Paciente.class, paciente.getId());
            em.remove(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
        } finally {
            em.close();
        }
    }

    public Paciente buscarPorId(int id) throws Exception {
        Paciente paciente = null;
        try {
            em = PersistenceUtil.createEntityManager();
            paciente = em.find(Paciente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }

        return paciente;
    }

    public List<Paciente> listar() throws Exception {

        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("select p from Paciente p");
            return query.getResultList();
        } catch (Exception e) {

            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }

    }

    public List<Paciente> buscar(String busca) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.nome LIKE :p");
            query.setParameter("p", busca + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }
    
    public Paciente buscarPorRg(String rg) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.rg =:p", Paciente.class);
            query.setParameter("p", rg);
            return (Paciente) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }
}
