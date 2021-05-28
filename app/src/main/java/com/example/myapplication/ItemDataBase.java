package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

public class ItemDataBase extends SQLiteOpenHelper {
    private static final String DATABASENAME = "item.db";
    private static final String TABLE_RECORD = "tblitem";
    private static final int DATABASEVERSION = 1;
    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_SIZE = "Size";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_PRICE = "Price";
    private static final String[] allColumns = {COLUMN_ID, COLUMN_NAME, COLUMN_SIZE, COLUMN_DATE ,COLUMN_PRICE};
    private static ArrayList<Item> items;

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static int getTotalCost(){
        int total = 0;
        for (Item item:items) {
            total+=item.getPrice();
        }
        return total;
    }

    private static final String CREATE_TABLE_CUSTOMER = "CREATE TABLE IF NOT EXISTS " +
            TABLE_RECORD + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT," +
            COLUMN_SIZE + " INTEGER," +
            COLUMN_DATE + " TEXT," +
            COLUMN_PRICE + " INTEGER );";

    private SQLiteDatabase database; // access to table

    public ItemDataBase(Context context) { // Context gives access to resource libary
        super(context, DATABASENAME, null, DATABASEVERSION);
        getAllRecords();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { // sqlLiteDataBase is created in db and creates a new table with .execSQL
        sqLiteDatabase.execSQL(CREATE_TABLE_CUSTOMER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORD);
        onCreate(sqLiteDatabase);
    }

    public void setRecord(Item item) {
        Item current = null;
        for (Item p: items)
        {
            if(p.getName().equalsIgnoreCase(item.getName()))
            {
                current=p;
                break;
            }
        }
        if(current==null)
            createRecord(item);
        else {
            updateByRow(current);
        }
    }

    public Item createRecord(Item record) {
        database = getWritableDatabase(); // get access to write the database
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, record.getId());
        values.put(COLUMN_NAME, record.getName());
        values.put(COLUMN_SIZE, record.getSize());
        values.put(COLUMN_DATE, record.getDate());
        values.put(COLUMN_PRICE, record.getPrice());
        database.insert(TABLE_RECORD, null, values);
        database.close();
        return record;
    }

    public ArrayList<Item> getAllRecords() {
        database = getReadableDatabase(); // get access to read the database
        items = new ArrayList<>();
        String sortOrder = COLUMN_ID + " ASC"; // sorting by score
        Cursor cursor = database.query(TABLE_RECORD, allColumns, null, null, null, null, sortOrder); // cursor points at a certain row
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                int size = cursor.getInt(cursor.getColumnIndex(COLUMN_SIZE));
                String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                int price = cursor.getInt(cursor.getColumnIndex(COLUMN_PRICE));
                Item record = new Item(id, name, size, date, price);
                items.add(record);
            }
        }
        database.close();
        Collections.sort(items);
        return items;
    }

    public void deleteByRow(long id) {
        database = getWritableDatabase(); // get access to read the data
        database.delete(TABLE_RECORD, COLUMN_ID + " = " + id, null);
        database.close(); // close the database
    }

    public void updateByRow(Item item) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, item.getId());
        values.put(COLUMN_NAME, item.getName());
        values.put(COLUMN_SIZE, item.getSize());
        values.put(COLUMN_DATE, item.getDate());
        values.put(COLUMN_PRICE, item.getPrice());
        database.update(TABLE_RECORD, values, COLUMN_ID + "=" + item.getId(), null);
        database.close();
    }
}


