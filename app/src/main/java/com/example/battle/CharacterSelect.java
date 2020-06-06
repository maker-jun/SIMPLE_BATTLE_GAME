package com.example.battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CharacterSelect extends AppCompatActivity {
    ListView characterList ;
    Button button;
    Character[] data2 = new Character[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        characterList = findViewById(R.id.characterList);
        button = findViewById(R.id.button4);

        Character ironMan= new Character("아이언맨",100,25);
        Character captainAmerica = new Character("캡틴 아메리카",100,20);
        List<Character> data = new ArrayList<>();
        data.add(captainAmerica);
        data.add(ironMan);

        // TODO: 2020-06-07 리스트를 이용해서 어댑터 뷰 생성하면 문자 출력이 제대로 안됨 
        // TODO: 2020-06-07 배열을 이용해서 해보자 ㅁ
        
        //Character[] data2 = new Character[2];
        data2[0]=captainAmerica;
        data2[1]=ironMan;

        ArrayAdapter<Character> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
        characterList.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(CharacterSelect.this, data2[0].name+data2[0].atk, Toast.LENGTH_SHORT).show();
            }
        });

        characterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = String.valueOf(parent.getItemAtPosition(position));

                Toast.makeText(CharacterSelect.this, item , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CharacterSelect.this, battle.class);
                startActivity(intent);
            }
        });


        //characterList.setOnItemClickListener(new );
    }
}
