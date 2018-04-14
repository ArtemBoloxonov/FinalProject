package com.example.user.finalproject;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class DataBaseHelper extends SQLiteOpenHelper {
    private Context ctn;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        ctn = context;
    }

    public DataBaseHelper (Context context){
        super(context, "database.db", null, 1);
        ctn = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE university (\n" +
                "    _id        INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                       UNIQUE\n" +
                "                       NOT NULL,\n" +
                "    Direction  STRING,\n" +
                "    Region     STRING,\n" +
                "    University STRING,\n" +
                "    Specialty  STRING,\n" +
                "    Subject    STRING,\n" +
                "    Mid_free   DOUBLE,\n" +
                "    Go_free    DOUBLE,\n" +
                "    Mid_cost   DOUBLE,\n" +
                "    Go_cost    DOUBLE,\n" +
                "    Price      DOUBLE\n" +
                ");";
        sqLiteDatabase.rawQuery(query, null);

        AssetManager assetManager = ctn.getAssets();

        try {
            InputStream inputStream = assetManager.open("result_____.csv");
            Scanner scanner = new Scanner(inputStream);
            int i = 0;
            while (scanner.hasNextLine()) {
                if(i < 2){
                    i++;
                    continue;
                }
                String line = scanner.next();
                String[] split = line.split("|");
                String sql = "INSERT INTO university (Direction, Region, University, Specialty, Subject, Mid_free, Go_free, Mid_cost, Go_cost, Price) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String Direction =  split[0];
                String Region = split[1];
                String University = split[2];
                String Specialty = split[3];
                String Subject = split[4];
                String Mid_free = split[5];
                String Go_free = split[6];
                String Mid_cost = split[7];
                String Go_cost = split[8];
                String Price = split[9];
                sqLiteDatabase.rawQuery(sql, new String[]{Direction, Region, University, Specialty,
                        Subject, Mid_free, Go_free, Mid_cost, Go_cost, Price});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void getData(){
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("select Direction, tretr from university WHERE price = 100", null);
        cursor.moveToNext();
        String string = cursor.getString(1);

    }
}
