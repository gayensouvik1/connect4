import models.Player;

public class Main {

    public static void main(String args[]){

        Player bot1 = new Player(1);
        Player bot2 = new Player(2);

        GameManager gameManager = new GameManager();
        Player currentPlayer = bot1;

        while(gameManager.isDrawn() == false){

            if(gameManager.play(currentPlayer.playTurn(), currentPlayer.getId()))
                break;

            if(currentPlayer.getId() == 1)
                currentPlayer = bot2;
            else
                currentPlayer = bot1;

        }

    }

}
