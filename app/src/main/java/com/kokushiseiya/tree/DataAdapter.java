package com.kokushiseiya.tree;

import android.app.Activity;
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
    private Activity activity;

    private static class ViewHolder {
        private TextView ideaTitle;
        private TextView ideaNote;
        private TextView editor;
        private TextView likeNum;
        private ImageButton likeButton;
        private ImageButton closeButton;

        public ViewHolder(View view) {
            ideaTitle = (TextView) view.findViewById(R.id.titleText);
            ideaNote = (TextView) view.findViewById(R.id.textBox);
            editor = (TextView) view.findViewById(R.id.userName);
            likeNum = (TextView) view.findViewById(R.id.likeNum);
            likeButton = (ImageButton) view.findViewById(R.id.like);
            closeButton = (ImageButton) view.findViewById(R.id.closed);
        }
    }

    public DataAdapter(Activity context, ArrayList<Idea> objects) {
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
            convertView = inflater.inflate(R.layout.card, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Idea idea = getItem(position);

        viewHolder.ideaTitle.setText(idea.getmText());
        viewHolder.ideaNote.setText(idea.getmText());
        viewHolder.likeNum.setText(String.valueOf(idea.getmLikeNum()));
        viewHolder.editor.setText(idea.getmUser().getmUserName());
        viewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
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
