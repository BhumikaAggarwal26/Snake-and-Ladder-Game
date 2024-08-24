import java.util.Map;

public class SnakeLadderJump {

    Map<Integer, Integer> snakeLadderPosition;

    SnakeLadderJump(){}

    SnakeLadderJump(Map<Integer, Integer> snakeLadderPosition){
        this.snakeLadderPosition = snakeLadderPosition;
    }

    public Map<Integer, Integer> getSnakeLadderPosition() {
        return snakeLadderPosition;
    }
}
