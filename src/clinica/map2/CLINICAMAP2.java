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
        Contato contato = null;
        Usuario usuario = null;
        Medico medico = null;
        Paciente paciente = null;
        Secretaria secretaria = null;
        Consulta consulta = null;
        CLINICAMAP2Facade facade = CLINICAMAP2Facade.getInstance();

        // menu
        String op = "";
        int id;

        do {
            //Exibe o MENU PRINCIPAL
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
                    //Lista as opções de idiomas possíveis
                    System.out.println(MensagensUtil.getString((MensagensUtil.MSG_LISTA_BR)));
                    System.out.println(MensagensUtil.getString((MensagensUtil.MSG_LISTA_EN)));
                    System.out.println(MensagensUtil.getString((MensagensUtil.MSG_LISTA_FR)));
                    //Captura o idioma desejado
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_IDIOMA));
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
                    //Exibi a lista de opções para realização dos cadastros
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_MEDICO));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_PACIENTE));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_SECRETARIA));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_CONSULTA));
                    

                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_INFORMAR));
                    op = input.nextLine();
                    medico = new Medico();
                    if (op.endsWith("1")) {
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_NOME));
                        medico.setNome(input.nextLine()); // ler uma linha e guarda em nome
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_CPF));
                        medico.setCpf(input.nextLine()); // ler uma linha e guarda em cpf
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_CRM));
                        medico.setCrm(input.nextLine()); // ler uma linha e guarda em crm
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ESPECIALIDADE));
                        medico.setEspecialidade(input.nextLine()); // ler uma linha e guarda em especialidade
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarMedico(medico);
                        break;

                    } else if (op.endsWith("2")) {
                        paciente = new Paciente();
                        e = new Endereco();
                        contato = new Contato();
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_NOME));
                        paciente.setNome(input.nextLine()); // ler uma linha e guarda em nome
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_CPF));
                        paciente.setCpf(input.nextLine()); // ler uma linha e guarda em cpf
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_RG));
                        paciente.setRg(input.nextLine()); // ler uma linha e guarda em rg
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_NASCIMENTO));
                        paciente.setDataNascimento(DateUtil.stringToDate(input.nextLine())); // ler uma linha e guarda em data
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ENDERECO));
                        e.setLogradouro(input.nextLine()); // ler uma linha e guarda em endereço
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_NUMERO));
                        e.setNumero(input.nextLine()); // ler uma linha e guarda em número
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_EMAIL));
                        contato.setEmail(input.nextLine()); // ler uma linha e guarda em email
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_TELEFONE));
                        contato.setTelefone(input.nextLine()); // ler uma linha e guarda em telefone
                        paciente.setEndereco(e); //seta o endereço para paciente
                        paciente.setContato(contato); // seta o contato para paciente
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarPaciente(paciente); // salvar o paciente, através da fachada para acessar o DAO
                        break;
                    } else if (op.endsWith("3")) {
                        secretaria = new Secretaria();
                        usuario = new Usuario();
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_NOME));
                        secretaria.setNome(input.nextLine());
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_CPF));
                        secretaria.setCpf(input.nextLine());
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_NASCIMENTO));
                        secretaria.setDataNascimento(DateUtil.stringToDate(input.nextLine()));
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_LOGIN));
                        usuario.setLogin(input.nextLine());
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_SENHA));
                        usuario.setSenha(input.nextLine());
                        secretaria.setUsuario(usuario);
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));
                        facade.salvarSecretaria(secretaria);
                        break;
                    } else {
                        consulta = new Consulta();
                        paciente = new Paciente();
                        medico = new Medico();

                        for (Medico m : facade.listarMedicos()) {
                            System.out.println(m);

                        }

                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_CRM));
                        String crm = input.nextLine();

                        for (Paciente p : facade.listarPacientes()) {
                            System.out.println(p);

                        }

                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_RG));
                        String rg = input.nextLine();

                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_DESCRICAO));
                        consulta.setDescricao(input.nextLine());
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_DATA));
                        consulta.setDataConsulta(DateUtil.stringToDate(input.nextLine()));
                        medico.setCrm(crm);
                        paciente.setRg(rg);
                        consulta.setMedico(medico);
                        consulta.setPaciente(paciente);
                        
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SALVAR));

                        facade.salvarConsulta(consulta);
                    }
                    break;
                case "3":
                    System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));

                    
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_MEDICO));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_PACIENTE));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_SECRETARIA));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_CONSULTA));

                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ATUALIZAR));
                    op = input.nextLine();
                    if (op.endsWith("1")) {

                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
                        id = Integer.parseInt(input.nextLine());

                        paciente = facade.buscarPaciente(id);
                        if (paciente != null) {

                            System.out.println("Novo Endereço: (" + paciente.getNome() + ")");
                            paciente.setNome(input.nextLine());

                            facade.editarPaciente(paciente);
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_EDITAR));
                        } else {
                            System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
                        }
                        break;
                    } else if (op.endsWith("3")) {
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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

                    
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_MEDICO));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_PACIENTE));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_SECRETARIA));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_CONSULTA));

                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_EXCLUIR));
                    op = input.nextLine();
                    if (op.endsWith("1")) {

                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_ID));
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

                    
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_MEDICO));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_PACIENTE));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_SECRETARIA));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_CONSULTA));

                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_EXIBIR));
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

                    
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_MEDICO));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_PACIENTE));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_SECRETARIA));
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_LISTA_CONSULTA));

                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_PESQUISAR));
                    op = input.nextLine();
                    if (op.endsWith("1")) {
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_BUSCA));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_BUSCA));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_BUSCA));
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
                        System.out.println(MensagensUtil.getString(MensagensUtil.MSG_CAPTURAR_BUSCA));
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
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_SUCESSO_SAIR));
                    System.exit(0);
                    break;
                default:
                    System.out.println(MensagensUtil.getString(MensagensUtil.MSG_ERRO_OPCAO));

            }

        } while (!op.equals("6"));

    } // fim do método main

}
