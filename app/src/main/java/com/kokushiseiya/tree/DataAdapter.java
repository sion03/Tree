package com.kokushiseiya.tree;

import android.app.Fragment;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * アダプター
 */
public class DataAdapter extends BaseAdapter {

    private ArrayList<Idea> data;
    private Fragment fragment;

    private static class ViewHolder {
        private EditText ideaNote;
        private TextView editer;
        private TextView likeNum;
        private ImageButton likeButton;
        private ImageButton closeButton;
    }

    public DataAdapter(Fragment context, ArrayList<Idea> objects) {
        fragment = context;
        data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Idea getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from()
        }
    }
}
