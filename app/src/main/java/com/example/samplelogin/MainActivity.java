package com.example.samplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    private EditText editTextName;
    private EditText editTextMonumber;
    private EditText editTexEmail;
    private EditText editTextPassword;
    private Button buttonRegister;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        setViewWithListener();
    }

    private void initLayout() {
        db = new DatabaseHelper(this);
        editTextName = findViewById(R.id.editTextName);
        editTextMonumber = findViewById(R.id.editTextMoNumber);
        editTexEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.buttonLogin);

    }

    private void setViewWithListener() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData
                        (editTextName.getText().toString(),
                        editTextMonumber.getText().toString(),
                        editTexEmail.getText().toString(),
                        editTextPassword.getText().toString());
                if (isInserted = true)
                    Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "REgistration failed", Toast.LENGTH_SHORT).show();

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}