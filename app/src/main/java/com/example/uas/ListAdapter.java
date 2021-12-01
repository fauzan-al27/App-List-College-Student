package com.example.uas;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {
    public ListAdapter(Context context, ArrayList<User> userArrayList) {
        super(context, R.layout.list_item, userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user= getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.profilePict);
        TextView userName = convertView.findViewById(R.id.personName);
        TextView nim = convertView.findViewById(R.id.nim);

        imageView.setImageResource(user.imageId);
        userName.setText(user.name);
        nim.setText(user.nim);

        Log.d("debugUsername", user.nim);

        return convertView;
    }
}
