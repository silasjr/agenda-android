package br.com.silasjr.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.silasjr.agenda.dao.AlunoDAO;
import br.com.silasjr.agenda.helper.FormularioHelper;
import br.com.silasjr.agenda.model.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btnSalvar = (Button) findViewById(R.id.formulario_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioActivity.this, "Botão salvar clicado", Toast.LENGTH_SHORT).show();
                backList();
            }
        });

        Button btnVoltar = (Button) findViewById(R.id.formulario_btn_voltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backList();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");

        helper = new FormularioHelper(this);

        if (aluno != null) {
            helper.preencheFormulario(aluno);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_alunos,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:

                AlunoDAO dao = new AlunoDAO(this);
                Aluno aluno = helper.getAluno();

                if (aluno.getId() != null) {
                    dao.altera(aluno);
                } else {
                    dao.insert(aluno);
                }

                dao.close();
                Toast.makeText(FormularioActivity.this, "Aluno salvo "+aluno.getEmail(), Toast.LENGTH_SHORT).show();
                backList();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void backList() {
        finish();
    }

}