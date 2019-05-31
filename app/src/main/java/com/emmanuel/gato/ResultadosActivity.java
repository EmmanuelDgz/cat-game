package com.emmanuel.gato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        int totalPartidas = getIntent().getExtras().getInt("totalPartidas");
        int scoreX = getIntent().getExtras().getInt("scoreX");
        int scoreO = getIntent().getExtras().getInt("scoreO");

        TextView labelResultado = findViewById(R.id.labelResultado);
        TextView labelWinner = findViewById(R.id.labelWinner);
        TextView labelConteo = findViewById(R.id.labelConteo);
        Button buttonReplay = findViewById(R.id.buttonReplay);

        if (scoreX == scoreO)
            labelResultado.setText("¡EMPATE!");
        else
            labelResultado.setText("¡GANADOR!");

        if (scoreX > scoreO) {
            labelWinner.setText("X");
            labelConteo.setText(scoreX + " de " + totalPartidas);
        }
        else if (scoreO > scoreX) {
            labelWinner.setText("O");
            labelConteo.setText(scoreO + " de " + totalPartidas);
        }

        buttonReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(ResultadosActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }
}
