package com.example.battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
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

//        Character ironMan= new Character("아이언맨",100,25);
//        Character captainAmerica = new Character("캡틴 아메리카",100,20);

        // TODO: 2020-06-07 리스트를 이용해서 어댑터 뷰 생성하면 문자 출력이 제대로 안됨
        List<String> data = new ArrayList<>();
        data.add("captainAmerica");
        data.add("ironMan");

        // TODO: 2020-06-07 객체배열을 이용해서 해보자 ->똑같다 -> 실패 일단 인텐트를 여러개 만들어서 프로젝트 만들자
//        data2 = new Character[2];
//        data2[0]=captainAmerica;
//        data2[1]=ironMan;
        // TODO: 2020-06-07
        

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
        characterList.setAdapter(adapter);

        //아래는 객체배열
        //ArrayAdapter<Character> adapter2 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,data2);
        //characterList.setAdapter(adapter2);

        characterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(CharacterSelect.this, battle.class);
                switch (position){
                    case 0 :
                        Toast.makeText(CharacterSelect.this, parent.getItemAtPosition(position).toString() , Toast.LENGTH_SHORT).show();
                        intent.putExtra("number",position);
                        //포지션 넘버를 송신 하여 0이면 캡틴아메리카 1이면 아이언맨 캐릭터를 선택
                        startActivity(intent);
                        break;
                    case 1 :
                        Toast.makeText(CharacterSelect.this, parent.getItemAtPosition(position).toString() , Toast.LENGTH_SHORT).show();
                        intent.putExtra("number",position);
                        startActivity(intent);
                        break;
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(CharacterSelect.this, data2[0].getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
