package com.example.android_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactsListAdapter extends ArrayAdapter<Contact> {
    private static final String TAG = "ContactsListAdapter";
    private Context mContext;
    int mResource;

    public ContactsListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String type = getItem(position).getType();

        Contact contact = new Contact(name, type);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.contactName);
        TextView tvType = (TextView) convertView.findViewById(R.id.contactType);

        tvName.setText(name);
        tvType.setText(type);

        return convertView;
    }
}
