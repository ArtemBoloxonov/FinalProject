package com.example.user.finalproject;


import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.finalproject.DataBaseHelper;
import com.example.user.finalproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DataBaseHelper(this);
    }


    public void onClick(View view) {
        setContentView(R.layout.activity_main2);


    }
}
