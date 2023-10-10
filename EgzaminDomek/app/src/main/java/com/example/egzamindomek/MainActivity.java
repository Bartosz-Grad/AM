package com.example.egzamindomek;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button likeButton;
    private Button deleteButton;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.likeCounterView);
        likeButton = findViewById(R.id.likeButton);
        deleteButton = findViewById(R.id.deleteButton);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText(counter + " polubień");
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > 0) {
                    counter--;
                    textView.setText(counter + " polubień");
                }
            }
        });
    }
}