package br.com.silasjr.agenda.model;

import java.io.Serializable;

/**
 * Created by silas on 17/02/16.
 */
public class Aluno implements Serializable {

    private String email;

    private String telefone;

    private String site;

    private String nivelAluno;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNivelAluno() {
        return nivelAluno;
    }

    public void setNivelAluno(String nivelAluno) {
        this.nivelAluno = nivelAluno;
    }
}
