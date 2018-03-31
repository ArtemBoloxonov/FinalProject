package com.example.user.finalproject;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Неважно");
        spinnerArray.add("Бюджетное");
        spinnerArray.add("Коммерческое");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        @SuppressLint("WrongViewCast") NoDefaultSpinner spinner = findViewById(R.id.spinner3);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                if (item == "Бюджет" || item == "Неважно") {
                    @SuppressLint("WrongViewCast") NoDefaultSpinner spin = findViewById(R.id.spinner4);
                    spin.setAlpha(0);
                    /*if(item == "Бюджет") {
                        //Тут фильтр на базу данных
                    } else {
                        //Тут фильтр на базу данных
                    }*/
                }
                if (item == "Коммерческое") {
                    @SuppressLint("WrongViewCast") NoDefaultSpinner spin = findViewById(R.id.spinner4);
                    spin.setAlpha(1);
                    //Тут фильтр на базу данных
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


}
}
