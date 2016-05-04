package com.kokushiseiya.tree;

import android.app.Fragment;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
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
    private AppCompatActivity activity;

    private static class ViewHolder {
        private EditText ideaNote;
        private TextView editer;
        private TextView likeNum;
        private ImageButton likeButton;
        private ImageButton closeButton;

        public ViewHolder(View view) {
            ideaNote = (EditText) view.findViewById(R.id.note);
            editer = (TextView) view.findViewById(R.id.prop);
            likeNum = (TextView) view.findViewById(R.id.likeNum);
            likeButton = (ImageButton) view.findViewById(R.id.like);
            closeButton = (ImageButton) view.findViewById(R.id.closed);
        }
    }

    public DataAdapter(AppCompatActivity context, ArrayList<Idea> objects) {
        activity = context;
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
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.card, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ideaNote.setText("");
        viewHolder.likeNum.setText("");
        viewHolder.editer.setText("");
        viewHolder.likeNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        viewHolder.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
