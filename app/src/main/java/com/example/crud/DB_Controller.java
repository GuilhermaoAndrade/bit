package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DB_Controller extends SQLiteOpenHelper {



    private static final String DB_NAME = "Cliente.db";
    private static final String DB_TABLE = "Produto";
    private static final String DB_TABLE_VENDA= "venda";
    private static final String DB_TABLE_ITEMVENDA = "Itemvenda";



    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String NPRODUTO = "nproduto";
    private static final String NVENDA = "nvenda";
    private static final String NITEMVENDA = "nitemvenda";

    private static final String CREATE_TABLE = "CREATE TABLE "+ DB_TABLE+" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME + " TEXT "+ ")";

    private static final String CREATE_TABLE_VENDA = "CREATE TABLE "+ DB_TABLE_VENDA +" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME + " TEXT "+ ")";

//    private static final String CREATE_TABLE_iTEMVENDA = "CREATE TABLE "+ DB_TABLE_ITEMVENDA+" ("+
//            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME + " TEXT "+ ")";

    private static final String CREATE_TABLE_ITEMVENDA = "CREATE TABLE "+ DB_TABLE_ITEMVENDA+" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NPRODUTO + " TEXT, "+
            NVENDA + " TEXT,"+
            NITEMVENDA + " TEXT, "+
            "CONSTRAINT FK_PRODUTOFOREIGN FOREIGN KEY ("+NPRODUTO+") REFERENCES " + DB_TABLE + "("+NAME+"), "+
            "CONSTRAINT FK_VENDA FOREIGN KEY ("+NVENDA+") REFERENCES " + DB_TABLE_VENDA + "("+NAME+"), "+
            "CONSTRAINT FK_ITEMVENDA FOREIGN KEY ("+NITEMVENDA+") REFERENCES " + DB_TABLE_ITEMVENDA + "("+NAME+"))";

    public DB_Controller(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE_VENDA);
        sqLiteDatabase.execSQL(CREATE_TABLE_ITEMVENDA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE );

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_VENDA );

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_ITEMVENDA );


        onCreate(sqLiteDatabase);
    }


    // metodos da tabela produto

    public void  insert_produto(ModeloProduto MC){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, MC.getProduto());
        db.insert(DB_TABLE,null,contentValues);

    }

    public void delete_produto(String firstname){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, "NAME = ?",new String[]{firstname});

    }

    public void update_produto(String old_firstname, String new_firstname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, new_firstname);
        db.update(DB_TABLE,contentValues,"NAME = ?",new String[]{old_firstname});
    }

    public void list_all_produto(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM Produto", null);
        textView.setText("");
        while(cursor.moveToNext()){
            textView.append(cursor.getString(0)+" "+cursor.getString(1)+"\n");

        }
    }

    // metodos da tabela produto

    // metodos da tabela venda

    public void  insert_venda (ModeloVenda MF){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, MF.getVenda());
        db.insert(DB_TABLE_VENDA,null,contentValues);

    }

    public void delete_venda(String firstname){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE_VENDA, "NAME = ?",new String[]{firstname});

    }

    public void update_venda(String old_firstname, String new_firstname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, new_firstname);
        db.update(DB_TABLE_VENDA,contentValues,"NAME = ?",new String[]{old_firstname});
    }

    public void list_all_venda(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM venda", null);
        textView.setText("");
        while(cursor.moveToNext()){
            textView.append(cursor.getString(0)+" "+cursor.getString(1)+"\n");

        }
    }

    // metodos da tabela venda

    // metodos da tabela agenda


    // metodos da tabela itemvenda

    public String  insert_itemvenda(String produto, String venda ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NPRODUTO, produto);
        contentValues.put(NVENDA, venda);
        long result = db.insert("ITEMVENDA",null,contentValues);
        if(result != -1){
            return "ok";
        }else{
            return "erro";
        }
    }

    public void delete_itemvenda(String idItemvenda){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE_ITEMVENDA, "ID = ?",new String[]{idItemvenda});


    }

    public void update_itemvenda(String idItemVenda, String new_produto, String new_venda){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NPRODUTO, new_produto);
        contentValues.put(NVENDA, new_venda);
        db.update(DB_TABLE_ITEMVENDA,contentValues,"ID = ?",new String[]{idItemVenda});
    }

    public void listaitemvenda(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM Itemvenda", null);
        textView.setText("");
        while(cursor.moveToNext()){
            textView.append(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+"\n");

        }
    }



    // metodos da tabela reuniao








}
