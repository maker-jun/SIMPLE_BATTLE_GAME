package com.example.battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,CharacterSelect.class);
                startActivity(i);
                finish();
            }
        },0);
        //finish();

    }
}
