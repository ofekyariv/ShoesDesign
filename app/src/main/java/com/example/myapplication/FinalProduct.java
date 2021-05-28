package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.myapplication.SecondActivity.item;


public class FinalProduct extends AppCompatActivity {
    private ImageView finalProduct;
    private Button tochaekout_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product);
        tochaekout_btn=findViewById(R.id.tochackoutbtn);
        finalProduct = findViewById(R.id.ivfinal);

        switch (item.getName()){
            case "Sneakers":
                finalProduct.setImageResource(R.drawable.sneakears);
                break;
            case "Heels":
                finalProduct.setImageResource(R.drawable.heels);
                break;
            case "Boot":
                finalProduct.setImageResource(R.drawable.magaf);
                break;
            case "Short Boot":
                finalProduct.setImageResource(R.drawable.white);
                break;
            case "White Sneakers":
                finalProduct.setImageResource(R.drawable.whitesnk);
                break;
            case "Nude heels":
                finalProduct.setImageResource(R.drawable.nudeheels);
                break;
            case "Brown Long Boots":
                finalProduct.setImageResource(R.drawable.brownlongboots);
                break;
            case "Brown Short Boots":
                finalProduct.setImageResource(R.drawable.brownmagaf);
                break;
            default:
                break;
        }
    }

    public void start(View view) {
        Intent intent= new Intent(this, shipping.class);
        startActivity(intent);
    }}