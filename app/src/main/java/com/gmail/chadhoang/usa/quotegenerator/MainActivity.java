package com.gmail.chadhoang.usa.quotegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final static String[][] APIARRAY = {
            {"ANIME", "https://animechan.vercel.app/api/random"},
            {"DAD JOKE", "https://icanhazdadjoke.com/"},
            {"QOTD", "https://favqs.com/api/qotd"},
            {"ZEN", "https://zenquotes.io/api/random"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign values to each quote category button.
        Button anime_btn = findViewById(R.id.anime_btn);
        Button dadjoke_btn = findViewById(R.id.dadjoke_btn);
        Button qotd_btn = findViewById(R.id.qotd_btn);
        Button zen_btn = findViewById(R.id.zen_btn);
        Button random_btn = findViewById(R.id.random_btn);

        // Define Intent to be used for quote generation activity.
        Intent intent = new Intent(this, GenerateActivity.class);

        // Click listeners for each button.
        anime_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Category", APIARRAY[0][0]);
                intent.putExtra("URL", APIARRAY[0][1]);
                startActivity(intent);
            }
        });

        dadjoke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Category", APIARRAY[1][0]);
                intent.putExtra("URL", APIARRAY[1][1]);
                startActivity(intent);
            }
        });

        qotd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Category", APIARRAY[2][0]);
                intent.putExtra("URL", APIARRAY[2][1]);
                startActivity(intent);
            }
        });

        zen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Category", APIARRAY[3][0]);
                intent.putExtra("URL", APIARRAY[3][1]);
                startActivity(intent);
            }
        });

        random_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Category", "RANDOM");
                startActivity(intent);
            }
        });
    }
}