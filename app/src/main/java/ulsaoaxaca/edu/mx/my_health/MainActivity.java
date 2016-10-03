package ulsaoaxaca.edu.mx.my_health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "LoginPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getString("logged", "").toString().equals("logged")) {
            Intent intent = new Intent(MainActivity.this, OpcionesActivity.class);
            startActivity(intent);
        }

        Button b = (Button) findViewById(R.id.btnSesion);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usuario = (EditText) findViewById(R.id.usuarioTxt);
                EditText contrasena = (EditText) findViewById(R.id.contrasenaTxt);

                if (usuario.getText().toString().length() > 0 && contrasena.getText().toString().length() > 0) {
                    if (usuario.getText().toString().equals("admin") && contrasena.getText().toString().equals("admin")) {

                        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("logged", "logged");
                        editor.commit();


                        Intent intent = new Intent(MainActivity.this, OpcionesActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}

