package com.example.room_database.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_database.EntityClass.ProductModel;
import com.example.room_database.GetData;
import com.example.room_database.R;
//import com.example.room_database.UpdateData;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Context context;
    List<ProductModel> list;
    DeleteItemClicklistner deleteItemClicklistner;

    public ProductAdapter(Context context, List<ProductModel> list, DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, final int position) {
        ProductModel product = list.get(position);
        holder.id.setText(""+product.getKey());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemClicklistner.onItemDelete(position, list.get(position).getKey());
            }
        });

//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, UpdateData.class);
//                intent.putExtra("id",String.valueOf(list.get(position).getKey()));
//                intent.putExtra("name",String.valueOf(list.get(position).getName()));
//                intent.putExtra("price",String.valueOf(list.get(position).getPrice()));
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView id,name,price;
        Button update,delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.productID);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            delete = itemView.findViewById(R.id.deleteId);
//            update = itemView.findViewById(R.id.updateId);
        }
    }

    public interface DeleteItemClicklistner {
        void onItemDelete(int position, int id);
    }
}
