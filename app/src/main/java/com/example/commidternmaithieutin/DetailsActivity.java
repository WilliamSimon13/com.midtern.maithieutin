package com.example.commidternmaithieutin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;

    private TextView scoreTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Random random = new Random();
        int score = random.nextInt(10);

        listView = findViewById(R.id.listView);
        scoreTextView = findViewById(R.id.Scoretxt);

        scoreTextView.setText("Score "+MainActivity.finalSocre+"/10");

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("questionList")) {
            List<String> questionList = intent.getStringArrayListExtra("questionList");
            if (questionList != null) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questionList);
                listView.setAdapter(adapter);
            }
        }
    }
}
