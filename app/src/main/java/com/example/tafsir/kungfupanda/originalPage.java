package com.example.tafsir.kungfupanda;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class originalPage extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_page);


        String[] product= {"Laptop","HardDisk","Ram","Graphics Card","CPU","Pendrive"};


        listView = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,product);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Fragment fragment;

        if(position==0)
        {
            fragment = new laptopFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();

        }

        else if(position==1)
        {

            fragment = new HardDiskFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();

        }

        else if(position==2)
        {

            fragment = new RamFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();

        }

        else if(position==3)
        {

            fragment = new GraphicsCardFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();

        }

        else if(position==4)
        {

            fragment = new CPUFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();

        }

        else if(position==5)
        {

            fragment = new PendriveFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();

        }



    }
}

