package com.booting.ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.booting.adapter.BarangAdapter;
import com.booting.database.BarangDB;
import com.booting.database.KategoriDB;
import com.booting.database.KisaranDB;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;


public class MainActivity extends DashBoardActivity {
	private Spinner Kategori, Kisaran;
	private KategoriDB dbKategori;
	private KisaranDB dbKisaran;
	private SQLiteDatabase db1 = null;
	private SQLiteDatabase db2 = null;
	public static final String AR_ID     = "Id";
	public static final String AR_NAMA   = "Nama";
	public static final String AR_IMAGE  = "Image";
	public static final String AR_KETERANGAN = "Keterangan";
	public static final String AR_SPEC   = "Spec";
	public static final String AR_DETAIL = "Detail";
	
	ArrayList<HashMap<String, String>> daftar_list = new ArrayList<HashMap<String, String>>();
	
	private SQLiteDatabase db = null;
	private BarangDB dataDB   = null;
	private Cursor cursor     = null;
	
	private HashMap<String, String> mapp;
	private ListView list;
	private BarangAdapter adap;
	private String kategori, kisaran;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.main);
        setHeader(getString(R.string.HomeActivityTitle), false, true);
        
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        
        dbKategori = new KategoriDB(this);
        db1 = dbKategori.getWritableDatabase();
        dbKategori.createTable(db1);
        dbKategori.generateData(db1);
        
        dbKisaran = new KisaranDB(this);
        db2 = dbKisaran.getWritableDatabase();
        dbKisaran.createTable(db2);
        dbKisaran.generateData(db2);
        
        dataDB = new BarangDB(this);
	    db = dataDB.getWritableDatabase();
	    dataDB.createTable(db);
	    dataDB.generateData(db);

        isiDataSpinnerKategori();
        isiDataSpinnerKisaran();
        getList();
        
        Kategori.setOnItemSelectedListener(new OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
            	kategori = Kategori.getSelectedItem().toString();
            	adap.clearList();
				getList();
            }
            public void onNothingSelected(AdapterView<?> arg0) { 
				// TODO Auto-generated method stub
				
			}
        });
        
        Kisaran.setOnItemSelectedListener(new OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
            	kisaran = Kisaran.getSelectedItem().toString();
            	adap.clearList();
				getList();
            }
            public void onNothingSelected(AdapterView<?> arg0) { 
				// TODO Auto-generated method stub
				
			}
        });
    }
    
    private void isiDataSpinnerKategori() {
    	Kategori = (Spinner) findViewById(R.id.kategori);
    	List<String> lables = dbKategori.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, lables);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Kategori.setAdapter(dataAdapter);
        kategori = Kategori.getSelectedItem().toString();
    }
    
    private void isiDataSpinnerKisaran() { 
    	Kisaran = (Spinner) findViewById(R.id.kisaran);
    	List<String> lables = dbKisaran.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, lables);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Kisaran.setAdapter(dataAdapter);
    	kisaran  = Kisaran.getSelectedItem().toString();
    }
    
    public void getList() {
    	try {
		    cursor = db.rawQuery("SELECT * " + "FROM Barang WHERE Kategori = '" + kategori + "'" + " and Kisaran = '" + kisaran + "';", null);
		    if (cursor.getCount() > 0) {
		    	int indexId         = cursor.getColumnIndex("id");
		    	int indexNama       = cursor.getColumnIndex("nama");
		    	int indexImage      = cursor.getColumnIndex("image");
		    	int indexKeterangan = cursor.getColumnIndex("keterangan");
		    	int indexSpec       = cursor.getColumnIndex("spec");
		    	int indexDetail     = cursor.getColumnIndex("detail");
		    	
		    	cursor.moveToFirst();
				do {
					String Id         = cursor.getString(indexId);
					String Nama       = cursor.getString(indexNama);
					String Image      = cursor.getString(indexImage);
					String Keterangan = cursor.getString(indexKeterangan);
					String Spec       = cursor.getString(indexSpec);
					String Detail     = cursor.getString(indexDetail);
					
					mapp = new HashMap<String, String>();
					mapp.put(AR_ID, Id);
					mapp.put(AR_NAMA, Nama);
					mapp.put(AR_IMAGE, Image);
					mapp.put(AR_KETERANGAN, Keterangan);
					mapp.put(AR_SPEC, Spec);
					mapp.put(AR_DETAIL, Detail);
					
					daftar_list.add(mapp);
					
					cursor.moveToNext();
				} while (!cursor.isAfterLast());
		    }
	    } finally {
			if (cursor != null) {
				cursor.close();
			}
			
			this.adapter_listview();
		}
    }
    
    public void adapter_listview() {
		list = getListView();
		adap = new BarangAdapter(this, daftar_list);
        list.setAdapter(adap);
        
        list.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				// TODO Auto-generated method stub
				String image = ((TextView) view.findViewById(R.id.txtImage)).getText().toString();
				String title = ((TextView) view.findViewById(R.id.title)).getText().toString();
				String keter = ((TextView) view.findViewById(R.id.keterangan)).getText().toString();
				String spec  = ((TextView) view.findViewById(R.id.spec)).getText().toString();
				String detai = ((TextView) view.findViewById(R.id.detail)).getText().toString();
				Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
		    	overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
		    	intent.putExtra("Image", image);
		    	intent.putExtra("Title", title);
		    	intent.putExtra("Keterangan", keter);
		    	intent.putExtra("Spec", spec);
		    	intent.putExtra("Detail", detai);
		    	startActivity(intent);
			}
		});
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	try {
    		db1.close();
    		db2.close();
    	} catch (Exception e) {
    	
    	}
    }
}