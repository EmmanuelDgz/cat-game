package com.emmanuel.gato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // symbol 0 = X, symbol 1 = O
    private int symbolPlayer1;
    private int numPartidas;
    private Boolean symbolSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnX = findViewById(R.id.btnX);
        final Button btnO = findViewById(R.id.btnO);
        final Button btnPlay = findViewById(R.id.btnPlay);
        final EditText inputPartidas = findViewById(R.id.inputPartidas);

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbolPlayer1 = 0;
                symbolSelected = true;
                btnX.setEnabled(false);
                btnO.setEnabled(false);
            }
        });

        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbolPlayer1 = 1;
                symbolSelected = true;
                btnO.setEnabled(false);
                btnX.setEnabled(false);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String partidas = inputPartidas.getText().toString();

                if (symbolSelected && partidas.compareTo("") != 0) {
                    numPartidas = Integer.parseInt(inputPartidas.getText().toString());

                    if (numPartidas > 0) {
                        Intent gatoActivity = new Intent(MainActivity.this, GatoActivity.class);
                        gatoActivity.putExtra("symbol", symbolPlayer1);
                        gatoActivity.putExtra("numPartidas", numPartidas);
                        startActivity(gatoActivity);
                    }
                    else {
                        Toast msg = Toast.makeText(getApplicationContext(),"Número de partidas debe ser mayor a cero", Toast.LENGTH_LONG);
                        msg.show();
                    }
                }
                else {
                    Toast msg = Toast.makeText(getApplicationContext(),"Selecciona símbolo y número de partidas", Toast.LENGTH_LONG);
                    msg.show();
                }
            }
        });
    }
}
