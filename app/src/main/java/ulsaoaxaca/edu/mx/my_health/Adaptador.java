package ulsaoaxaca.edu.mx.my_health;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marlen on 3/10/2016.
 */
public class Adaptador extends BaseAdapter {

    Context c;
    ArrayList<ElementoLista> elementos;

    LayoutInflater inflater;

    public Adaptador(Context c, ArrayList<ElementoLista> elements) {
        this.c = c;
        this.elementos = elements;

        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.modelo,parent,false);
        }

        TextView titulotxt= (TextView) convertView.findViewById(R.id.tituloTxt);
        TextView horariotxt=(TextView) convertView.findViewById(R.id.horarioTxt);
        TextView descripciontxt=(TextView) convertView.findViewById(R.id.descripcionTxt);
        ImageView imgUrl= (ImageView) convertView.findViewById(R.id.elementoImagen);

        //BIND DATA
        ElementoLista spacecraft=elementos.get(position);

        titulotxt.setText(spacecraft.getTitulo());
        horariotxt.setText(spacecraft.getHorario());
        descripciontxt.setText(spacecraft.getDescripcion());
        //IMAGEN
        ImagenPicasso.downloadImage(c,spacecraft.getImageUrl(),imgUrl);
        return convertView;
    }
}
