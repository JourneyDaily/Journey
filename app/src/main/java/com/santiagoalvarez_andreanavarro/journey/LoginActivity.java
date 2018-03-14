package com.santiagoalvarez_andreanavarro.journey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Santiago on 9/03/2018.
 */

public class LoginActivity extends AppCompatActivity {

    TextView tvRegister;
    EditText etUser, etPass;
    String user, pass,name,lastname,email;
    Button btAcept;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        Bundle extra = getIntent().getExtras();
        if (extra==null){
            user="1237842543420389702932874603894503487512890309";
        }else {
            user = extra.getString("user");
            pass = extra.getString("pass");

        }


        tvRegister = findViewById(R.id.tvRegister);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btAcept = findViewById(R.id.btAcept);

    }

    public void register(View view) {
        int id = view.getId();

        if(id == R.id.tvRegister){
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivityForResult(intent,1234);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1234 && resultCode == RESULT_OK){

            //etUser.setText(String.valueOf(data.getExtras().getString("user")));
            //etPass.setText(String.valueOf(data.getExtras().getString("pass")));
            user = String.valueOf(data.getExtras().getString("user"));
            pass = String.valueOf(data.getExtras().getString("pass"));
            name = String.valueOf(data.getExtras().getString("name"));
            lastname = String.valueOf(data.getExtras().getString("lastname"));
            email = String.valueOf(data.getExtras().getString("email"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void acept(View view) {
        int id = view.getId();

        if(id == R.id.btAcept){
            if ( user.equals(etUser.getText().toString())  &&  pass.equals(etPass.getText().toString())){
                //Actividad principal -> enviar datos a MainActivity para luego enviar a perfil
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("user", user);
                intent.putExtra("pass", pass);
                intent.putExtra("name",name);
                intent.putExtra("lastname",lastname);
                intent.putExtra("email",email);
                startActivity(intent);
            } else {
                //Toast
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
