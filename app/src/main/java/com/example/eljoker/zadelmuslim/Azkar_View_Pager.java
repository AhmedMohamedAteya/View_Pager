
package com.example.eljoker.zadelmuslim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.eljoker.zadelmuslim.Models.AzkarModel;
import com.example.eljoker.zadelmuslim.Models.LeafNode;

import java.util.ArrayList;


public class Azkar_View_Pager extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    ArrayList<AzkarModel> azkar_models;
    ArrayList<LeafNode> leafNodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar__view__pager);
        azkar_models = new ArrayList<>();
        leafNodes = new ArrayList<>();
        Intent intent = getIntent();

        for (int i = 0; i < 10; i++) {
            leafNodes.add(new LeafNode( intent.getStringExtra("value") + i,
                    intent.getStringExtra("desc") + i));
        }
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), azkar_models);

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_azkar__view__pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void back(View view) {
        Intent intent = new Intent(this, com.example.eljoker.zadelmuslim.Azkar_Main.class);
        startActivity(intent);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            RelativeLayout relativeLayout_ViewPager, relative_value;
            View rootView = inflater.inflate(R.layout.fragment_azkar__view__pager, container, false);


            /*TextView azkar_View_Pager_title, txt_value, txt_description, txt_iteration;

            azkar_View_Pager_title = rootView.findViewById(R.id.azkar_View_Pager_title);
            txt_value = rootView.findViewById(R.id.value);
            txt_description = rootView.findViewById(R.id.description);
            txt_iteration = rootView.findViewById(R.id.iteration);

            String id, name, value, desc, itiration
                   *//* name_autoComplete, value_autoComplete,
                    desc_autoComplete, itiration_autoComplete*//*;
            Intent intent = getActivity().getIntent();
            id = intent.getStringExtra("id");
            name = intent.getStringExtra("name");
            //value = intent.getStringExtra("value");
            value = getArguments().getString("value");
            desc = intent.getStringExtra("desc");
            itiration = intent.getStringExtra("itiration");

            System.out.println("id ==" + id);
            System.out.println("name ==" + name);
            //System.out.println("value ==" + value);
            System.out.println("desc ==" + desc);
            System.out.println("itiration ==" + itiration);
            azkar_View_Pager_title.setText(name);
            txt_value.setText(value);
            txt_description.setText(desc);
            txt_iteration.setText(itiration);
*/

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        //ArrayList<LeafNode> list = new ArrayList<>();
        ArrayList<AzkarModel> azkar_models;
        ArrayList<LeafNode> leafNodes;

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<AzkarModel> azkar_models) {
            super(fm);
            this.azkar_models = azkar_models;
        }

        @Override
        public Fragment getItem(int position) {

            String value = leafNodes.get(position).getValue() + "  Desc = " + leafNodes.get(position).getDescription();

            PlaceholderFragment placeholderFragment = new PlaceholderFragment();
            Bundle bundle = new Bundle();
            bundle.putString("value", value);
            placeholderFragment.setArguments(bundle);

            return placeholderFragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            Intent intent = getIntent();
            int leafNode = intent.getIntExtra("leafNode",5);
            return leafNode;
        }
    }
}