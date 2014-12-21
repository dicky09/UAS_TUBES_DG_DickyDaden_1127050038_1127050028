package com.booting.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import com.booting.ecommerce.MainActivity;
import com.booting.ecommerce.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class BarangAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    HashMap<String, String> tipss;
    
    public BarangAdapter(Activity a, 
    	ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, 
    	View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
 
        TextView id	          = (TextView)vi.findViewById(R.id.id);
        TextView title        = (TextView)vi.findViewById(R.id.title); 
        TextView keterangan   = (TextView)vi.findViewById(R.id.keterangan);
        TextView spec         = (TextView)vi.findViewById(R.id.spec);
        TextView txtImage     = (TextView)vi.findViewById(R.id.txtImage);
        TextView txtDetail    = (TextView)vi.findViewById(R.id.detail);
        ImageView thumb_image =(ImageView)vi.findViewById(R.id.list_image); // thumb image
        
        tipss = new HashMap<String, String>();
        tipss = data.get(position);
      
        // TODO Setting all values in list view
        id.setText(tipss.get(MainActivity.AR_ID));
        title.setText(tipss.get(MainActivity.AR_NAMA));
        keterangan.setText(tipss.get(MainActivity.AR_KETERANGAN));
        spec.setText(tipss.get(MainActivity.AR_SPEC));
        txtImage.setText(tipss.get(MainActivity.AR_IMAGE));
        txtDetail.setText(tipss.get(MainActivity.AR_DETAIL));
        
        String image = txtImage.getText().toString();
        if (image.equals("setupatok.png")) {
        	thumb_image.setImageResource(R.drawable.setupatok);
        } else if (image.equals("banyupanas.png")) {
        	thumb_image.setImageResource(R.drawable.banyupanas);
        } else if (image.equals("telagaremis.png")) {
        	thumb_image.setImageResource(R.drawable.telagaremis);
        } else if (image.equals("situsedong.png")) {
        	thumb_image.setImageResource(R.drawable.situsedong);
        } else if (image.equals("masjidagungciptarasa.png")) {
        	thumb_image.setImageResource(R.drawable.masjidagungciptarasa);
        } else if (image.equals("keratonkasepuhan.png")) {
        	thumb_image.setImageResource(R.drawable.keratonkasepuhan);
        } else if (image.equals("keratonkanoman.png")) {
        	thumb_image.setImageResource(R.drawable.keratonkanoman);
        } else if (image.equals("keratonkecerbonan.png")) {
        	thumb_image.setImageResource(R.drawable.keratonkecerbonan);
        } else if (image.equals("guasunyaragi.png")) {
        	thumb_image.setImageResource(R.drawable.guasunyaragi);
        } else if (image.equals("makamgunungjati.png")) {
        	thumb_image.setImageResource(R.drawable.makamgunungjati);
        }
        
        return vi;
    } 
    
 // TODO Clear data on list view
    public void clearList() {
        data.clear();
        notifyDataSetChanged();
    }
}