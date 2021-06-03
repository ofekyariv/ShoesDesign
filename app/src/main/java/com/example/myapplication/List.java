package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Item> items;
    private ItemAdapter adapter;
    private ItemDataBase itemDataBase;
    private Button btnmain;
    private TextView totalCost;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listView);
        btnmain = findViewById(R.id.btnmain);
        itemDataBase = new ItemDataBase(this);
        items = itemDataBase.getAllRecords();
        int total = itemDataBase.getTotalCost();
        adapter = new ItemAdapter(this, items);
        listView.setAdapter(adapter);
        totalCost = findViewById(R.id.title_tv2);
        totalCost.setText("Total Price: "+total+"$");
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alert = new AlertDialog.Builder(List.this);
                alert.setTitle("delete item");
                alert.setMessage("are you sure you want to delete shoe?");
                alert.setIcon(R.drawable.x);
                alert.setCancelable(false);

                alert.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //do something
                        itemDataBase.deleteByRow(items.get(position).getId());
                        ItemDataBase.getItems().remove(position);
                        adapter.notifyDataSetChanged();
                        dialogInterface.dismiss();
                    }
                });
                alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alert.create();
                alert.show();
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}