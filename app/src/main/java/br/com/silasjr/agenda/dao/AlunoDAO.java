package br.com.silasjr.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.silasjr.agenda.model.Aluno;

/**
 * Created by silas on 23/02/16.
 */
public class AlunoDAO extends SQLiteOpenHelper {


    /**
     * @param context - para manipular arquivo
     * @param name - nome do banco de dados
     * @param factory - configurar especificacoes do SQLite
     * @param version - versao do banco de dados
     */
    public AlunoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, email TEXT, telefone TEXT, site TEXT, nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Aluno aluno) {
        String sql = "INSERT INTO Alunos(nome, email, telefone, site, nota) VALUES(";
        SQLiteDatabase database = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("email", aluno.getEmail());
        dados.put("telefone", aluno.getTelefone());
        dados.put("nota", aluno.getNivelAluno());

        // null -> para linhas em branco
        database.insert("Alunos", null, dados);
    }


    public List<Aluno> buscaAlunos() {

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Alunos";
        Cursor cursor = db.rawQuery(sql, null);

        List<Aluno> alunos = new ArrayList<>();

        while(cursor.moveToNext()) {
            alunos.add(new Aluno(cursor));
        }
        cursor.close();

        return alunos;
    }

    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete("Alunos", "id = ?", new String[]{aluno.getId().toString()});
    }
}
