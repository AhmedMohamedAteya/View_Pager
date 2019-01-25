package com.example.eljoker.ViewPager;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.eljoker.ViewPager.Adapters.Adhkar_Adapter;
import com.example.eljoker.ViewPager.Models.AzkarModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Azkar_Main extends AppCompatActivity
        //implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nView;
    RecyclerView rv;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azkar_main);

        rv = findViewById(R.id.azkar_rv);

        //parse data
        //get Azkar Name From Json
        ArrayList<AzkarModel> arrayList = new ArrayList<>();
        String json = null;
        try {
            InputStream is = getAssets().open("Azkar.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        ArrayList<AzkarModel> azkarModel = gson.fromJson(json, new TypeToken<List<AzkarModel>>() {}.getType());

        Adhkar_Adapter adhkar_adapter = new Adhkar_Adapter(this, azkarModel);
        assert azkarModel != null;
        Log.i(this.toString(), azkarModel.get(0).getSubNodes().size() + "");
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adhkar_adapter);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(rv.getContext(), linearLayoutManager.getOrientation());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.addItemDecoration(dividerItemDecoration);
        adhkar_adapter.notifyDataSetChanged();


    }

/*
    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        selectDrawerItem(menuItem);
                        return true;
                    }

                });
    }
*/

/*
    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = findViewById(R.id.Drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void selectDrawerItem(MenuItem menuItem)
    {
        //Intent intent;

        switch(menuItem.getItemId())
        {
            case R.id.adhkar:
                Intent adhkar = new Intent(this, Azkar_Main.class);
                startActivity(adhkar);
                break;

        }

        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
*/
/*
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search, menu);

        // Get the search menu.
        MenuItem searchMenu = menu.findItem(R.id.auto_search);

*//*

        // Get SearchView object.
*/
/*
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView)
                MenuItemCompat.getActionView(searchMenu);
*//*


        // Get SearchView autocomplete object.

*/
/*
        final android.support.v7.widget.SearchView.SearchAutoComplete searchAutoComplete =
                (android.support.v7.widget.SearchView.SearchAutoComplete)searchView.
                        findViewById(android.support.v7.appcompat.
                        R.id.search_src_text);
*//*

 */
/*
        searchAutoComplete.setBackgroundColor(Color.BLUE);
        searchAutoComplete.setTextColor(Color.GREEN);
        searchAutoComplete.setDropDownBackgroundResource(android.R.color.holo_blue_light);
*//*


        // Create a new ArrayAdapter and add data to search auto complete object.
        String dataArr[] = {"أذكار الصباح والمساء" , "الأذكار الخاصة بالصباح" ,
                "الأذكار الخاصة بالمساء", "أذكار عامة", "أذكار النوم",
                "بعض الآداب عند النوم", "إذا رأى في منامه ما يحب",
                "إذا رأى ما يكره في منامه"};
        ArrayAdapter<String> newsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataArr);
*/
/*
        searchAutoComplete.setAdapter(newsAdapter);

        // Listen to search view item on click event.
        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long id)
            {
                Object position = adapterView.getItemAtPosition(itemIndex);
                System.out.println("position == " + position);
                System.out.println("itemIndex == " + itemIndex);
                *//*

 */
/*azkar_model azkar_model = new azkar_model();
                Intent intent = new Intent(Azkar_Main.this, Azkar_View_Pager.class);

                String name_autoComplete = azkar_model.getItems();
                System.out.println("name_autoComplete" + name_autoComplete);
                String value_autoComplete = azkar_model.getValue();
                String desc_autoComplete = azkar_model.getDescription();
                String itiration_autoComplete = azkar_model.getIteration();
                int leafNode_autoComplete = azkar_model.getLeafNode();
                intent.putExtra("name_autoComplete", name_autoComplete);
                intent.putExtra("value_autoComplete", value_autoComplete);
                intent.putExtra("desc_autoComplete", desc_autoComplete);
                intent.putExtra("itiration_autoComplete", itiration_autoComplete);
                intent.putExtra("leafNode_autoComplete", leafNode_autoComplete);*//*
 */
    /*


     *//*

 */
/*Bundle bundle = new Bundle();

                bundle.putString("AutoComplete_name", adapterView.getItemAtPosition(itemIndex).toString());
                bundle.putLong("_id", id);
                intent.putExtras(bundle);*//*
 */
/*

                //startActivity(intent);
*//*

 */
/*
                String queryString=(String)adapterView.getItemAtPosition(itemIndex);
                searchAutoComplete.setText("" + queryString);
                Toast.makeText(Azkar_Main.this, "you clicked " + queryString, Toast.LENGTH_LONG).show();
*//*
 */
/*

            }
        });
*//*


        // Below event is triggered when submit search query.
*/
/*
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                AlertDialog alertDialog = new AlertDialog.Builder(Azkar_Main.this).create();
                alertDialog.setMessage("Search keyword is " + query);
                alertDialog.show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
*//*


        return super.onCreateOptionsMenu(menu);
    }
*/
}