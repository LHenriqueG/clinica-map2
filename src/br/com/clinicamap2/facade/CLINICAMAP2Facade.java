/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.facade;

import br.com.clinicamap2.dao.ConsultaDAO;
import br.com.clinicamap2.dao.MedicoDAO;
import br.com.clinicamap2.dao.PacienteDAO;
import br.com.clinicamap2.dao.PessoaDAO;
import br.com.clinicamap2.dao.SecretariaDAO;
import br.com.clinicamap2.model.Consulta;
import br.com.clinicamap2.model.Medico;
import br.com.clinicamap2.model.Paciente;
import br.com.clinicamap2.model.Pessoa;
import br.com.clinicamap2.model.Secretaria;
import java.util.List;

/**
 *
 * @author Luís Henrique
 */
public class CLINICAMAP2Facade {
    
    
    private static CLINICAMAP2Facade instance;
    
    private CLINICAMAP2Facade(){
        
    }
    
    public static CLINICAMAP2Facade getInstance(){
        if(instance == null){
            instance = new CLINICAMAP2Facade();
        }
        return instance;
    }
    
    //Pessoa
    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public void salvarPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.inserir(pessoa);
    }
    
    public void editarPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.atualizar(pessoa);
    }
    
    public void removerPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.remover(pessoa);
    }
    
    public Pessoa buscarPessoa(int id) throws Exception{
        return pessoaDAO.buscarPorId(id);
    }
    
    public List<Pessoa> listarPessoas() throws Exception{
        return pessoaDAO.listar();
    }
    
    public List<Pessoa> buscarPessoas(String busca) throws Exception{
        return pessoaDAO.buscar(busca);
    }
    
    //Médico
    private MedicoDAO medicoDAO = new MedicoDAO();
    
    public void salvarMedico(Medico medico) throws Exception{
        medicoDAO.inserir(medico);
    }
    
    public void editarMedico(Medico medico) throws Exception{
        medicoDAO.atualizar(medico);
    }
    
    public void removerMedico(Medico medico) throws Exception{
        medicoDAO.remover(medico);
    }
    
    public Medico buscarMedico(int id) throws Exception{
        return medicoDAO.buscarPorId(id);
    }
    
    public List<Medico> listarMedicos() throws Exception{
        return medicoDAO.listar();
    }
    
    public List<Medico> buscarMedicos(String busca) throws Exception{
        return medicoDAO.buscar(busca);
    }
    
    //Paciente
    private PacienteDAO pacienteDAO = new PacienteDAO();
    
    public void salvarPaciente(Paciente paciente) throws Exception{
        pacienteDAO.inserir(paciente);
    }
    
    public void editarPaciente(Paciente paciente) throws Exception{
        pacienteDAO.atualizar(paciente);
    }
    
    public void removerPaciente(Paciente paciente) throws Exception{
        pacienteDAO.remover(paciente);
    }
    
    public Paciente buscarPaciente(int id) throws Exception{
        return pacienteDAO.buscarPorId(id);
    }
    
    public List<Paciente> listarPacientes() throws Exception{
        return pacienteDAO.listar();
    }
    
    public List<Paciente> buscarPacientes(String busca) throws Exception{
        return pacienteDAO.buscar(busca);
    }
    
    //Secretária
    private SecretariaDAO secretariaDAO = new SecretariaDAO();
    
    public void salvarSecretaria(Secretaria secretaria) throws Exception{
        secretariaDAO.inserir(secretaria);
    }
    
    public void editarSecretaria(Secretaria secretaria) throws Exception{
        secretariaDAO.atualizar(secretaria);
    }
    
    public void removerSecretaria(Secretaria secretaria) throws Exception{
        secretariaDAO.remover(secretaria);
    }
    
    public Secretaria buscarSecretaria(int id) throws Exception{
        return secretariaDAO.buscarPorId(id);
    }
    
    public List<Secretaria> listarSecretarias() throws Exception{
        return secretariaDAO.listar();
    }
    
    public List<Secretaria> buscarSecretarias(String busca) throws Exception{
        return secretariaDAO.buscar(busca);
    }
    
    //Consulta
    private ConsultaDAO consultaDAO = new ConsultaDAO();
    
    public void salvarConsulta(Consulta consulta) throws Exception{
        consultaDAO.inserir(consulta);
    }
    
    public void editarConsulta(Consulta consulta) throws Exception{
        consultaDAO.atualizar(consulta);
    }
    
    public void removerConsulta(Consulta consulta) throws Exception{
        consultaDAO.remover(consulta);
    }
    
    public Consulta buscarConsulta(int id) throws Exception{
        return consultaDAO.buscarPorId(id);
    }
    
    public List<Consulta> listarConsultas() throws Exception{
        return consultaDAO.listar();
    }
    
    public List<Consulta> buscarConsultas(String busca) throws Exception{
        return consultaDAO.buscar(busca);
    }
}
