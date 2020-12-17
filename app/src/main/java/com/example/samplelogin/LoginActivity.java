package com.example.samplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setListenerWithView();


    }

    private void setListenerWithView() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                boolean checkuserpass=db.checkuserpass(name,password);
                if (checkuserpass==true)
                    Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "wrong email or password", Toast.LENGTH_SHORT).show();

              /*  if (email.equals("") || password.equals(""))
                    Toast.makeText(LoginActivity.this, "Enter All the field", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkuserpass = db.checkuserpass(email, password);
                    if (checkuserpass == true) {
                        Toast.makeText(getApplicationContext(), "login Successfully", Toast.LENGTH_SHORT).show();
                       // Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                       // startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "password not match", Toast.LENGTH_SHORT).show();
                    }

                }
*/
            }
        });

    }

    private void initView() {
        db = new DatabaseHelper(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

    }
}