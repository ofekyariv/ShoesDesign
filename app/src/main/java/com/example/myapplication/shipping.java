package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Date;

import static com.example.myapplication.SecondActivity.item;

public class shipping extends AppCompatActivity {

    private CalendarView date;
    private EditText et_size;
    private ItemDataBase itemDataBase;
    String txtdate = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        et_size=findViewById(R.id.etsize);
        date=findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        txtdate = calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
        date.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                txtdate = dayOfMonth+"/"+month+"/"+year;
            }
        });
    }
    public void BtnBack(View view)
    {
        if (view.getId() == R.id.btnback) {
            Intent intent= new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
    }
    public void next(View view) {
        int size=0;
        try{
            size = Integer.parseInt(et_size.getText().toString());
        }
        catch (Exception ignored){}
        if(size>=32&&size<=57){
            item.setDate(txtdate);
            item.setSize(size);
            itemDataBase = new ItemDataBase(shipping.this);
            itemDataBase.setRecord(item);
            Intent intent= new Intent(this, List.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(shipping.this,"Invalid Size",Toast.LENGTH_SHORT).show();
        }
    }
}