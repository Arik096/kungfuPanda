package com.example.tafsir.kungfupanda;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username,password;
    private Button login,signUp;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.userNameLogId);
        password = (EditText) findViewById(R.id.passwordLogId);
        login = (Button) findViewById(R.id.loginLogId);
        signUp = (Button) findViewById(R.id.signupLogId);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        login.setOnClickListener(this);
        signUp.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        String UserInfo = username.getText().toString();
        String PassWordInfo = password.getText().toString();







        if(v.getId()==R.id.loginLogId)

        {





            Boolean result = databaseHelper.findPassword(UserInfo,PassWordInfo);

            if(result == true)
            {
                Intent intent = new Intent(loginActivity.this,originalPage.class);
                startActivity(intent);
            }

            else
            {
                Toast.makeText(getApplicationContext(),"Username and Password didn't match",Toast.LENGTH_LONG).show();
            }




        }

        else if(v.getId()==R.id.signupLogId)
        {
            Intent intent = new Intent(loginActivity.this,signupActivity.class);
            startActivity(intent);
        }

    }
}
