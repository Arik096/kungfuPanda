package com.example.tafsir.kungfupanda;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    DatabaseHelper databaseHelper;
    private Button login,signup,main,purchace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        login = (Button) findViewById(R.id.loginButtonId);
        signup = (Button) findViewById(R.id.signupButtonId);
        main = (Button) findViewById(R.id.mainId);
        purchace = (Button) findViewById(R.id.purchaceId);


        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        main.setOnClickListener(this);
        purchace.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.loginButtonId)
        {
            Intent intent = new Intent(MainActivity.this,loginActivity.class);
            startActivity(intent);

        }

        else if(v.getId()==R.id.signupButtonId)
        {

            Intent intent = new Intent(MainActivity.this,signupActivity.class);
            startActivity(intent);

        }

        else if(v.getId()==R.id.mainId)
        {

            Intent intent = new Intent(MainActivity.this,originalPage.class);
            startActivity(intent);

        }

        else if(v.getId()==R.id.purchaceId)
        {

            Intent intent = new Intent(MainActivity.this,buyProductActivity.class);
            startActivity(intent);

        }

    }
}
