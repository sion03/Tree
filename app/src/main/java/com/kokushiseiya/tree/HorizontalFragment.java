package com.kokushiseiya.tree;

import android.app.Fragment;
import android.content.pm.FeatureGroupInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * Created by kokushiseiya on 16/05/04.
 */
public class HorizontalFragment extends Fragment {

    private FeatureCoverFlow coverFlow;
    private DataAdapter adapter;
    private ArrayList<Idea> data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)  {
        return inflater.inflate(R.layout.fragment_horizontal, container, false);
    }

    @Override
    public  void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
        adapter = new DataAdapter(getActivity(), data);
        coverFlow = (FeatureCoverFlow) getActivity().findViewById(R.id.coverflow);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        });
    }

    public void setData() {
        User user1 = new User("ronnnnn");
        data = new ArrayList<>();
        data.add(new Idea(user1, "title", "hogehoge"));
        data.add(new Idea(user1, "title", "fugefuge"));
    }
}
