/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinicamap2.model;

import br.com.clinicamap2.util.DateUtil;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Luís Henrique
 */
@Entity
public class Secretaria extends Pessoa {
    
    private Date dataNascimento;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Secretaria{" + "dataNascimento=" + DateUtil.dateToString(dataNascimento) + '}';
    }
    
}
