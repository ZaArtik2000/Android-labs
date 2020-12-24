package com.example.android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView contactsListView = (ListView) findViewById(R.id.contactsList);

        Contact john = new Contact("John Malkovich", "friend");
        Contact frenk = new Contact("Frenk Frenkovich", "friend");
        Contact liza = new Contact("Liza Alexandrovna", "girlfriend");
        Contact aaron = new Contact("Aaron Nick", "friend");
        Contact adam = new Contact("Adam Aldrin", "friend");
        Contact bean = new Contact("Bean Becker", "friend");

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(john);
        contacts.add(frenk);
        contacts.add(liza);
        contacts.add(aaron);
        contacts.add(adam);
        contacts.add(bean);

        ContactsListAdapter adapter = new ContactsListAdapter(this, R.layout.contacts_list_item, contacts);
        contactsListView.setAdapter(adapter);

        ImageButton deleteBtn = (ImageButton) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                SparseBooleanArray checkedItemsPosition = contactsListView.getCheckedItemPositions();

                int itemcount = contactsListView.getCount();

                for (int i = itemcount; i>=0; i--) {
                    if (checkedItemsPosition.get(i)) {
                        adapter.remove(contacts.get(i));
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}