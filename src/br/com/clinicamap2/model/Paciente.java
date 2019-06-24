/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.model;

import br.com.clinicamap2.util.DateUtil;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author Luís Henrique
 */
@Entity
public class Paciente extends Pessoa{
    
    private String rg;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    public Paciente() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" + "rg=" + rg + ", dataNascimento=" + DateUtil.dateToString(dataNascimento) + '}';
    }
    
}
