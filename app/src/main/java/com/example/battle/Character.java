package com.example.battle;

import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

public class Character implements Serializable {
    private String name;
    private int hp;
    private int atk;
    private int spd;
    private long id;



    public Character(String name, int hp, int atk, int spd, long id){
        this.name= name;
        this.hp=hp;
        this.atk=atk;
        this.spd=spd;
        this.id = id; //여기에 id를 넣을수도 있구나
    }

    public void battle(Character enemy){
        hp-=enemy.atk;
        enemy.hp-=atk;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getAtk(){
        return atk;
    }
    public void setAtk(int atk){
        this.atk = atk;
    }
    public int getSpd() {
        return spd;
    }
    public void setSpd(int spd) {
        this.spd = spd;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
