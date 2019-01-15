package com.example.tafsir.kungfupanda;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listDataActivity extends AppCompatActivity {

    private ListView listView;
    private databaseHelper2 DatabaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);


        listView = (ListView) findViewById(R.id.listViewProductid);
        DatabaseHelper2 = new databaseHelper2(this);
        loadData();
    }


    public void loadData()
    {
        ArrayList<String> listData = new ArrayList<>();

        Cursor cursor = DatabaseHelper2.showAllData();

        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"No data is available in Database",Toast.LENGTH_LONG).show();

        }

        else
        {

                while (cursor.moveToNext())
                {
                    listData.add(cursor.getString(0)+" \t" +cursor.getString(1));
                }

            }
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.textViewListid,listData);
            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedValue = adapter.getItem(position).toString();
                    Toast.makeText(getApplicationContext(),"Selected Value : "+selectedValue,Toast.LENGTH_LONG).show();
                }
            });







        }
    }



