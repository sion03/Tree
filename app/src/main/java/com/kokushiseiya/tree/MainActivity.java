package com.kokushiseiya.tree;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Firebase mRootRef;
    private String userName;
    private Fragment horizontalFragment;
    private Fragment verticalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // firebaseの設定
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase(BuildConfig.FIREBASE_URL);

        // Loginで設定したuser情報を取得
        SharedPreferences data = getSharedPreferences("USERDATA", Context.MODE_PRIVATE);
        userName = data.getString("USERNAME", null);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Fragmentの動的追加
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (verticalFragment == null) {
            verticalFragment = new VerticalFragment();
        }
        fragmentTransaction.replace(R.id.fragment_container, verticalFragment);
        fragmentTransaction.commit();
    }
}