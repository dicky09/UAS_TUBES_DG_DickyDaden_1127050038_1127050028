package com.booting.database;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class KisaranDB extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "ecommerseDB";
	public static final String ID	          = "_id";
	public static final String KISARAN        = "kisaran";
	
	public KisaranDB(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	public void createTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS Kisaran");
		db.execSQL("CREATE TABLE if not exists Kisaran " +
				"(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"kisaran varchar(50));");
	}
	
	public void generateData(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		cv.put(KISARAN, "Wisata Alam");
		db.insert("Kisaran", KISARAN, cv);
		
		cv.put(KISARAN, "Wisata Religi");
		db.insert("Kisaran", KISARAN, cv);
		
		cv.put(KISARAN, "Wisata Sejarah");
		db.insert("Kisaran", KISARAN, cv);
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
		int newVersion) {
		//TODO Auto-generated method stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//TODO Auto-generated method sub	
	}
	
	/**
     * Getting all labels
     * returns list of labels
     * */
    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();
 
        // Select All Query
        String selectQuery = "SELECT * FROM Kisaran";
 
        SQLiteDatabase db = this.getReadableDatabase();    
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
 
        // returning lables
        return labels;
    }
}