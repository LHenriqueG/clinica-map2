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
    public static final String MSG_SUCESSO_SALVAR = "msg.sucesso.salvar";
    public static final String MSG_SUCESSO_EXCLUIR = "msg.sucesso.excluir";
    public static final String MENU_PRINCIPAL_TITULO = "menu.principal.titulo";
    public static final String MENU_PRINCIPAL_IDIOMA = "menu.principal.idioma";
    public static final String MENU_PRINCIPAL_CADASTRAR = "menu.principal.cadastrar";
    public static final String MENU_PRINCIPAL_EDITAR = "menu.principal.editar";
    public static final String MENU_PRINCIPAL_EXCLUIR = "menu.principal.excluir";
    public static final String MENU_PRINCIPAL_LISTAR = "menu.principal.listar";
    public static final String MENU_PRINCIPAL_CONSULTAR = "menu.principal.consultar";
    public static final String MENU_PRINCIPAL_SAIR = "menu.principal.sair";
    public static final String MSG_SUCESSO_EDITAR = "msg.sucesso.editar";
    public static final String MSG_ERRO_OPCAO = "msg.erro.opcao";

    public static String getString(String chave) {
        return resource.getString(chave);
    }

    public static void setLocale(Locale locale) {
        resource = ResourceBundle.getBundle("mensagens", locale);
    }
}
