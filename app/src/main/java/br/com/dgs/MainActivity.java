package br.com.dgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.dgs.view.ListBairroActivity;
import br.com.dgs.view.SicronizarActivity;


public class MainActivity extends AppCompatActivity {

    Button btnBairro;
    Button btnSincronizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBairro = findViewById(R.id.CadBairro);
        btnBairro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, ListBairroActivity.class);
                startActivity(intent);
            }
        });

        btnSincronizar = findViewById(R.id.Sincrozinar);
        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SicronizarActivity.class);
                startActivity(intent);
            }
        });
    }
}