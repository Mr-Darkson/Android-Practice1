package com.example.helloandriod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SECOND_ACTIVITY = 100;
    private Button btnGreetUser;
    private TextView tvGreetingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Найти кнопку и текстовое поле по их идентификаторам
        btnGreetUser = findViewById(R.id.btnGreetUser);
        tvGreetingMessage = findViewById(R.id.tvGreetingMessage);

        // Установить обработчик нажатия для кнопки
        btnGreetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String greetingMessage = "Привет";
                Intent intentToSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                intentToSecondActivity.putExtra("greetingMessage", greetingMessage);
                startActivityForResult(intentToSecondActivity, REQUEST_CODE_SECOND_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Проверяем, вернулись ли мы из нужной активности
        if (requestCode == REQUEST_CODE_SECOND_ACTIVITY && resultCode == RESULT_OK && data != null) {
            String username = data.getStringExtra("username");
            // Установка текстового сообщения с именем пользователя
            tvGreetingMessage.setText("Привет, " + username + "!");
        }
    }
}