package com.kokushiseiya.tree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    ImageView closeButton;
    EditText mIdea;
    TextView username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        closeButton = (ImageView)findViewById(R.id.new_close);
        mIdea = (EditText) findViewById(R.id.new_idea);
        username = (TextView) findViewById(R.id.new_user);

        //ログインしているアカウント情報をusernameに表示
        SharedPreferences data = getSharedPreferences("key", Context.MODE_PRIVATE);
        username.setText(data.getString("userName_key", null));
    }


    public void handin(View v){
        //データ保存...未完了
        Intent intent = getIntent();
        if(intent != null){
            String str = intent.getStringExtra("");

            //データをstr+1盤目の子に保存する
        }

        //スクロール画面に戻る
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        this.finish();
    }

    public void close(View v){
        //スクロール画面に戻る
        this.finish();
    }


}
