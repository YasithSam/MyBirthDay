package com.example.mybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String  id;
    int year,days;
    int month[] ={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    EditText etId;
    int  idNum;
    Button btnFind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //defining elements
        etId =findViewById(R.id.etId);
        btnFind=findViewById(R.id.btnFind);
        // Edit Text Conversion
        id = etId.getText().toString();

      //  year= (idNum/1000)/1000;
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth();
            }
        });







    }
    public int getYear() {
        return (1900 + Integer.parseInt(id.substring(0, 2)));
    }

    public int getDays() {
        try {
            int d = Integer.parseInt(id.substring(1, 5));
            if (d > 500) {
                return (d - 500);
            } else {
                return d;
            }
        }catch (NumberFormatException e){
            int d=0;
            return d;
        }
    }
    public void setMonth() {
        int mo = 0,date=0;

        days=getDays();



        for (int i = 0; i < month.length; i++) {
            if (days < month[i]) {
                mo = i + 1;
                date = days;
                break;
            } else {
                days = days - month[i];
            }
        }
        Toast.makeText(this, "Month"+mo, Toast.LENGTH_SHORT).show();

    }


}
