package com.example.room_database.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room_database.EntityClass.ProductModel;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insertAllData(ProductModel model);

    @Query("select * from product")
    List<ProductModel> getAllData();

    @Query("delete from product where `key` = :id")
    void deleteData(int id);

//    @Query("update product SET name= :name ,price = :price where `key`= :key")
//    void updateData(String name, String price, int key);

}
