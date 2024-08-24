import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    Game(){
        beforeStart();
    }

    void beforeStart(){
        System.out.println("Enter size of the Board:");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();

        System.out.println("Enter no of the Players:");
        int noOfPlayers = s.nextInt();
        s.nextLine();

        Queue<Player> players = new LinkedList<>();
        for(int i = 0; i< noOfPlayers;i++){
            System.out.println("Enter "+(i+1)+" Player's Name:");
            String p = s.nextLine();
            players.offer(new Player(p, 0));
        }

        System.out.println("Enter no of the Dices used:");
        int noOfDice = s.nextInt();

        System.out.println("Enter no of the Snakes");
        int noOfSnakes = s.nextInt();
        SnakeLadderJump snake = createSnakeLadder(noOfSnakes, size, "snake");

        System.out.println("Enter no of the Ladders:");
        int noOfLadders = s.nextInt();
        SnakeLadderJump ladder = createSnakeLadder(noOfLadders, size, "ladder");

        // Loading everything before start of the game
        Board board = new Board(size, players, new Dice(noOfDice), snake, ladder);
        board.startGame();
    }

    SnakeLadderJump createSnakeLadder(int num, int size, String type){
        SnakeLadderJump snakeLadderJump = new SnakeLadderJump();

        for(int i=0;i<num;i++){
            int startPoint = (int)Math.floor(Math.random()*(size));
            int endPoint;

            if(type == "snake"){
                endPoint = Integer.MAX_VALUE;
                while(endPoint >= startPoint) endPoint = (int)Math.floor(Math.random()*(size));
            } else{
                endPoint = Integer.MIN_VALUE;
                while(endPoint <= startPoint) endPoint = (int)Math.floor(Math.random()*(size));
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            map.put(startPoint, endPoint);
            snakeLadderJump = new SnakeLadderJump(map);
        }

        return snakeLadderJump;
    }
}
