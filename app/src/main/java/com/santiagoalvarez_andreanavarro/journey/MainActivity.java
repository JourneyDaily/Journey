package com.santiagoalvarez_andreanavarro.journey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String user="*",name,lastname,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        user = getIntent().getExtras().getString("user");
        name = getIntent().getExtras().getString("name");
        lastname = getIntent().getExtras().getString("lastname");
        email = getIntent().getExtras().getString("email");*/


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.mProfile){
            user = getIntent().getExtras().getString("user");
            name = getIntent().getExtras().getString("name");
            lastname = getIntent().getExtras().getString("lastname");
            email = getIntent().getExtras().getString("email");
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("user", user);
            intent.putExtra("name",name);
            intent.putExtra("lastname",lastname);
            intent.putExtra("email",email);
            startActivity(intent);
        }
        if(id == R.id.mExit){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

