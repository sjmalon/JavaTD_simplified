package com.example.javatd_simplified;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class NextScreen extends AppCompatActivity {

    Button btn_add2;
    TextView tv;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_add2=findViewById(R.id.add2);
        tv=findViewById(R.id.et2);



        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHelper dataBaseHelper;

                Model model2 =new Model();
                /*String td_item2= model2.getTd_item();
                tv.setText(td_item2);

                 */

                dataBaseHelper=new DataBaseHelper(NextScreen.this);
                dataBaseHelper.getReadableDatabase();
                List<Model> everything = dataBaseHelper.getEverything();

                String everythingString=everything.toString();
                tv.setText(everythingString);

            }
        });

    }
}