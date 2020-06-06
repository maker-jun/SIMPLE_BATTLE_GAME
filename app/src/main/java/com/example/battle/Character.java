package com.example.battle;

public class Character {
    String name;
    int hp;
    int atk;
    int spd;

    public Character(String name,int hp, int atk){
        this.name= name;
        this.hp=hp;
        this.atk=atk;
    }

    void print(){
        System.out.printf("%s의 남은 체력 : %d",name,hp);
    }
}
