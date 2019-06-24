/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.map2;

import br.com.clinicamap2.facade.CLINICAMAP2Facade;
import br.com.clinicamap2.model.Consulta;
import br.com.clinicamap2.model.Contato;
import br.com.clinicamap2.model.Endereco;
import br.com.clinicamap2.model.Medico;
import br.com.clinicamap2.model.Paciente;
import br.com.clinicamap2.model.Secretaria;
import br.com.clinicamap2.model.Usuario;
import br.com.clinicamap2.util.DateUtil;
import br.com.clinicamap2.util.MensagensUtil;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luís Henrique
 */
public class CLINICAMAP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Endereco e = null;
        Contato contato = new Contato();
        Usuario usuario = new Usuario();
        Medico medico = null;
        Paciente paciente = null;
        Secretaria secretaria = null;
        Consulta consulta = null;
        CLINICAMAP2Facade facade = new CLINICAMAP2Facade();

        // menu
        String op = "";
        int id;

        do {
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_IDIOMA));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_CADASTRAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_EDITAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_EXCLUIR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_LISTAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_CONSULTAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_SAIR));

            op = input.nextLine();
            switch (op) {
                case "1":
                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));

                    System.out.println("1 - pt-BR");
                    System.out.println("2 - en-US");
                    System.out.println("3 - fr-FR");

                    System.out.println("Informe o idioma: ");
                    op = input.nextLine();

                    if (op.endsWith("1")) {
                        MensagensUtil.setLocale(MensagensUtil.PT_BR);
                    } else if (op.endsWith("2")) {
                        MensagensUtil.setLocale(MensagensUtil.EN_US);
                    } else {
                        MensagensUtil.setLocale(MensagensUtil.FR_FR);
                    }
                    break;

                case "2":

                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));
                    System.out.println("1 - MÉDICO");
                    System.out.println("2 - PACIENTE");
                    System.out.println("3 - SECRETÁRIA");
                    System.out.println("4 - CONSULTA");

                    System.out.println("Informe quem você deseja cadastrar: ");
                    op = input.nextLine();
                    medico = new Medico();
                    if (op.endsWith("1")) {
                        System.out.println("Nome: ");
                        medico.setNome(input.nextLine()); // ler uma linha e guarda em nome
                        System.out.println("CPF: ");
                        medico.setCpf(input.nextLine());
                        System.out.println("CRM: ");
                        medico.setCrm(input.nextLine());
                        System.out.println("Especialidade: ");
                        medico.setEspecialidade(input.nextLine());
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarMedico(medico);
                        break;

                    } else if (op.endsWith("2")) {
                        paciente = new Paciente();
                        System.out.println("Nome: ");
                        paciente.setNome(input.nextLine());
                        System.out.println("CPF: ");
                        paciente.setCpf(input.nextLine());
                        System.out.println("RG: ");
                        paciente.setRg(input.nextLine());
                        System.out.println("Data de Nascimento:");
                        paciente.setDataNascimento(DateUtil.stringToDate(input.nextLine()));
                        System.out.println("Logradouro: ");
                        e.setLogradouro(input.nextLine());
                        System.out.println("Número: ");
                        e.setNumero(input.nextLine());
                        paciente.setEndereco(e);
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarPaciente(paciente);
                        break;
                    } else if (op.endsWith("3")) {
                        secretaria = new Secretaria();
                        usuario = new Usuario();
                        System.out.println("Nome: ");
                        secretaria.setNome(input.nextLine());
                        System.out.println("CPF: ");
                        secretaria.setCpf(input.nextLine());
                        System.out.println("Data de Nascimento:");
                        secretaria.setDataNascimento(DateUtil.stringToDate(input.nextLine()));
                        System.out.println("Login: ");
                        usuario.setLogin(input.nextLine());
                        System.out.println("Senha: ");
                        usuario.setSenha(input.nextLine());
                        secretaria.setUsuario(usuario);
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarSecretaria(secretaria);
                        break;
                    } else {
                        consulta = new Consulta();
                        paciente = new Paciente();
                        medico = new Medico();
                        System.out.println("Nome Paciente: ");
                        paciente.setNome(input.nextLine());
                        System.out.println("Nome Médico: ");
                        medico.setNome(input.nextLine());
                        System.out.println("Descrição: ");
                        consulta.setDescricao(input.nextLine());
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarConsulta(consulta);
                    }
                    break;
                case "3":
                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));

                    System.out.println("1 - MÉDICO");
                    System.out.println("2 - PACIENTE");
                    System.out.println("3 - SECRETÁRIA");
                    System.out.println("4 - CONSULTA");

                    System.out.println("Informe de qual lista deseja atualizar: ");
                    op = input.nextLine();
                    if (op.endsWith("1")) {

                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        medico = facade.buscarMedico(id);
                        if (medico != null) {

                            System.out.println("Novo Nome: (" + medico.getNome() + ")");
                            medico.setNome(input.nextLine());
                            System.out.println("Nova Especialidade: (" + medico.getEspecialidade() + ")");
                            medico.setEspecialidade(input.nextLine());

                            facade.editarMedico(medico);

                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EDITAR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
                        }
                        break;
                    } else if (op.endsWith("2")) {
                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        paciente = facade.buscarPaciente(id);
                        if (paciente != null) {

                            System.out.println("Novo Endereço: (" + paciente.getNome()+ ")");
                            paciente.setNome(input.nextLine());
                            

                            facade.editarPaciente(paciente);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EDITAR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
                        }
                        break;
                    } else if (op.endsWith("3")) {
                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        secretaria = facade.buscarSecretaria(id);
                        if (secretaria != null) {

                            System.out.println("Novo Nome: (" + secretaria.getNome() + ")");
                            secretaria.setNome(input.nextLine());
                            System.out.println("Novo CPF: (" + secretaria.getCpf() + ")");
                            secretaria.setCpf(input.nextLine());

                            facade.editarSecretaria(secretaria);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EDITAR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
                        }
                        break;
                    } else {
                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        consulta = facade.buscarConsulta(id);
                        if (consulta != null) {

                            System.out.println("Novo Nome: (" + consulta.getDescricao() + ")");
                            consulta.setDescricao(input.nextLine());

                            facade.editarConsulta(consulta);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EDITAR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
                        }
                        break;
                    }

                case "4":
                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));

                    System.out.println("1 - MÉDICO");
                    System.out.println("2 - PACIENTE");
                    System.out.println("3 - SECRETÁRIA");
                    System.out.println("4 - CONSULTA");

                    System.out.println("Informe de qual lista você deseja excluir: ");
                    op = input.nextLine();
                    if (op.endsWith("1")) {

                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        medico = facade.buscarMedico(id);
                        if (medico != null) {
                            facade.removerMedico(medico);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EXCLUIR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
                        }
                        break;
                    } else if (op.endsWith("2")) {
                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        paciente = facade.buscarPaciente(id);
                        if (paciente != null) {
                            facade.removerPaciente(paciente);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EXCLUIR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
                        }
                        break;
                    } else if (op.endsWith("3")) {
                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        secretaria = facade.buscarSecretaria(id);
                        if (secretaria != null) {
                            facade.removerSecretaria(secretaria);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EXCLUIR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
                        }
                        break;
                    } else {
                        System.out.println("Informe o ID: ");
                        id = Integer.parseInt(input.nextLine());

                        consulta = facade.buscarConsulta(id);
                        if (consulta != null) {
                            facade.removerConsulta(consulta);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EXCLUIR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
                        }
                        break;
                    }

                case "5":
                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));

                    System.out.println("1 - MÉDICO");
                    System.out.println("2 - PACIENTE");
                    System.out.println("3 - SECRETÁRIA");
                    System.out.println("4 - CONSULTA");

                    System.out.println("Informe qual a lista deseja exibir: ");
                    op = input.nextLine();
                    if (op.endsWith("1")) {
                        for (Medico m : facade.listarMedicos()) {
                            System.out.println(m);
                        }
                        break;
                    } else if (op.endsWith("2")) {
                        for (Paciente p : facade.listarPacientes()) {
                            System.out.println(p);
                        }
                        break;
                    } else if (op.endsWith("3")) {
                        for (Secretaria s : facade.listarSecretarias()) {
                            System.out.println(s);
                        }
                        break;
                    } else {
                        for (Consulta c : facade.listarConsultas()) {
                            System.out.println(c);
                        }
                        break;
                    }

                case "6":
                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));

                    System.out.println("1 - MÉDICO");
                    System.out.println("2 - PACIENTE");
                    System.out.println("3 - SECRETÁRIA");
                    System.out.println("4 - CONSULTA");

                    System.out.println("Informe de que lista você deseja buscar: ");
                    op = input.nextLine();
                    if (op.endsWith("1")) {
                        System.out.println("Busca: ");
                        String busca = input.nextLine();

                        List<Medico> lista = facade.buscarMedicos(busca);

                        if (!lista.isEmpty()) {
                            for (Medico m : lista) {
                                System.out.println(m);
                            }
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
                        }
                        break;
                    } else if (op.endsWith("2")) {
                        System.out.println("Busca: ");
                        String busca = input.nextLine();

                        List<Paciente> lista = facade.buscarPacientes(busca);

                        if (!lista.isEmpty()) {
                            for (Paciente p : lista) {
                                System.out.println(p);
                            }
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
                        }
                        break;
                    } else if (op.endsWith("3")) {
                        System.out.println("Busca: ");
                        String busca = input.nextLine();

                        List<Secretaria> lista = facade.buscarSecretarias(busca);

                        if (!lista.isEmpty()) {
                            for (Secretaria s : lista) {
                                System.out.println(s);
                            }
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
                        }
                        break;
                    } else {
                        System.out.println("Busca: ");
                        String busca = input.nextLine();

                        List<Consulta> lista = facade.buscarConsultas(busca);

                        if (!lista.isEmpty()) {
                            for (Consulta c : lista) {
                                System.out.println(c);
                            }
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
                        }
                        break;
                    }

                case "7":
                    System.out.println("Saindo....");
                    System.exit(0);
                    break;
                default:
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_OPCAO));

            }

        } while (!op.equals("6"));

    } // fim do método main
        
    }
    

