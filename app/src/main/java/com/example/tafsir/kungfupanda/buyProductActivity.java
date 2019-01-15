package com.example.tafsir.kungfupanda;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class buyProductActivity extends AppCompatActivity implements View.OnClickListener {

    private databaseHelper2 DatabaseHelper2;
    private EditText nameEditText,idEditText;
    private Button saveButton,showButton,updateButton,deleteButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);



        DatabaseHelper2 = new databaseHelper2(this);
        SQLiteDatabase sqLiteDatabase = DatabaseHelper2.getWritableDatabase();



        nameEditText = (EditText) findViewById(R.id.productNameEditTextid);
        idEditText = (EditText) findViewById(R.id.productIdEditTextid);

        saveButton = (Button) findViewById(R.id.saveButtonId);
        showButton = (Button) findViewById(R.id.showButtonId);
        updateButton = (Button) findViewById(R.id.updateButtonId);
        deleteButton = (Button) findViewById(R.id.deleteButtonId);

        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();

        if(v.getId()==R.id.saveButtonId)
        {

            if(id.equals("") && name.equals(""))
            {

                Toast.makeText(getApplicationContext(),"Please Enter All The Data",Toast.LENGTH_LONG).show();

            }

            else
            {
               long rowNumber = DatabaseHelper2.saveData(id,name);
               if(rowNumber > -1)
               {
                   Toast.makeText(getApplicationContext(),"Data is inserted Successfully",Toast.LENGTH_LONG).show();
                   idEditText.setText("");
                   nameEditText.setText("");
               }

               else
               {
                   Toast.makeText(getApplicationContext(),"Data is not inserted successfully",Toast.LENGTH_LONG).show();
               }
            }


        }

         else if(v.getId()==R.id.showButtonId)
        {

            Intent intent = new Intent(buyProductActivity.this,listDataActivity.class);
            startActivity(intent);


        }

        else if(v.getId()==R.id.updateButtonId)
        {


            Boolean isUpdated = DatabaseHelper2.updateData(id,name);

            if(isUpdated == true)
            {
                Toast.makeText(getApplicationContext(),"Data is updated",Toast.LENGTH_LONG).show();


            }

            else
            {
                Toast.makeText(getApplicationContext(),"Data is not updated",Toast.LENGTH_LONG).show();

            }


        }

        else if(v.getId()==R.id.deleteButtonId)
        {

            int value = DatabaseHelper2.deleteData(id);

            if(value<0)
            {
                Toast.makeText(getApplicationContext(),"Data is not deleted",Toast.LENGTH_LONG).show();

            }

            else
            {
                Toast.makeText(getApplicationContext(),"Data is Deleated",Toast.LENGTH_LONG).show();

            }


        }

    }
}
