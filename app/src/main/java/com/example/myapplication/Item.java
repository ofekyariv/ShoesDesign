package com.example.myapplication;

public class Item implements Comparable<Item> {
    private long id;
    private String name;
    private int size;
    private String date;
    private int price;

    public Item(long id ,String name, int size, String date, int price)
    {
        this.id=id;
        this.name=name;
        this.size=size;
        this.date=date;
        this.price=price;
    }
    public Long getId() {return id;}
    public void setId(long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public int getSize(){return size;}
    public void setSize(int size){this.size=size;}
    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}
    public int getPrice(){return price;}
    public void setPrice(int price){this.price=price;}

    @Override
    public int compareTo(Item o) {
        Item other = (Item) o;
        //return name.compareTo(other.name); //names comparison
        return other.getId() == this.id ? 1:0;
    }
}

