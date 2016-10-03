package ulsaoaxaca.edu.mx.my_health;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class OpcionesActivity extends AppCompatActivity {
    final static String ip="http://192.168.1.65/android/datos.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);


        Button iAlimentos = (Button) findViewById(R.id.btnAlimentos);

        final ListView lv= (ListView) findViewById(R.id.lv);
        iAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BajarDatos(OpcionesActivity.this,ip,lv).execute();

            }
        });

    }
}
