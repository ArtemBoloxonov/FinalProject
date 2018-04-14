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
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.Predmiti ,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinner3);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);

//                if (item == "Бюджет" || item == "Неважно") {
//                    Spinner spin = findViewById(R.id.spinner4);
//                    spin.setVisibility(View.GONE);
//                    spin.setEnabled(false);
//                    /*if(item == "Бюджет") {
//                        //Тут фильтр на базу данных
//                    } else {
//                        //Тут фильтр на базу данных
//                    }*/
//                }
//                if (item == "Коммерческое") {
//                    Spinner spin = findViewById(R.id.spinner4);
//                    spin.setAlpha(1);
//                    //Тут фильтр на базу данных

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


}
}
