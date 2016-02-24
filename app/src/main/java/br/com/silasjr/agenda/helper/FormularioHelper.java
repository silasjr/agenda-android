package br.com.silasjr.agenda.helper;

import android.widget.EditText;

import br.com.silasjr.agenda.FormularioActivity;
import br.com.silasjr.agenda.R;
import br.com.silasjr.agenda.model.Aluno;

/**
 * Created by silas on 18/02/16.
 */
public class FormularioHelper {

    private EditText txSite;
    private EditText txNome;
    private EditText txEmail;
    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        txNome = (EditText) activity.findViewById(R.id.formulario_nome);
        txEmail = (EditText) activity.findViewById(R.id.formulario_email);
        txSite = (EditText) activity.findViewById(R.id.formulario_site);
        this.aluno = new Aluno();
    }

    public Aluno getAluno() {
        aluno.setNome(txNome.getText().toString());
        aluno.setEmail(txEmail.getText().toString());
        aluno.setSite(txSite.getText().toString());
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        this.aluno = aluno;
        this.txNome.setText(aluno.getNome());
        this.txEmail.setText(aluno.getEmail());
        this.txSite.setText(aluno.getSite());
    }
}
