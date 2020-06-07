package com.example.battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class battle extends AppCompatActivity {
    Button btnAtk,btnSkill;
    ImageView enemyImage,playerImage;
    TextView enemyName,enemyHp,playerName,playerHp;
    Character player,enemy;
    Character IronMan,CaptainAmerica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        //이미지
        playerImage=findViewById(R.id.playerImage);
        enemyImage=findViewById(R.id.enemyImage);

        //이름과 체력
        enemyName=findViewById(R.id.enemyName);
        enemyHp=findViewById(R.id.enemyHp);
        playerName=findViewById(R.id.playerName);
        playerHp=findViewById(R.id.playerHp);

        //버튼
        btnAtk=findViewById(R.id.btnAtk);

        //캐릭터들의 객체
        CaptainAmerica = new Character("캡틴 아메리카",100,20,20,R.drawable.captainamerica);
        IronMan = new Character("아이언맨",100,25,15,R.drawable.ironman);

        //int형 데이터 수신
        Intent intent = getIntent();
        int number = intent.getExtras().getInt("number");

        switch (number){
            case 0 :
                player= CaptainAmerica;
                enemy = IronMan;

                playerImage.setImageResource(R.drawable.captainamerica);
                enemyImage.setImageResource(R.drawable.ironman);

                break;
            case 1 :
                player= IronMan;
                enemy = CaptainAmerica;

                playerImage.setImageResource(R.drawable.ironman);
                enemyImage.setImageResource(R.drawable.captainamerica);
                break;
        }

        playerName.setText(String.valueOf(player.getName()));
        playerHp.setText(String.valueOf(player.getHp()));

        enemyName.setText(String.valueOf(enemy.getName()));
        enemyHp.setText(String.valueOf(enemy.getHp()));

        btnAtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.battle(enemy);
                enemyHp.setText(String.valueOf(enemy.getHp()));
                playerHp.setText(String.valueOf(player.getHp()));
            }
        });


    }
}
