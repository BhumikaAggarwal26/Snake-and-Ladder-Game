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

        while(nextTurn.size()>1){
            Player player = nextTurn.poll();
            int num = dice.roll();

            System.out.println(player.getName()+" rolled "+ num);
            if(player.getPosition()+num <= size) player.setPosition(player.getPosition()+num);
            System.out.println(player.getName()+" went to position:" +player.getPosition());

            if(snake.getSnakeLadderPosition().containsKey(player.getPosition())){
                player.setPosition(snake.getSnakeLadderPosition().get(player.getPosition()));
                System.out.println("Player "+player.getName()+" Bitten by Snake!!!!!!");
                System.out.println(player.getName()+" went to position:" +player.getPosition());
            }

            if(ladder.getSnakeLadderPosition().containsKey(player.getPosition())){
                player.setPosition(ladder.getSnakeLadderPosition().get(player.getPosition()));
                System.out.println("Player "+player.getName()+" Got a Ladder!!!!!!");
                System.out.println(player.getName()+" went to position:" +player.getPosition());
            }

            if(player.getPosition() == size){
                System.out.println("-------------------------------------------");
                System.out.println(player.getName()+" wins the game!!!!");
                System.out.println("--------------------------------------------");
                continue;
            }
            nextTurn.offer(player);
            System.out.println("-------------------------------------------");
        }
    }
}
