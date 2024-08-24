import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    Game(){
        start();
    }

    void start(){
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
        SnakeLadderJump snake = new SnakeLadderJump();

        for(int i=0;i<noOfSnakes;i++){
            int startPoint = (int)Math.floor(Math.random()*(size));
            int endPoint = Integer.MAX_VALUE;

            while(endPoint >= startPoint) endPoint = (int)Math.floor(Math.random()*(size));

            HashMap<Integer, Integer> map = new HashMap<>();

            map.put(startPoint, endPoint);

            snake = new SnakeLadderJump(map);
        }

        System.out.println("Enter no of the Ladders:");
        int noOfLadders = s.nextInt();
        SnakeLadderJump ladder = new SnakeLadderJump();

        for(int i=0;i<noOfLadders;i++){
            int startPoint = (int)Math.floor(Math.random()*(size));
            int endPoint = Integer.MIN_VALUE;
            while(endPoint <= startPoint) endPoint = (int)Math.floor(Math.random()*(size));

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(startPoint, endPoint);
            ladder = new SnakeLadderJump(map);
        }


        Board board = new Board(size, players, new Dice(noOfDice), snake, ladder);
        board.startGame();
    }
}
