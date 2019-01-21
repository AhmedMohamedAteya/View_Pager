package com.example.eljoker.zadelmuslim.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eljoker.zadelmuslim.Azkar_View_Pager;
import com.example.eljoker.zadelmuslim.Models.azkar_model;
import com.example.eljoker.zadelmuslim.R;

import java.util.ArrayList;

public class Adhkar_Adapter extends RecyclerView.Adapter<Adhkar_Adapter.MyHolder>
{
    Context cnx;
    ArrayList<azkar_model> arrayList;


    public Adhkar_Adapter(Context cnx, ArrayList<azkar_model> arrayList)
    {
        this.cnx = cnx;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(cnx);
        View v = inflater.inflate(R.layout.adhkar_row_item, viewGroup, false);
        Adhkar_Adapter.MyHolder holder = new Adhkar_Adapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder viewHolder, final int position)
    {
        final azkar_model azkar_model = arrayList.get(position);
        viewHolder.azkar_txt.setText(azkar_model.getItems());
        viewHolder.azkar_favorite_border_img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                viewHolder.azkar_favorite_border_img.setVisibility(View.GONE);
                viewHolder.azkar_favorite_img.setVisibility(View.VISIBLE);


            }
        });

        viewHolder.azkar_favorite_img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                viewHolder.azkar_favorite_border_img.setVisibility(View.VISIBLE);
                viewHolder.azkar_favorite_img.setVisibility(View.GONE);
            }
        });

        //change fontSize

        viewHolder.setItemClickListener(new ItemClickListener()
        {
            @Override
            public void onClick(View view, int position)
            {

                Intent intent = new Intent(cnx, Azkar_View_Pager.class);
                String id = azkar_model.getId();
                String name = azkar_model.getItems();
                String value = azkar_model.getValue();
                String desc = azkar_model.getDescription();
                String itiration = azkar_model.getIteration();
                //int leafNode = azkar_model.getLeafNode();
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("value", value);
                intent.putExtra("desc", desc);
                intent.putExtra("itiration", itiration);
                //intent.putExtra("leafNode", leafNode);
                cnx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView azkar_favorite_img, azkar_favorite_border_img;
        TextView azkar_txt;
        ItemClickListener itemClickListener;

        public MyHolder(@NonNull View itemView)
        {
            super(itemView);
            azkar_favorite_img = itemView.findViewById(R.id.azkar_favorite_img);
            azkar_favorite_border_img = itemView.findViewById(R.id.azkar_favorite_border_img);
            azkar_txt = itemView.findViewById(R.id.azkar_txt);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v)
        {
            itemClickListener.onClick(v, getAdapterPosition());
        }

    }
}
