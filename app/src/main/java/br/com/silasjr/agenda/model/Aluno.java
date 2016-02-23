package br.com.silasjr.agenda.model;

import android.database.Cursor;

import java.io.Serializable;

/**
 * Created by silas on 17/02/16.
 */
public class Aluno implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String site;

    private String nivelAluno;

    public Aluno() {
    }

    public Aluno(Cursor cursor) {
        this.setId(cursor.getLong(cursor.getColumnIndex("id")));
        this.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        this.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        this.setSite(cursor.getString(cursor.getColumnIndex("site")));
        //this.setNivelAluno(cursor.getDouble(cursor.getColumnIndex("nota")));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return this.id + " - "+this.email;
    }
}
