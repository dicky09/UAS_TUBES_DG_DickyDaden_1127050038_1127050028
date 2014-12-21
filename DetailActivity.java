package com.booting.ecommerce;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends DashBoardActivity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.detail);
        
        Bundle b = getIntent().getExtras(); 
    	String Image = b.getString("Image");
    	String Title = b.getString("Title");
    	String Keterangan = b.getString("Keterangan");
    	String Spec   = b.getString("Spec");
    	String Detail = b.getString("Detail");
    	
        setHeader(Title, true, true);
        
        TextView keterangan   = (TextView) findViewById(R.id.keterangan);
        TextView spec         = (TextView) findViewById(R.id.spec);
        TextView txtDetail    = (TextView) findViewById(R.id.detail);
        ImageView thumb_image = (ImageView) findViewById(R.id.list_image);
        
        txtDetail.setText(Detail);
        keterangan.setText("Nama : " + Keterangan);
        spec.setText("\nAlamat :\n" + Spec);
        
        if (Image.equals("setupatok.png")) {
        	thumb_image.setImageResource(R.drawable.setupatok);
        } else if (Image.equals("banyupanas.png")) {
        	thumb_image.setImageResource(R.drawable.banyupanas);
        } else if (Image.equals("telagaremis.png")) {
        	thumb_image.setImageResource(R.drawable.telagaremis);
        } else if (Image.equals("situsedong.png")) {
        	thumb_image.setImageResource(R.drawable.situsedong);
        } else if (Image.equals("masjidagungciptarasa.png")) {
        	thumb_image.setImageResource(R.drawable.masjidagungciptarasa);
        } else if (Image.equals("keratonkasepuhan.png")) {
        	thumb_image.setImageResource(R.drawable.keratonkasepuhan);
        } else if (Image.equals("keratonkanoman.png")) {
        	thumb_image.setImageResource(R.drawable.keratonkanoman);
        } else if (Image.equals("keratonkecerbonan.png")) {
        	thumb_image.setImageResource(R.drawable.keratonkecerbonan);
        } else if (Image.equals("guasunyaragi.png")) {
        	thumb_image.setImageResource(R.drawable.guasunyaragi);
        } else if (Image.equals("makamgunungjati.png")) {
        	thumb_image.setImageResource(R.drawable.makamgunungjati);
        }
    }
}