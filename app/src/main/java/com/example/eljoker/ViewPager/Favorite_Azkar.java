package com.example.eljoker.ViewPager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.eljoker.ViewPager.Adapters.FavoriteAdhkarAdapter;
import com.example.eljoker.zadelmuslim.Models.FavModel;

import java.util.ArrayList;

public class Favorite_Azkar extends AppCompatActivity
{
    int id;
    RecyclerView rec_fav;
    ArrayList<FavModel> arrayList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite__azkar);
        FavoriteAdhkarAdapter favorite_adhkar_adapter = new FavoriteAdhkarAdapter(this, arrayList);
        rec_fav = findViewById(R.id.rec_fav);
        rec_fav.setItemAnimator(new DefaultItemAnimator());
        rec_fav.setAdapter(favorite_adhkar_adapter);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(rec_fav.getContext(), linearLayoutManager.getOrientation());
        rec_fav.setHasFixedSize(true);
        rec_fav.setLayoutManager(linearLayoutManager);
        rec_fav.addItemDecoration(dividerItemDecoration);

        DataBase db = new DataBase(this);
        arrayList.addAll(db.isFavorite());
        favorite_adhkar_adapter.notifyDataSetChanged();

        //arrayList.add(FavModel.setZekr(db.isFavorite()));
        //favorite_adhkar_adapter.notifyAll();


    }

    public void back(View view)
    {
        Intent intent = new Intent(this, Azkar_Main.class);
        startActivity(intent);
    }
}
