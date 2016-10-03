package ulsaoaxaca.edu.mx.my_health;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Marlen on 3/010/2016.
 */

public class Parseo extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<ElementoLista> elementos=new ArrayList<>();

    public Parseo(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parseo");
        pd.setMessage("Parseando...");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if(result==0)
        {
            Toast.makeText(c,"No es posible parsear",Toast.LENGTH_SHORT).show();
        }else {
            Adaptador adapter=new Adaptador(c,elementos);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            elementos.clear();
            ElementoLista lista;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String titulo=jo.getString("titulo");
                String horario=jo.getString("horario");
                String descripcion=jo.getString("descripcion");
                String imageUrl=jo.getString("imageUrl");

                lista=new ElementoLista();

                lista.setId(id);
                lista.setTitulo(titulo);
                lista.setHorario(horario);
                lista.setDescripcion(descripcion);
                lista.setImageUrl(imageUrl);

                elementos.add(lista);
            }

            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}









