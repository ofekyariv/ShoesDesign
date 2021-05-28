package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static Item item=new Item(0,"",0,"",0);
    private TextView tv1;
    private Button btnback;

    private ImageButton snk_btn;
    private ImageButton heels_btn;
    private ImageButton magaf_btn;
    private ImageButton shortmagaf_btn;
    private ImageButton whitesnk_btn;
    private ImageButton nudeheels_btn;
    private ImageButton brounlongboots_btn;
    private ImageButton brownshortboots_btn;

    private TextView txtpricesnk;
    private TextView txtpriceheels;
    private TextView txtpricemagaf;
    private TextView txtpriceshortmagaf;
    private TextView txtpricesnkwhite;
    private TextView txtpricenudeheels;
    private TextView txtpricebrownlongboots;
    private TextView txtpricebrownshortboots;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=findViewById(R.id.tv1);
        btnback= findViewById(R.id.btnback);

        snk_btn=findViewById(R.id.snkbutton);
        heels_btn=findViewById(R.id.heelsbtn);
        magaf_btn=findViewById(R.id.magaf);
        shortmagaf_btn=findViewById(R.id.shortmagaf);
        whitesnk_btn=findViewById(R.id.snkwhitebtn);
        brounlongboots_btn=findViewById(R.id.brownlongboots);
        brownshortboots_btn=findViewById(R.id.brownshortboots);
        nudeheels_btn=findViewById(R.id.nudeheelsbtn);

        txtpricesnk=findViewById(R.id.txtpricesnk);
        txtpriceheels=findViewById(R.id.txtpriceheels);
        txtpricemagaf=findViewById(R.id.txtpricemagaf);
        txtpriceshortmagaf=findViewById(R.id.txtpriceshortmagaf);
        txtpricesnkwhite=findViewById(R.id.txtpricesnkwhite);
        txtpricenudeheels=findViewById(R.id.txtpricenudeheels);
        txtpricebrownlongboots=findViewById(R.id.txtpricebrownlongboots);
        txtpricebrownshortboots=findViewById(R.id.txtpricebrownshortboots);

        snk_btn.setVisibility(View.VISIBLE);
        heels_btn.setVisibility(View.VISIBLE);
        magaf_btn.setVisibility(View.VISIBLE);
        shortmagaf_btn.setVisibility(View.VISIBLE);
        nudeheels_btn.setVisibility(View.GONE);
        whitesnk_btn.setVisibility(View.GONE);
        brounlongboots_btn.setVisibility(View.GONE);
        brownshortboots_btn.setVisibility(View.GONE);


    }

    public void clickBtn(View view)
    {
        if (view.getId() == R.id.btnback) {
            snk_btn.setVisibility(View.VISIBLE);
            heels_btn.setVisibility(View.VISIBLE);
            magaf_btn.setVisibility(View.VISIBLE);
            shortmagaf_btn.setVisibility(View.VISIBLE);
            nudeheels_btn.setVisibility(View.GONE);
            whitesnk_btn.setVisibility(View.GONE);
            brounlongboots_btn.setVisibility(View.GONE);
            brownshortboots_btn.setVisibility(View.GONE);

            txtpricesnk.setVisibility(View.VISIBLE);
            txtpriceheels.setVisibility(View.VISIBLE);
            txtpricemagaf.setVisibility(View.VISIBLE);
            txtpriceshortmagaf.setVisibility(View.VISIBLE);
            txtpricesnkwhite.setVisibility(View.INVISIBLE);
            txtpricenudeheels.setVisibility(View.INVISIBLE);
            txtpricebrownlongboots.setVisibility(View.INVISIBLE);
            txtpricebrownshortboots.setVisibility(View.INVISIBLE);

            tv1.setText("Select Your Type Of Shoes");
            btnback.setVisibility(View.INVISIBLE);
        }
        if (view.getId() == R.id.snkbutton) {
            if(heels_btn.getVisibility()==View.GONE)
            {
                Intent intent = new Intent(this, FinalProduct.class);
                startActivity(intent);
                item.setId(0);
                item.setName("Sneakers");
                item.setPrice(150);
            }
            else{
                snk_btn.setVisibility(View.VISIBLE);
                whitesnk_btn.setVisibility(View.VISIBLE);
                heels_btn.setVisibility(View.GONE);
                magaf_btn.setVisibility(View.GONE);
                nudeheels_btn.setVisibility(View.GONE);
                shortmagaf_btn.setVisibility(View.GONE);
                brounlongboots_btn.setVisibility(View.GONE);
                brownshortboots_btn.setVisibility(View.GONE);

                txtpricesnkwhite.setVisibility(View.VISIBLE);
                txtpriceheels.setVisibility(View.INVISIBLE);
                txtpricemagaf.setVisibility(View.INVISIBLE);
                txtpriceshortmagaf.setVisibility(View.INVISIBLE);

                tv1.setText("Select Your Shoes");
                btnback.setVisibility(View.VISIBLE);
            }

        }
        if(view.getId()==R.id.heelsbtn)
        {
            if(snk_btn.getVisibility()==View.GONE)
            {
                Intent intent = new Intent(this, FinalProduct.class);
                startActivity(intent);
                item.setId(1);
                item.setName("Heels");
                item.setPrice(250);
            }
            else
            {
                snk_btn.setVisibility(View.GONE);
                whitesnk_btn.setVisibility(View.GONE);
                heels_btn.setVisibility(View.VISIBLE);
                magaf_btn.setVisibility(View.GONE);
                nudeheels_btn.setVisibility(View.VISIBLE);
                shortmagaf_btn.setVisibility(View.GONE);
                brounlongboots_btn.setVisibility(View.GONE);
                brownshortboots_btn.setVisibility(View.GONE);

                txtpricenudeheels.setVisibility(View.VISIBLE);
                txtpricesnk.setVisibility(View.INVISIBLE);
                txtpricemagaf.setVisibility(View.INVISIBLE);
                txtpriceshortmagaf.setVisibility(View.INVISIBLE);

                tv1.setText("Select Your Shoes");
                btnback.setVisibility(View.VISIBLE);
            }

        }
        if(view.getId()==R.id.magaf)
        {
            if(snk_btn.getVisibility()==View.GONE)
            {
                Intent intent = new Intent(this, FinalProduct.class);
                startActivity(intent);
                item.setId(2);
                item.setName("Boot");
                item.setPrice(300);
            }
            else{
                snk_btn.setVisibility(View.GONE);
                whitesnk_btn.setVisibility(View.GONE);
                heels_btn.setVisibility(View.GONE);
                magaf_btn.setVisibility(View.VISIBLE);
                nudeheels_btn.setVisibility(View.GONE);
                shortmagaf_btn.setVisibility(View.GONE);
                brounlongboots_btn.setVisibility(View.VISIBLE);
                brownshortboots_btn.setVisibility(View.GONE);

                txtpricebrownlongboots.setVisibility(View.VISIBLE);
                txtpricesnk.setVisibility(View.INVISIBLE);
                txtpriceheels.setVisibility(View.INVISIBLE);
                txtpriceshortmagaf.setVisibility(View.INVISIBLE);

                tv1.setText("Select Your Shoes");
                btnback.setVisibility(View.VISIBLE);
            }
        }
        if(view.getId()==R.id.shortmagaf)
        {
            if(snk_btn.getVisibility()==View.GONE)
            {
                Intent intent = new Intent(this, FinalProduct.class);
                startActivity(intent);
                item.setId(3);
                item.setName("Short Boot");
                item.setPrice(220);
            }
            else{
                snk_btn.setVisibility(View.GONE);
                whitesnk_btn.setVisibility(View.GONE);
                heels_btn.setVisibility(View.GONE);
                magaf_btn.setVisibility(View.GONE);
                nudeheels_btn.setVisibility(View.GONE);
                shortmagaf_btn.setVisibility(View.VISIBLE);
                brounlongboots_btn.setVisibility(View.GONE);
                brownshortboots_btn.setVisibility(View.VISIBLE);

                txtpricebrownshortboots.setVisibility(View.VISIBLE);
                txtpricesnk.setVisibility(View.INVISIBLE);
                txtpriceheels.setVisibility(View.INVISIBLE);
                txtpricemagaf.setVisibility(View.INVISIBLE);

                tv1.setText("Select Your Shoes");
                btnback.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.shopping_list){
            Intent intent = new Intent(SecondActivity.this, List.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.share_item){
            Toast.makeText(this, "share item chosen", Toast.LENGTH_SHORT).show();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        return true;
    }
    public void start1  (View view)
    //Move to another screen at the touch of a button
    {
        if(view.getId()==R.id.brownshortboots)
        {
            item.setId(4);
            item.setName("Brown Short Boots");
            item.setPrice(240);
        }
        if(view.getId()==R.id.snkwhitebtn)
        {
            item.setId(5);
            item.setName("White Sneakers");
            item.setPrice(170);
        }
        if(view.getId()==R.id.nudeheelsbtn)
        {
            item.setId(6);
            item.setName("Nude heels");
            item.setPrice(270);
        }
        if(view.getId()==R.id.brownlongboots)
        {
            item.setId(7);
            item.setName("Brown Long Boots");
            item.setPrice(320);
        }
            Intent intent = new Intent(this, FinalProduct.class);
            startActivity(intent);
    }
}

