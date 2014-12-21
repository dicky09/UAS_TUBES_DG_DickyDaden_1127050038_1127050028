package com.booting.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BarangDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ecommerseDB";
	public static final String KATEGORI   = "kategori";
	public static final String KISARAN    = "kisaran";
	public static final String NAMA       = "nama";
	public static final String IMAGE      = "image";
	public static final String KETERANGAN = "keterangan";
	public static final String SPEC       = "spec";
	public static final String DETAIL     = "detail";
	
	public BarangDB(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	public void createTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS Barang");
		db.execSQL("CREATE TABLE if not exists Barang " +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"kategori varchar(50), kisaran varchar(50), " +
				"nama varchar(50), image varchar(50), " +
				"keterangan TEXT, spec TEXT, detail TEXT);");
	}
	
	public void generateData(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Alam");
		cv.put(NAMA, "Situ patok");
		cv.put(IMAGE, "setupatok.png");
		cv.put(KETERANGAN, "Situ Patok");
		cv.put(SPEC, "Desa Setu patok Kecamatan Mundu\n");
		cv.put(DETAIL, "Deskripsi Singkat\n" +
				"Luas Situ Patok 175 Ha yang terletak di desa setu " +
				"patok sekitar 6 km dari kota Cirebon.Keindahan panorama" +
				"alam merupakan aspek yang diunggulkan dari kawasan ini." +
				"kawasan ini masih dalam proses pengembangan, nantinya akan "+
				"ada berbagai fasilitas yang menunjang lokasi ini seperti" +
				"dermaga, sarana pemancingan, perahu motor, dan berbagai rumah makan.");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Alam");
		cv.put(NAMA, "Banyu Panas Palimanan");
		cv.put(IMAGE, "banyupanas.png");
		cv.put(KETERANGAN, "Banyu Panas Palimanan");
		cv.put(SPEC, "Desa Palimanan Barat kecamatan Palimanan\n");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Air di taman pemandian ini adalah sumber air panas alami " +
				"yang mengandung belerang dan dipercaya dapat menyembuhkan"+
				"berbagai penyakit kulit. Air panas yang terdapat disini dialirkan"+
				"langsung dari Gunung Kromong yang terletak dekat dengan lokasi wisata ini."+
				"Anda dapat memanjakan diri dan berelaksasi dengan berendam di "+
				"kolam air hangat yang ada di kawasan ini.");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Alam");
		cv.put(NAMA, "Desa Wisata Cikalahang");
		cv.put(IMAGE, "telagaremis.png");
		cv.put(KETERANGAN, "Desa Wisata Cikalahang - Telaga Remis");
		cv.put(SPEC, "Desa Cikalahang-Sumber kabupaten Cirebon\n");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Desa wisata ini mempunyai daya tarik sendiri "+
				"yaitu kawasan usaha restoran/rumah makan ikan bakar."+
				"Di kawasan ini terdapat Telaga yg dinamai Telaga remis."+
				"Telaga remis menyuguhkan keindahan pemandangan dan"+
				"suasana alam yang asri dan hijau diantara hutan pohon pinus"+
				"dan bebatuan serta terdapat jogging trek di sekitar danau."+
				"fasilitas off-road yang menyukai tantangan dan petualangan di alam bebas.");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Alam");
		cv.put(NAMA, "Situ Sedong");
		cv.put(IMAGE, "situsedong.png");
		cv.put(KETERANGAN, "Situ Sedong");
		cv.put(SPEC, "Desa Sedong Kidul Kecamatan Sedong-Sindang Laut\n");
		cv.put(DETAIL, "Deskripsi Singkat\n" +
				"Terletak di desa Sedong sekitar 16 km dari"+
				"Kota Cirebon, dengan luas lahan sampai 62,5 Ha."+
				"Situ ini mempunyai panorama yang indah dan"+ 
				"disediakan tempat bersantai bersama keluarga serta"+
				"wahana bebek air yang bisa digunakan untuk mengelilingi Situ Sedong."+
				"Selain itu juga menjadi tempat wisata pemancingan ikan.");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Religi");
		cv.put(NAMA, "Masjid Agung Cipta Rasa");
		cv.put(IMAGE, "masjidagungciptarasa.png");
		cv.put(KETERANGAN, "Masjid Agung Cipta Rasa");
		cv.put(SPEC, "Mandalangan Kel.kesepuhan Kec.Lemah Wungkuk\n");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Mesjid Agung Sang Cipta Rasa dibangun pada tahun 1498" +
				"oleh Wali Songo atas prakarsa Sunan Gunung Jati." +
				"Pembangunannya dipimpin oleh Sunan Kalijaga dengan" +
				"arsitek Raden Sepat (dari Majapahit) bersama dengan 200" +
				"orang pembantunya(tukang) yang berasal dari Demak." +
				"Mesjid Agung ini mempunyai sembilan pintu dan terkenal" +
				"dengan adzan pitu.Konon pembangunan mesjid ini" + 
				"hanya dalam tempo satu malam pada dini hari" + 
				"keesokan harinya telah dipergunakan untuk shalat Subuh.");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Religi");
		cv.put(NAMA, "Makam Sunan Gunung Jati");
		cv.put(IMAGE, "makamgunungjati.png");
		cv.put(KETERANGAN, "Makam Sunan Gunung Jati");
		cv.put(SPEC, "Gunung Jati \n");
		cv.put(DETAIL, "Deskripsi Singkat \n" + 
				"Dihiasi dengan keramik buatan Cina jaman" + 
				"Dinasti Ming.Di komplek makam ini di samping" +
				"tempat dimakamkannya Sunan Gunung Jati juga" +
				"tempat dimakamkannya Fatahilah panglima" + 
				"perang pembebasan Batavia. Lokasi ini merupakan" + 
				"komplek pemakaman bagi keluarga Keraton Cirebon" +
				"phone dengan harga yang terjangkau.");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Sejarah");
		cv.put(NAMA, "Keraton Kasepuhan");
		cv.put(IMAGE, "keratonkasepuhan.png");
		cv.put(KETERANGAN, "Keraton Kasepuhan");
		cv.put(SPEC, "Jl.Kasepuhan No 43, Kampung Mandalangan" +
		"Kel.Kasepuhan, Kec.Lemah Wungkuk \n");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Keraton Kasepuhan didirikan pada tahun 1529" + 
				"oleh Pangeran Mas Mochammad Arifin II" +
				"(cicit dari Sunan Gunung Jati).Keraton Kasepuhan" +
				"dulunya bernama Keraton Pakungwati karena" + 
				"Pangeran Mas Mochammad Arifin bergelar Panembahan Pakungwati I." + 
				"Sebutan Pakungwati berasal dari nama" + 
				"Ratu Dewi Pakungwati binti Pangeran Cakrabuana" +
				"yang menikah dengan Sunan Gunung Jati." +  
				"Keraton yang menjadi saksi penyebaran islam di Cirebon");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Sejarah");
		cv.put(NAMA, "Keraton Kanoman");
		cv.put(IMAGE, "keratonkanoman.png");
		cv.put(KETERANGAN, "Keraton Kanoman");
		cv.put(SPEC, "Jl.Winaon, Kampung Kanoman "+
		"Kel.Lemah Wungkuk, Kec.Lemah Wungkuk");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Keraton Kanoman didirikan oleh Sultan Kanoman I" +
				"(Sultan Badridin) turunan ke VII dari Sunan" +
				"Gunung Jati (Syarief Hidayatullah) pada tahun 510" +
				"tahun Saka atau tahun 1588 Masehi. Adapun prasasti" +
				"tahun berdirinya Keraton Kanoman terdapat pada" + 
				"pintu Pandopa Jinem yang menuju keruangan Perbayaksa" + 
				"dipintu tersebut terpahat gambar angka Surya Sangkala & Chandra." +
				"Selain itu, keraton ini masih menjadi tempat tinggal" +
				"keturunan ke-12 kesultanan yaitu Raja Muhammad Emiruddin dan keluarganya");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Sejarah");
		cv.put(NAMA, "Keraton Kecerbonan");
		cv.put(IMAGE, "keratonkecerbonan.png");
		cv.put(KETERANGAN, "Keraton Kecerbonan");
		cv.put(SPEC, "Jl.Pulosaren No 48  Kampung Pulosaren" +
		"Kel.Pulosaren, Kec.Pekalipan \n");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Keraton Kecerbonan dibangun pada tahun 1800" +
				"Keraton ini banyak menyimpan benda-benda peninggalan" +
				"sejarah seperti Keris Wayang perlengkapan Perang" +
				"Gamelan dan lain-lain. Seperti halnya Keraton" +
				"Kesepuhan dan Keraton Kanoman, Keraton Kecirebonan" + 
				"pun tetap menjaga dan melestarikan serta melaksanakan" +
				"kebiasaan maupun upacara adat seperti Upacara Panjang" +
				"Jimat dan sebagainya.Keraton Kecerboan dan Keraton Kanoman" +
				"termasuk pemekaran dari keraton Kesepuhan");
		db.insert("Barang", KATEGORI, cv);
		
		cv.put(KATEGORI, "Cirebon");
		cv.put(KISARAN, "Wisata Sejarah");
		cv.put(NAMA, "Gua Sunyaragi");
		cv.put(IMAGE, "guasunyaragi.png");
		cv.put(KETERANGAN, "Gua Sunyaragi");
		cv.put(SPEC, "By Pass Jln Brig.Dharsono, Kampung Karang Balong" +
				"Kel.Sunyaragi, Kec.Kesambi");
		cv.put(DETAIL, "Deskripsi Singkat \n" +
				"Situs ini awalnya merupakan Taman Kelangenan" +
				"yang fungsi utamanyauntuk berkhalawatan atau menyepi." +
				"Bentuknya yang unik dengan rongga dan lorong yang" +
				"berliku meyerupai gua membuatnya dikenal dengan" +
				"Gua Sunyaragi.Goa Sunyaragi menempati lahan seluas" +
				"15.000 m², merupakan milik Keraton Kesepuhan secara" +
				"turun temurun.Kesan sakral yang berasal dari lorong bekas" +
				"pertapaan, kolam-kolam pemandian, altar-altar mirip tempat pemujaan" +
				"dan benda-benda arkeologis lainnya yang bersifat spiritual.");
		db.insert("Barang", KATEGORI, cv);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//TODO Auto-generated method stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//TODO Auto-generated method sub		
	}
}