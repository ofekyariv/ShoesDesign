package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item>list;

    public ItemAdapter(@NonNull Context context, ArrayList<Item>list) {
        super(context, R.layout.item,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView= inflater.inflate(R.layout.item,parent,false);

        TextView tvName = rowView.findViewById(R.id.tvname);
        tvName.setText(list.get(position).getName());
        TextView tvSize = rowView.findViewById(R.id.tvsize);
        tvSize.setText("Size: "+list.get(position).getSize());
        TextView tvdate = rowView.findViewById(R.id.tvdate);
        tvdate.setText(""+list.get(position).getDate());
        TextView tvprice = rowView.findViewById(R.id.tvprice);
        tvprice.setText("Price: "+list.get(position).getPrice()+"$");

        ImageView imageView=rowView.findViewById(R.id.imgShoes);
        if (list.get(position).getName().equalsIgnoreCase("Sneakers"))
        {imageView.setImageResource(R.drawable.sneakears);}
        if (list.get(position).getName().equalsIgnoreCase("Heels"))
        {imageView.setImageResource(R.drawable.heels);}
        if (list.get(position).getName().equalsIgnoreCase("Boot"))
        {imageView.setImageResource(R.drawable.magaf);}
        if (list.get(position).getName().equalsIgnoreCase("Short Boot"))
        {imageView.setImageResource(R.drawable.white);}
        if (list.get(position).getName().equalsIgnoreCase("White Sneakers"))
        {imageView.setImageResource(R.drawable.whitesnk);}
        if (list.get(position).getName().equalsIgnoreCase("Nude heels"))
        {imageView.setImageResource(R.drawable.nudeheels);}
        if (list.get(position).getName().equalsIgnoreCase("Brown Long Boots"))
        {imageView.setImageResource(R.drawable.brownlongboots);}
        if (list.get(position).getName().equalsIgnoreCase("Brown Short Boots"))
        {imageView.setImageResource(R.drawable.brownmagaf);}
        return rowView;
    }
}

