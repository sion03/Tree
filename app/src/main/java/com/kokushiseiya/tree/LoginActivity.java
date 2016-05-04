package com.kokushiseiya.tree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by YK on 16/05/04.
 */
public class LoginActivity extends Activity {
    EditText userName;
    EditText passWord;
    String nameKey;
    String passKey;
    SharedPreferences key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText)findViewById(R.id.userName_edit);
        passWord = (EditText)findViewById(R.id.passWord_edit);
    }

    public void signUp(View v){
        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }

    public void logIn(View v){
        String userName_login = userName.getText().toString();
        String passWord_login = passWord.getText().toString();

        key = getSharedPreferences("key", Context.MODE_PRIVATE);
        nameKey = key.getString("userName_key", "null");
        passKey = key.getString("passWord_key", "null");

        if (!nameKey.equals(userName_login) || !passKey.equals(passWord_login)){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }else if (nameKey.equals(userName_login) && passKey.equals(passWord_login)){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
