package com.example.javatd_simplified;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_next;
    EditText input;

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add=findViewById(R.id.add);
        btn_next=findViewById(R.id.next);
        input=findViewById(R.id.input);



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model;

                try {
                    model=new Model(input.getText().toString(), -1);
                    Toast.makeText(MainActivity.this, model.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error creating TDL", Toast.LENGTH_SHORT).show();
                    model=new Model("error", -1);
                }

                DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);

                boolean success= dataBaseHelper.addOne(model);

                Toast.makeText(MainActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();

                //model.setTd_item(input.getText().toString());


            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, NextScreen.class);
                startActivity(intent);
            }
        });


    }
}