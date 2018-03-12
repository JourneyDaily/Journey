package com.santiagoalvarez_andreanavarro.journey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Santiago on 9/03/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    Button btSignup;
    EditText etLogin, etPass;
    String pass, user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        btSignup = findViewById(R.id.btSignup);
        etLogin = findViewById(R.id.etLogin);
        etPass = findViewById(R.id.etPass);
    }

    public void signup(View view) {

        pass = etPass.getText().toString();
        user = etLogin.getText().toString();

        Intent intent = new Intent();//No le digo donde estoy ni para donde voy
        intent.putExtra("user", user);
        intent.putExtra("pass", pass);
        setResult(RESULT_OK,intent);
        finish();
    }
}
