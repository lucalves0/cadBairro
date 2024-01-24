package br.com.dgs.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.dgs.MainActivity;
import br.com.dgs.R;
import br.com.dgs.adapters.BairroAdapter;
import br.com.dgs.model.Bairro;
import br.com.dgs.repository.BairroRepository;
import br.com.dgs.utils.TagForm;

public class ListBairroActivity extends AppCompatActivity {

    ListView lvBairro;
    Button btnNovo;
    Button btnVoltar;
    BairroRepository bairroRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bairro);
        bairroRepository = BairroRepository.getInstance(this);
        atualiza();

        lvBairro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Bairro bairro = (Bairro) parent.getItemAtPosition(position);
                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListBairroActivity.this);
                builder.setTitle("Cadastro de Bairro");
                builder.setMessage("Selecione uma opção");
                builder.setPositiveButton("Alterar".toString(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ListBairroActivity.this, CadBairroActivity.class);
                        CadBairroActivity.tagForm = TagForm.A;
                        CadBairroActivity.bairro = bairro;
                        startActivity(intent);
                        atualiza();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int agr1) {
                        bairroRepository.remover(bairro);
                        atualiza();
                    }
                });
                alerta = builder.create();
                alerta.show();
                atualiza();

            }
        });

        btnNovo = findViewById(R.id.btnNovoBairroLista);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBairroActivity.this, CadBairroActivity.class);
                CadBairroActivity.tagForm = TagForm.I;
                startActivity(intent);
            }
        });

        btnVoltar= findViewById(R.id.btnVoltaBairroLista);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBairroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void atualiza() {
        List<Bairro> bairros = bairroRepository.getAll();
        lvBairro = findViewById(R.id.lvBairros);
        ArrayAdapter ad = new BairroAdapter(this, R.layout.lista_bairros, bairros);
        lvBairro.setAdapter(ad);
    }


}