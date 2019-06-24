/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.model;

import javax.persistence.Entity;

/**
 *
 * @author Luís Henrique
 */
@Entity
public class Medico extends Pessoa {
    
    private String crm;
    private String especialidade;

    public Medico() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", especialidade=" + especialidade + '}';
    }
}
