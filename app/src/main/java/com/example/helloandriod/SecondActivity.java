package com.example.helloandriod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreenActivity extends AppCompatActivity {
    private EditText userNameInput;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        // Инициализация полей ввода и кнопки
        userNameInput = findViewById(R.id.userNameInput);
        confirmButton = findViewById(R.id.confirmButton);

        // Получаем приветственное сообщение
        String welcomeMessage = getIntent().getStringExtra("greeting");

        // Устанавливаем обработчик нажатия на кнопку
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameInput.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("userName", userName);
                setResult(RESULT_OK, resultIntent);
                finish(); // Закрываем активность и возвращаем результат
            }
        });
    }
}