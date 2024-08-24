import java.util.Map;
import java.util.Queue;

public class Board {

    int size;
    Queue<Player> nextTurn;
    Dice dice;
    SnakeLadderJump snake;
    SnakeLadderJump ladder;

    Board(int size, Queue<Player> nextTurn, Dice dice, SnakeLadderJump snake, SnakeLadderJump ladder ){
        this.size = size;
        this.nextTurn = nextTurn;
        this.dice = dice;
        this.snake = snake;
        this.ladder = ladder;
    }

    void startGame(){

        while(nextTurn.size()>1){ // if N players, when only 1 player left then game ends
            Player player = nextTurn.poll();
            int num = dice.roll();

            System.out.println(player.getName()+" rolled "+ num);
            // if the new position gets larger than the size of board -> player remains at same position
            if(player.getPosition()+num <= size) player.setPosition(player.getPosition()+num);
            System.out.println(player.getName()+" went to position:" +player.getPosition());

            checkForSnakeLadder(player, snake);
            checkForSnakeLadder(player, ladder);

            if(player.getPosition() == size){
                System.out.println("-------------------------------------------");
                System.out.println(player.getName()+" wins the game!!!!");
                System.out.println("--------------------------------------------");
                continue;// Will not add this person to Queue further
            }
            nextTurn.offer(player);
            System.out.println("-------------------------------------------");
        }
    }

    void checkForSnakeLadder(Player player, SnakeLadderJump snakeLadderJump){
        if(snakeLadderJump.getSnakeLadderPosition().containsKey(player.getPosition())){

            player.setPosition(snakeLadderJump.getSnakeLadderPosition().get(player.getPosition()));

            if(snakeLadderJump == snake)System.out.println("Player "+player.getName()+" Bitten by Snake!!!!!!");
            else System.out.println("Player "+player.getName()+" Got a Ladder!!!!!!");

            System.out.println(player.getName()+" went to position:" +player.getPosition());
        }
    }
}
