package com.example.eljoker.ViewPager.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.eljoker.ViewPager.DataBase;
import com.example.eljoker.ViewPager.R;
import com.example.eljoker.zadelmuslim.Models.FavModel;

import java.util.ArrayList;

public class FavoriteAdhkarAdapter extends RecyclerView.Adapter<FavoriteAdhkarAdapter.MyHolder>
{
    Context cnx;
    final ArrayList <FavModel> arrayList;
    public static String favName;
    DataBase db;

    public FavoriteAdhkarAdapter(Context cnx, ArrayList<FavModel> arrayList)
    {
        this.cnx = cnx;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(cnx);
        View v = inflater.inflate(R.layout.favorite_row_item, viewGroup, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int position)
    {
        final FavModel FavModel = arrayList.get(position);
        db = new DataBase(cnx);

        myHolder.favorite_txt.setText(FavModel.getZekr());
        favName = (String) myHolder.favorite_txt.getText();
        System.out.println("favName " + favName);


        myHolder.favorite_img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                myHolder.favorite_border_img.setVisibility(View.VISIBLE);
                myHolder.favorite_img.setVisibility(View.GONE);

                DataBase db = new DataBase(cnx);

                db.removeFromFavorite(favName);
            }
        });

        myHolder.setItemClickListener(new ItemClickListener()
        {
            @Override
            public void onClick(View view, int position)
            {

/*
                Intent intent = new Intent(cnx, Azkar_View_Pager2.class);
                // send azkar model to Azkar_View_Pager activity

*/
/*
                AzkarModel azkarModel = new AzkarModel();
                intent.putExtra("azkar_model", azkarModel);
                intent.putExtra("name", azkarModel.getName());
*//*

                intent.putExtra("name", FavModel.getZekr());
                cnx.startActivity(intent);
*/
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
        ImageView favorite_img, favorite_border_img;
        TextView favorite_txt;
        RelativeLayout rl_favorites;
        ItemClickListener itemClickListener;

        public MyHolder(@NonNull View itemView)
        {
            super(itemView);
            favorite_img = itemView.findViewById(R.id.favorite_img);
            favorite_border_img = itemView.findViewById(R.id.favorite_border_img);
            favorite_txt = itemView.findViewById(R.id.favorite_txt);
            rl_favorites = itemView.findViewById(R.id.rl_favorites);
            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }


        @Override
        public void onClick(View view)
        {
            itemClickListener.onClick(view, getAdapterPosition());

        }
    }
}
