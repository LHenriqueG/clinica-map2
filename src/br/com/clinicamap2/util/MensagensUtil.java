/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Luís Henrique
 */
public class MensagensUtil {

    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale EN_US = new Locale("en", "US");
    public static final Locale FR_FR = new Locale("fr", "FR");

    private static ResourceBundle resource = ResourceBundle.getBundle("mensagens", PT_BR);

    public static final String MSG_ERRO_SALVAR = "msg.erro.salvar";
    public static final String MSG_ERRO_EXCLUIR = "msg.erro.excluir";
    public static final String MSG_ERRO_EDITAR = "msg.erro.editar";
    public static final String MSG_ERRO_CONSULTAR = "msg.erro.consultar";
    public static final String MSG_ERRO_OPCAO = "msg.erro.opcao";
    public static final String MSG_SUCESSO_SALVAR = "msg.sucesso.salvar";
    public static final String MSG_SUCESSO_EXCLUIR = "msg.sucesso.excluir";
    public static final String MSG_SUCESSO_EDITAR = "msg.sucesso.editar";
    public static final String MSG_SUCESSO_SAIR = "msg.sucesso.sair";
    public static final String MENU_PRINCIPAL_TITULO = "menu.principal.titulo";
    public static final String MENU_PRINCIPAL_IDIOMA = "menu.principal.idioma";
    public static final String MENU_PRINCIPAL_CADASTRAR = "menu.principal.cadastrar";
    public static final String MENU_PRINCIPAL_EDITAR = "menu.principal.editar";
    public static final String MENU_PRINCIPAL_EXCLUIR = "menu.principal.excluir";
    public static final String MENU_PRINCIPAL_LISTAR = "menu.principal.listar";
    public static final String MENU_PRINCIPAL_CONSULTAR = "menu.principal.consultar";
    public static final String MENU_PRINCIPAL_SAIR = "menu.principal.sair";
    public static final String MSG_CAPTURAR_NOME = "msg.capturar.nome";
    public static final String MSG_CAPTURAR_CPF = "msg.capturar.cpf";
    public static final String MSG_CAPTURAR_RG = "msg.capturar.rg";
    public static final String MSG_CAPTURAR_ENDERECO = "msg.capturar.endereco";
    public static final String MSG_CAPTURAR_NUMERO = "msg.capturar.numero";
    public static final String MSG_CAPTURAR_CRM = "msg.capturar.crm";
    public static final String MSG_CAPTURAR_DATA = "msg.capturar.data";
    public static final String MSG_CAPTURAR_NASCIMENTO = "msg.capturar.nascimento";
    public static final String MSG_CAPTURAR_ID = "msg.capturar.id";
    public static final String MSG_CAPTURAR_ESPECIALIDADE = "msg.capturar.especialidade";
    public static final String MSG_CAPTURAR_BUSCA = "msg.capturar.busca";
    public static final String MSG_CAPTURAR_LOGIN = "msg.capturar.login";
    public static final String MSG_CAPTURAR_SENHA = "msg.capturar.senha";
    public static final String MSG_CAPTURAR_TELEFONE = "msg.capturar.telefone";
    public static final String MSG_CAPTURAR_EMAIL = "msg.capturar.email";
    public static final String MSG_CAPTURAR_DESCRICAO = "msg.capturar.descricao";
    public static final String MSG_CAPTURAR_IDIOMA = "msg.capturar.idioma";
    public static final String MSG_CAPTURAR_INFORMAR = "msg.capturar.informar";
    public static final String MSG_CAPTURAR_ATUALIZAR = "msg.capturar.atualizar";
    public static final String MSG_CAPTURAR_EXCLUIR = "msg.capturar.excluir";
    public static final String MSG_CAPTURAR_EXIBIR = "msg.capturar.exibir";
    public static final String MSG_CAPTURAR_PESQUISAR = "msg.capturar.pesquisar";
    public static final String MSG_LISTA_BR = "msg.lista.br";
    public static final String MSG_LISTA_EN = "msg.lista.us";
    public static final String MSG_LISTA_FR = "msg.lista.fr";
    public static final String MSG_LISTA_MEDICO = "msg.lista.medico";
    public static final String MSG_LISTA_PACIENTE = "msg.lista.paciente";
    public static final String MSG_LISTA_SECRETARIA = "msg.lista.secretaria";
    public static final String MSG_LISTA_CONSULTA = "msg.lista.consulta";
    
    
    

    public static String getString(String chave) {
        return resource.getString(chave);
    }

    public static void setLocale(Locale locale) {
        resource = ResourceBundle.getBundle("mensagens", locale);
    }
}
