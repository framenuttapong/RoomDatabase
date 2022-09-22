package com.example.room_database;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_database.Adapter.ProductAdapter;
import com.example.room_database.EntityClass.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class GetData extends AppCompatActivity {

    RecyclerView recyclerview;

    private List<ProductModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);
        recyclerview = findViewById(R.id.recyclerview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        list = new ArrayList<>();
        list = ProductDatabase.getProductDatabase(getApplicationContext()).getDao().getAllData();
        recyclerview.setAdapter(new ProductAdapter(getApplicationContext(), list, new ProductAdapter.DeleteItemClicklistner() {
            @Override
            public void onItemDelete(int position, int id) {
                ProductDatabase.getProductDatabase(getApplicationContext()).getDao().deleteData(id);
                getData();
            }
        }));
    }
}
