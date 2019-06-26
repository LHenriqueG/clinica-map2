/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.dao;

import br.com.clinicamap2.model.Pessoa;
import br.com.clinicamap2.util.MensagensUtil;
import br.com.clinicamap2.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_SALVAR));
        } finally {
            em.close();
        }
    }

    public void atualizar(Pessoa pessoa) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
        } finally {
            em.close();
        }
    }

    public void remover(Pessoa pessoa) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            pessoa = em.find(Pessoa.class, pessoa.getId());
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
        } finally {
            em.close();
        }
    }

    public Pessoa buscarPorId(int id) throws Exception {
        Pessoa pessoa = null;
        try {
            em = PersistenceUtil.createEntityManager();
            pessoa = em.find(Pessoa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
        return pessoa;
    }

    public List<Pessoa> listar() throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("Select pp From Medico pp");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }

    public List<Pessoa> buscar(String busca) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT pp FROM Pessoa pp WHERE pp.nome LIKE :pp");
            query.setParameter("pp", busca + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        } finally {
            em.close();
        }
    }
}
