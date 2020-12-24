package com.example.android_app;

import androidx.appcompat.app.AppCompatActivity;

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
        // действия, совершаемые после нажатия на кнопку
        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, SecondActivity.class);
        // Получаем текстовое поле в текущей Activity
//        EditText editText = (EditText) findViewById(R.id.textInput);
        // Получае текст данного текстового поля
//        String message = editText.getText().toString();
        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
//        intent.putExtra("message", message);
        // запуск activity
        startActivity(intent);
    }

    public void get3Activity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}