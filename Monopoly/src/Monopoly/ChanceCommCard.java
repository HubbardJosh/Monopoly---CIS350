package Monopoly;

public class ChanceCommCard {
    private String message;
    private int amount;
    private boolean isGoToJail;
    private boolean isGetOut;
    private int propToGoTo;
    private boolean isMove;


    public ChanceCommCard(String message, int amount, boolean isGoToJail, boolean isGetOut, int propToGoTo, boolean isMove) {
        this.message = message;
        this.amount = amount;
        this.isGoToJail = isGoToJail;
        this.isGetOut = isGetOut;
        this.propToGoTo = propToGoTo;
        this.isMove = isMove;
    }

    public boolean getIsGoToJail() {
        return this.isGoToJail;
    }

    public boolean getIsGetOutOfJail() {
        return this.isGetOut;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean getIsMove() {
        return this.isMove;
    }

    public int getPropToGoTo() {
        return this.propToGoTo;
    }
}
