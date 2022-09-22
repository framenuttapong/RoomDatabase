//package com.example.room_database;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class UpdateData extends AppCompatActivity {
//
//    EditText name, price;
//    Button update;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_updatedata);
//
//        name = findViewById(R.id.name);
//        price = findViewById(R.id.price);
//        update = findViewById(R.id.btn_update);
//
//        name.setText(getIntent().getExtras().getString("name"));
//        price.setText(getIntent().getExtras().getString("price"));
//        final String id = getIntent().getExtras().getString("id");
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name_txt = name.getText().toString().trim();
//                String price_txt = price.getText().toString().trim();
//                if(name_txt.equals("") || price_txt.equals("")){
//                    Toast.makeText(UpdateData.this, "All Field is required ....", Toast.LENGTH_SHORT).show();
//                } else {
//                    ProductDatabase.getProductDatabase(getApplicationContext()).getDao().updateData(name_txt, price_txt, Integer.parseInt(id));
//                }
//            }
//        });
//    }
//}
