package br.com.dgs.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.dgs.R;
import br.com.dgs.model.Bairro;
import br.com.dgs.repository.BairroRepository;
import br.com.dgs.utils.TagForm;

public class CadBairroActivity extends AppCompatActivity {

    Button btnSalvar;
    Button btnCancelar;
    EditText edId;
    EditText edNome;
    EditText edUf;

    public static TagForm tagForm;
    public static Bairro bairro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_bairro);

        edId = findViewById(R.id.edtIdBairroCad);
        edNome = findViewById(R.id.edtNomeBairroCad);
        edUf = findViewById(R.id.edtUfBairroCad);

        btnSalvar = findViewById(R.id.btnSalvarBairroCad);
        btnCancelar = findViewById(R.id.btnCancelarBairroCad);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Id", edId.getText().toString());
                Log.e("Nome", edNome.getText().toString());

                Bairro bairro = new Bairro();
                bairro.setId(edId.getText().toString());
                bairro.setId(edNome.getText().toString());
                bairro.setId(edUf.getText().toString());

                BairroRepository bairroRepository = BairroRepository.getInstance(CadBairroActivity.this);
                if(tagForm == TagForm.I){
                    bairroRepository.inserir(bairro);
                } else {
                    bairroRepository.alterar(bairro);
                }
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadBairroActivity.this, ListBairroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preecheCampos();
        }

    }

    private void preecheCampos() {
        edId.setText(String.valueOf(bairro.getId()));
        edNome.setText(bairro.getNome());
        edUf.setText(bairro.getUf());
    }
}