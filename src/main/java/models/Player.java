package models;

import java.util.Random;

public class Player {

    private int id;

    public Player(int id){
        this.id = id;
    }


    public int playTurn(){
        int colToChoose = new Random(System.currentTimeMillis()).nextInt(7);
        System.out.println(colToChoose);
        return colToChoose;
    }

    public int getId() {
        return id;
    }
}
