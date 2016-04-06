package rockapp.rockidentificationapp;

/**
 * Created by genevieveokon on 2016-04-05.
 */



    import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    import rockapp.rockidentificationapp.enums.Colour;
    import rockapp.rockidentificationapp.enums.Hardness;
    import rockapp.rockidentificationapp.enums.Size;
    import rockapp.rockidentificationapp.enums.Texture;

/**
     * Created by
     */
    public class DatabaseHelper extends SQLiteOpenHelper{

        public static final String DATABASE_NAME ="Rocknew.db";
        public static final String TABLE_NAME ="Rock_table";
        public static final String COL_1 ="ID";
        public static final String COL_2 ="NAME";
        public static final String COL_3 ="VALUE";
        public static final String COL_4 ="HARDNESS";
        public static final String COL_5 ="COLOUR";
        public static final String COL_6 ="TEXTURE";
        public static final String COL_7 ="SIZE";
        public static final String COL_8 ="LATITUDE";
        public static final String COL_9="LONGITUDE";
        public static final String COL_10 ="RADIUS";

        //private DatabaseHelper DBHelper;
        private SQLiteDatabase db;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
            SQLiteDatabase db = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String SQL_String = "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_2 + " TEXT," +
                    COL_3 + " DOUBLE," +
                    COL_4 + " TEXT," +
                    COL_5 + " TEXT," +
                    COL_6 + " TEXT," +
                    COL_7 + " TEXT," +
                    COL_8 + " INTEGER," +
                    COL_9 + " INTEGER," +
                    COL_10 + " INTEGER" +")";
            db.execSQL(SQL_String);
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole', 0.005, 'Medium', 'Black', 'Rough', 'Medium', 10, 29, 4582)");
            db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Amphibole', 0.005, 'Medium', 'Brown', 'Rough', 'Medium', 10, 29, 4582)");
            db.execSQL("INSERT INTO Rock_table(NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole', 0.005, 'Medium', 'Green', 'Rough', 'Medium', 10, 29, 4582)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Amphibole', 0.005, 'Medium', 'Black', 'Rough', 'Medium', 52, -99, 1604)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Amphibole', 0.005, 'Medium', 'Brown', 'Rough', 'Medium', 52, -99, 1604)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Amphibole', 0.005, 'Medium', 'Green', 'Rough', 'Medium', 52, -99, 1604)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Andesite', 0.0000007, 'Soft', 'Grey', 'Rough', 'Fine', 37, 14, 4050)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Andesite', 0.0000007, 'Soft', 'Grey', 'Rough', 'Fine', 2, -73, 5337)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Andesite', 0.0000007, 'Soft', 'Brown', 'Rough', 'Fine', 2, -73, 5337)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Anorthosite', 0.020, 'Medium', 'Grey', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Anorthosite', 0.020, 'Medium', 'Pink', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Anorthosite', 0.020, 'Medium', 'Brown', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Anorthosite', 0.020, 'Medium', 'Grey', 'Rough', 'Coarse', 60, -108, 1126)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Anorthosite', 0.020, 'Medium', 'Pink', 'Rough', 'Coarse', 60, -108, 1126)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Anorthosite', 0.020, 'Medium', 'Brown', 'Rough', 'Coarse', 60, -108, 1126)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Aplite', 0.006, 'Medium', 'Grey', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Aplite', 0.006, 'Medium', 'White', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Aplite', 0.006, 'Medium', 'Pink', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Aplite', 0.006, 'Medium', 'Grey', 'Rough', 'Fine', 31, 95, 3203)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Aplite', 0.006, 'Medium', 'White', 'Rough', 'Fine', 31, 95, 3203)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Aplite', 0.006, 'Medium', 'Pink', 'Rough', 'Fine', 31, 95, 3203)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Arkose', 0.009, 'Medium', 'Red', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Arkose', 0.009, 'Medium', 'Brown', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Arkose', 0.009, 'Medium', 'Grey', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Arkose', 0.009, 'Medium', 'Red', 'Rough', 'Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Arkose', 0.009, 'Medium', 'Brown', 'Rough', 'Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Arkose', 0.009, 'Medium', 'Grey', 'Rough', 'Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basalt', 0.0004, 'Medium', 'Grey', 'Rough', 'Fine', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basalt', 0.0004, 'Medium', 'Black', 'Rough', 'Fine', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Black', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Basanite', 0.072, 'Medium', 'Brown', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Basanite', 0.072, 'Medium', 'Green', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Basanite', 0.072, 'Medium', 'Grey', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Red', 'Rough', 'Fine', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'White', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Black', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Brown', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Green', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Grey', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'Red', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Basanite', 0.072, 'Medium', 'White', 'Rough', 'Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Blueschist', 0.004, 'Medium', 'Blue', 'Rough', 'Fine', 37, -100, 1225)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Blueschist', 0.004, 'Medium', 'Grey', 'Rough', 'Fine', 37, -100, 1225)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Blueschist', 0.004, 'Medium', 'Purple', 'Rough', 'Fine', 37, -100, 1225)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Breccia', 0.025, 'Medium', 'Black', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'Blue', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'Brown', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'Green', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Breccia', 0.025, 'Medium', 'Grey', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'Pink', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'Purple', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'Red', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Breccia', 0.025, 'Medium', 'White', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Black', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Brown', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Green', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Grey', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Pink', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'White', 'Rough', 'Coarse', 49, 19, 2029)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Black', 'Rough', 'Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Brown', 'Rough', 'Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Carbonatite', 0.001, 'Soft', 'Green', 'Rough', 'Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Carbonatite', 0.001,'Soft','Grey','Rough','Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Carbonatite', 0.001,'Soft','Pink','Rough','Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Carbonatite', 0.001,'Soft','White','Rough','Coarse', 51, -99, 2335)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Black','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Blue','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Brown','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Green','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Grey','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Red','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','White','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Yellow','Rough','Fine', -25, 135, 1741)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Black','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Blue','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Brown','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Green','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Grey','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Red','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','White','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Claystone', 0.021,'Soft','Yellow','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Coal', 0.009,'Soft','Black','Rough','Glassy', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Coal', 0.009,'Soft','Brown','Rough','Glassy', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Coal', 0.009,'Soft','Grey','Rough','Glassy', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Coal', 0.009,'Soft','Brown','Rough','Glassy', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Coal', 0.009,'Soft','Grey','Rough','Glassy', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Coal', 0.009,'Soft','Grey','Rough','Glassy', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Flint', 0.001,'Medium','Black','Glossy','Glassy', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Flint', 0.001,'Medium','Brown','Glossy','Glassy', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Flint', 0.001,'Medium','Green','Glossy','Glassy', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Flint', 0.001,'Medium','Grey','Glossy','Glassy', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Flint', 0.001,'Medium','Red','Glossy','Glassy', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Flint', 0.001,'Medium','White','Glossy','Glassy', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Black','Rough','Medium', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Grey','Rough','Medium', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','White','Rough','Medium', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Pink','Rough','Medium', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Orange','Rough','Medium', 60, 103, 3670)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Black','Rough','Medium', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Grey','Rough','Medium', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','White','Rough','Medium', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Pink','Rough','Medium', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Granite', 0.050,'Medium','Orange','Rough','Medium', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Limestone', 0.009,'Soft','Black','Rough','Course', 0, 28, 1889)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Limestone', 0.009,'Soft','Brown','Rough','Course', 0, 28, 1889)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Limestone', 0.009,'Soft','Grey','Rough','Course', 0, 28, 1889)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Limestone', 0.009,'Soft','Green','Rough','Course', 0, 28, 1889)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Limestone', 0.009,'Soft','Red','Rough','Course', 0, 28, 1889)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Limestone', 0.009,'Soft','White','Rough','Course', 0, 28, 1889)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Marble', 0.061,'Soft','White','Smooth','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Marble', 0.061,'Soft','Grey','Smooth','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Marble', 0.061,'Soft','Pink','Smooth','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Black','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Brown','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Grey','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Pink','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Red','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','White','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Yellow','Rough','Fine', 56, 106, 5632)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Black','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Brown','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Grey','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Pink','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Red','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','White','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Sandstone', 0.004,'Medium','Yellow','Rough','Fine', -16, 23, 1569)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Slate', 0.031,'Soft','Black','Rough','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Slate', 0.031,'Soft','Brown','Rough','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Slate', 0.031,'Soft','Green','Rough','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Slate', 0.031,'Soft','Grey','Rough','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ('Slate', 0.031,'Soft','Red','Rough','Fine', 33, 92, 2835)");
            db.execSQL("INSERT INTO Rock_table (NAME,VALUE,HARDNESS,COLOUR,TEXTURE,SIZE,LATITUDE,LONGITUDE,RADIUS) VALUES ( 'Dwayne The Rock_table Johnson', 1.00,'Hard','Black','Smooth','Fine', 38, -122, 699)");
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

        public boolean insertData(String name, Double value,String hardness, String colour,String texture,String size, Integer latitude,Integer longitude,Integer radius)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(COL_2, name);
            contentValues.put(COL_3,value);
            contentValues.put(COL_4, hardness);
            contentValues.put(COL_5, colour);
            contentValues.put(COL_6,texture);
            contentValues.put(COL_7, size);
            contentValues.put(COL_8, latitude);
            contentValues.put(COL_9, longitude);
            contentValues.put(COL_10, radius);

            long result = db.insert(TABLE_NAME,null,contentValues);
            return result != -1;
        }



        public Rock[] queryData(String SQLquery) {
            Rock[] results;
            SQLiteDatabase db=this.getWritableDatabase();
            //query(String table, String[] columns, String selection, String[]selectionArgs, String groupBy, String having, String orderBy)
            Cursor cursor = db.query(TABLE_NAME, null, SQLquery, null, null, null, null);
            results = new Rock[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < results.length; i++) {
                results[i] = new Rock(
                        cursor.getString(0),
                        Double.valueOf(cursor.getString(1)),
                        Colour.valueOf(cursor.getString(2)),
                        Hardness.valueOf(cursor.getString(3)),
                        Size.valueOf(cursor.getString(4)),
                        Texture.valueOf(cursor.getString(5)),
                        Double.valueOf(cursor.getString(6)),
                        Double.valueOf(cursor.getString(7)),
                        Double.valueOf(cursor.getString(8))
                );
                cursor.moveToNext();
            }
            return results;
            //Cursor cursor = db.rawQuery("SELECT NAME FROM  WHERE NAME LIKE '%" +  + "%'", null);
        }
    }



