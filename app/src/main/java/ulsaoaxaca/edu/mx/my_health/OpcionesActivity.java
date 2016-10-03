package ulsaoaxaca.edu.mx.my_health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OpcionesActivity extends AppCompatActivity {

    CardView cardAlimentos;
    CardView cardMedicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);


        cardAlimentos = (CardView) findViewById(R.id.cardAlimentos);
        cardMedicamentos = (CardView) findViewById(R.id.cardMedicamentos);

        cardAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        cardMedicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
