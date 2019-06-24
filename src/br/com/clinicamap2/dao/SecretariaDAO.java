/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.dao;

import br.com.clinicamap2.model.Secretaria;
import br.com.clinicamap2.util.MensagensUtil;
import br.com.clinicamap2.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Luís Henrique
 */
public class SecretariaDAO {
    EntityManager em;
    
    public void inserir(Secretaria secretaria) throws Exception{
        
        try{
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(secretaria);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_SALVAR));
        }finally{
            em.close();
        }
    }
    
    public void atualizar(Secretaria secretaria) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(secretaria);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
        } finally {
            em.close();
        }
    }

    public void remover(Secretaria secretaria) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            secretaria = em.find(Secretaria.class, secretaria.getId());
            em.remove(secretaria);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
        } finally {
            em.close();
        }
    }

    public Secretaria buscarPorId(int id) throws Exception {
        Secretaria secretaria = null;
        try {
            em = PersistenceUtil.createEntityManager();

            secretaria = em.find(Secretaria.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }

        return secretaria;
    }

    public List<Secretaria> listar() throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("select s from Secretaria s");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }

    public List<Secretaria> buscar(String busca) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT s FROM Secretaria s WHERE s.nome LIKE :p");
            query.setParameter("p", busca + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }
}
