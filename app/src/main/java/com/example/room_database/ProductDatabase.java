package com.example.room_database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.room_database.DaoClass.ProductDao;
import com.example.room_database.EntityClass.ProductModel;

@Database(entities = {ProductModel.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    public abstract ProductDao getDao();

    private static ProductDatabase instance;

    static ProductDatabase getProductDatabase(final Context context) {
        if (instance == null) {
            synchronized (ProductDatabase.class) {
                instance = Room.databaseBuilder(context, ProductDatabase.class, "DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
