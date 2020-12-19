package com.example.samplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    private void initView() {
        db = new DatabaseHelper(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

    }

    private void setListenerWithView() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // checkUserName();

                String name = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                boolean checkuserpass = db.checkuserpass(name, password);
                if (checkuserpass == true) {
                    Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                        Toast.makeText(getApplicationContext(), "wrong name or password", Toast.LENGTH_SHORT).show();
                     }

            }
        });
    }
}


  /*  boolean isName(EditText text){
        CharSequence Name = text.getText().toString();
        return (!TextUtils.isEmpty(Name));
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
*/

          /*  private void checkUserName() {

                boolean isValid =true;
                if (isEmpty(username)){
                    username.setError("you must enter username to login");
                            isValid=false;
                }else{
                    if (!isName(username)){
                        username.setError("Enter valid name");
                                isValid=false;
                    }
                } if (isEmpty(password)){
                    password.setError("you must enter password to login");
                            isValid=false;
                }else{
                    if (!isName(password)){
                        password.setError("Enter valid password");
                                isValid=false;
                    }
                }

                if (isValid){
                    String usernamevalue=user
                }
            }
        });*/








