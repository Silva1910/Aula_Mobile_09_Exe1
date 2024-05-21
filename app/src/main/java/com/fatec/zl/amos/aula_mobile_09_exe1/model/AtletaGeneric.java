package com.fatec.zl.amos.aula_mobile_09_exe1.model;

import java.time.LocalDate;
import java.util.Date;

public abstract class AtletaGeneric {

    private String nome;
    private String bairro;
    private Date dataNasc;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
