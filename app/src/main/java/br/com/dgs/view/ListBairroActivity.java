package br.com.dgs.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import br.com.dgs.R;

public class ListBairroActivity extends AppCompatActivity {

    ListView lvBairro;
    Button btnNovo;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bairro);
    }
}