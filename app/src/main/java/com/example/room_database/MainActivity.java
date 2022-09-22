package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room_database.EntityClass.ProductModel;

public class MainActivity extends AppCompatActivity {

    EditText name,price;
    Button save, getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        save = findViewById(R.id.btn_save);
        getData = findViewById(R.id.btn_getData);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GetData.class));
            }
        });
    }

    private void saveData() {

        String name_txt = name.getText().toString().trim();
        String price_txt = price.getText().toString().trim();

        ProductModel model = new ProductModel();
        model.setName(name_txt);
        model.setPrice(price_txt);
        ProductDatabase.getProductDatabase(getApplicationContext()).getDao().insertAllData(model);

        name.setText("");
        price.setText("");
        Toast.makeText(this,"Data Successfully Saved", Toast.LENGTH_SHORT).show();
    }
}