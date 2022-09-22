package com.example.room_database.EntityClass;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class ProductModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price")
    private String price;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
