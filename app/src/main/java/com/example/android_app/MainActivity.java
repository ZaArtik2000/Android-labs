package com.example.android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editCurrentUserName = (EditText) findViewById(R.id.editCurrentUserName);
        editCurrentUserName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView currentUserName = (TextView) findViewById(R.id.currentUserName);
                currentUserName.setText(s);
            }
        });
    }

    public void get2Activity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void get3Activity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void onAboutClick(View view) {
        Fragment aboutFragment = new AboutFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContainer, aboutFragment);
        ft.commit();
    }

    public void onBestContactsClick(View view) {
        Fragment bestContactsFragment = new BestContactsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContainer, bestContactsFragment);
        ft.commit();
    }

    public void onAgreementClick(View view) {
        Fragment agreementFragment = new AgreementFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContainer, agreementFragment);
        ft.commit();
    }
}