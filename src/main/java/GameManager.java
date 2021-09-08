import models.Board;
import models.Player;

public class GameManager {

    public Board borad;
    public int currentPlayer;

    public GameManager(){
        borad = new Board();
    }

    //returns true if someone wins

    public boolean play(int col, int player){

        boolean didSomeoneWin = false;

        int rowToPut = borad.getRowToPutPiece(col);

        if(rowToPut != -1){
            borad.setCell(rowToPut,col, player);
            if(borad.checkWinner(rowToPut,col)){
                System.out.println("Player "+player+" wins. Last turn "+rowToPut+","+col);
                didSomeoneWin = true;
            }
        }else{
            System.out.println("Column is full");
        }

        borad.printBoard();
        return didSomeoneWin;

    }




    public boolean isDrawn() {
        return borad.checkDraw();
    }


}
