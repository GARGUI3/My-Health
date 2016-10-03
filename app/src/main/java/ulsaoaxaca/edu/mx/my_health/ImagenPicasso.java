package ulsaoaxaca.edu.mx.my_health;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Marlen on 24/09/2016.
 */
public class ImagenPicasso {

    public static void downloadImage(Context c, String imageUrl, ImageView img)
    {
        if(imageUrl.length()>0 && imageUrl!=null)
        {
            Picasso.with(c).load(imageUrl).placeholder(R.drawable.descarga).into(img);
        }else {
            Picasso.with(c).load(R.drawable.descarga).into(img);
        }
    }

}
