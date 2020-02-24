package Monopoly;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class Dice {
    private int die1Val = 0;
    private int die2Val = 0;

    public void rollDice() {
        die1Val = getRoll(((int)(new Date().getTime()/1000))*((int)(new Date().getTime()/1000)));
        die2Val = getRoll(((int)(new Date().getTime()/1000))*((int)(new Date().getTime()/1000))+5);
    }

    public int getRollAmount() {
        rollDice();

        return (die1Val + die2Val);
    }

    private int getRoll (int seed) {
        Random rand = new Random(seed);
        return (rand.nextInt(6)+1);
    }
}
