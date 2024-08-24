public class Dice {
    private int noOfDice;

    Dice(int noOfDice){
        this.noOfDice = noOfDice;
    }

    public int roll(){
        int maxNo = 6*noOfDice;
        int minNo = 1*noOfDice;
        return (int)Math.floor(Math.random()*(maxNo - minNo) ) + 1;
    }
}
