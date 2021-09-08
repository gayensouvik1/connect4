package models;

import java.util.List;

public class Board {

    private int board[][];
    private int rowSize;
    private int colSize;
    int totalTurnsPlayed;

    //1 -> player1
    //2 -> player2

    public Board(){

        rowSize = 6;
        colSize = 7;
        totalTurnsPlayed = 0;

        if(board==null)
            board = new int[rowSize][colSize];
    }

    public int getCell(int row, int col){
       return board[row][col];
    }

    public int getRowToPutPiece(int col){
        for(int i=rowSize-1;i>=0;i--){
            if(getCell(i,col) == 0)
                return i;
        }
        return -1;
    }


    public void setCell(int rowToPut, int col, int player) {
        totalTurnsPlayed++;
        board[rowToPut][col] = player;
    }

    public void printBoard(){
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean checkWinner(int lastPlayerRow, int lastPlayedCol){
        int player = board[lastPlayerRow][lastPlayedCol];

        //horizontally
        int horizontalCount = 1;

        for(int i=lastPlayedCol-1; i>=lastPlayedCol-3;i--){
            if(!(i>=0 && board[lastPlayerRow][i]==player)){
                break;
            }
            horizontalCount++;
        }

        for(int i=lastPlayedCol+1; i<=lastPlayedCol+3;i++){
            if(!(i<colSize && board[lastPlayerRow][i]==player)){
                break;
            }
            horizontalCount++;
        }

        int verticalCount = 1;

        //vertical
        for(int i=lastPlayerRow+1; i<=lastPlayerRow+3;i++){
            if(!(i<rowSize && board[i][lastPlayedCol]==player)){
                break;
            }
            verticalCount++;
        }

        //diag

        int diag1 = 1;
        int diag2 = 1;
        boolean ne=false,nw=false,se=false,sw=false;

        for(int i=1;i<=3;i++){

            if(nw==false && lastPlayedCol-i>=0 && lastPlayerRow-i>=0 && board[lastPlayerRow-i][lastPlayedCol-i]==player)
                diag1++;
            else
                nw = true;
            if(ne==false && lastPlayedCol+i<colSize && lastPlayerRow-i>=0 && board[lastPlayerRow-i][lastPlayedCol+i]==player)
                diag2++;
            else
                ne = true;
            if(sw==false && lastPlayedCol-i>=0 && lastPlayerRow+i<rowSize && board[lastPlayerRow+i][lastPlayedCol-i]==player)
                diag2++;
            else
                sw = true;
            if(se==false && lastPlayedCol+i<colSize && lastPlayerRow+i<rowSize && board[lastPlayerRow+i][lastPlayedCol+i]==player)
                diag1++;
            else
                se = true;
        }

        return horizontalCount>=4 || verticalCount>=4 || diag1>=4 || diag2>=4 ;


    }


    public boolean checkDraw(){
        return totalTurnsPlayed == rowSize*colSize;
    }

}
