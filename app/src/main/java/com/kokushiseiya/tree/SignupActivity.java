package com.kokushiseiya.tree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by YK on 16/05/04.
 */
public class SignupActivity extends Activity{
    EditText userName;
    EditText passWord;
    SharedPreferences key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userName = (EditText)findViewById(R.id.userName_edit);
        passWord = (EditText)findViewById(R.id.passWord_edit);
        key = getSharedPreferences("key", Context.MODE_PRIVATE);
    }

    public void signUp(View v){
        String userName_input = userName.getText().toString();
        String passWord_input = passWord.getText().toString();
        SharedPreferences.Editor editor = key.edit();
        editor.putString("userName_key", userName_input);
        editor.putString("passWord_key", passWord_input);
        editor.commit();

        Intent intent = new Intent(SignupActivity.this,MainActivity.class);
        startActivity(intent);
    }


}

