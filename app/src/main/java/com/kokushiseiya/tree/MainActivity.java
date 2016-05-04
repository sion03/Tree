package com.kokushiseiya.tree;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Firebase mRootRef;
    private String userName;
    private Fragment horizontalFragment;
    private Fragment verticalFragment;
    private ArrayList<Idea> mIdeaLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Loginで設定したuser情報を取得
        SharedPreferences data = getSharedPreferences("USERDATA", Context.MODE_PRIVATE);
        userName = data.getString("USERNAME", null);

        mIdeaLists = new ArrayList<>();

        // firebaseの設定
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase(BuildConfig.FIREBASE_URL);
        mRootRef.child("idea").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, Object> newIdea = (Map<String, Object>) dataSnapshot.getValue();

                String title = String.valueOf(newIdea.get("title"));
                String text = String.valueOf(newIdea.get("text"));

                HashMap<String, String> user = (HashMap<String, String>) newIdea.get("user");
                String userName = user.get("userName");

                int likeNum = Integer.parseInt(String.valueOf(newIdea.get("likeNum")));
                boolean isClosed = Boolean.parseBoolean(String.valueOf("isClosed"));

                String timeStampKey = String.valueOf(dataSnapshot.getKey());

                Idea idea = new Idea(new User(userName), title, text, likeNum, isClosed);

                mIdeaLists.add(idea);

                setList(mIdeaLists);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String timeStampKey = String.valueOf(dataSnapshot.getKey());

                for (int i = 0; i < mIdeaLists.size(); i++) {
                    if (mIdeaLists.get(i).)
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Fragmentの動的追加
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (horizontalFragment == null) {
            horizontalFragment = new HorizontalFragment();
        }
        fragmentTransaction.replace(R.id.fragment_container, horizontalFragment);
        fragmentTransaction.commit();
    }
}