package Monopoly;

import java.awt.*;
import java.util.ArrayList;

/*****************************************************************
 Class to instantiate a Player from and keeps track of the player's
    player num, color, money, properties owned, get out of jail cards,
    position on board, if they are in jail, distance traveled, and if they
    can buy a property
 *****************************************************************/
public class Player {

    private int playerNum;
    private Color playerColor;
    private int money = 200;
    private ArrayList<PropertySpaces> propertiesOwned = new ArrayList<>();
    private ArrayList<PropertyCard> propertiesOwnedCards = new ArrayList<>();
    private int getOutOfJailCardCount = 0;
    private int position = 0;
    private boolean inJail = false;
    private int totalDistance = 0;
    private boolean canBuyProperties = false;

    private ArrayList<PropertySpaces> allProperties = new ArrayList<PropertySpaces>();

    /*****************************************************************
     Constructor to instantiate a player

     @param playerNum
     *****************************************************************/
    public Player(int playerNum) {
        this.playerNum = playerNum;

        if (playerNum == 1) {
            this.playerColor = Color.BLUE;
        } else if (playerNum == 2) {
            this.playerColor = Color.GREEN;
        } else if (playerNum == 3) {
            this.playerColor = Color.RED;
        } else if (playerNum == 4) {
            this.playerColor = Color.PINK;
        }
    }

    /*****************************************************************
     Method to create an ArrayList of all properties on the board

     @param props
     *****************************************************************/
    public void populateAllProperties (ArrayList<PropertySpaces> props) {
        this.allProperties = props;
    }

    /*****************************************************************
     Method to get ArrayList of all properties on the board

     @return ArrayList
     *****************************************************************/
    public ArrayList<PropertySpaces> getAllProperties() {
        return this.allProperties;
    }

    /*****************************************************************
     Method to get the player number

     @return int
     *****************************************************************/
    public int getPlayerNum() {
        return this.playerNum;
    }

    /*****************************************************************
     Method to get the player color

     @return Color
     *****************************************************************/
    public Color getPlayerColor() {
        return this.playerColor;
    }

    /*****************************************************************
     Method to get the player's money count

     @return int
     *****************************************************************/
    public int getMoney() {
        return this.money;
    }

    /*****************************************************************
     Method to change the player's money count

     @param amount
     *****************************************************************/
    public void changeMoney(int amount) {
        if (amount < 0 && (-this.money) <= amount) { // subtracting money
            this.money += amount;
        } else {    // adding money
            this.money += amount;
        }
    }

    /*****************************************************************
     Method to get the propertyCards for the player's owned properties

     @return ArrayList
     *****************************************************************/
    public ArrayList<PropertySpaces> getPropertyCards() {
        return this.propertiesOwned;
    }

    /*****************************************************************
     Method to add to the list of properties owned by the player

     @param card
     *****************************************************************/
    public void addPropertySpace(PropertySpaces card) {
        this.propertiesOwned.add(card);
    }

    /*****************************************************************
     Method to get the count of get out of jail cards the player has

     @return int
     *****************************************************************/
    public int howManyOutOfJailCards() {
        return getOutOfJailCardCount;
    }

    /*****************************************************************
     Method to change the players position on the board and adds money
        for passing go

     @param diceRoll
     *****************************************************************/
    public void changePosition(int diceRoll) {
        this.position += diceRoll;
        this.totalDistance += diceRoll;

        if (this.totalDistance > 39) {
            this.canBuyProperties = true;
        }

        if (this.position > 39) {
            this.position -= 40;

            System.out.println("Money: $" + this.getMoney());
            System.out.println("Passed Go. Collect $200");

            this.changeMoney(200);

        }
        System.out.println("Total distance traveled: " + this.totalDistance);
    }

    /*****************************************************************
     Method to get the player's position on the board

     @return int
     *****************************************************************/
    public int getPosition() {
        return this.position;
    }

    /*****************************************************************
     Method to set the player's position on the board

     @param position
     *****************************************************************/
    public void setPosition(int position) {
        if (position == 30) {
            this.position = 10;
            this.inJail = true;
        } else {
            this.position = position;
            this.inJail = false;
        }

    }

    /*****************************************************************
     Method to get the player's jail status

     @return boolean
     *****************************************************************/
    public boolean checkJailStatus() {
        return this.inJail;
    }

    /*****************************************************************
     Method to change the player's jail status
     *****************************************************************/
    public void changeJailStatus() {
        if (this.inJail) {
            this.inJail = false;
        } else {
            this.inJail = true;
        }
    }

    /*****************************************************************
     Method to get the player's buy status

     @return boolean
     *****************************************************************/
    public boolean getBuyStatus() {
        return this.canBuyProperties;
    }

    /*****************************************************************
     Method to get the list of owned property cards

     @return ArrayList
     *****************************************************************/
    public ArrayList<PropertyCard> getAllPropertyCards() {
        return this.propertiesOwnedCards;
    }

    /*****************************************************************
     Method to add a card to the list of owned properties

     @param prop
     *****************************************************************/
    public void addPropCard(PropertySpaces prop) {
        this.propertiesOwnedCards.add(new PropertyCard(prop));
    }

    /*****************************************************************
     Method to remove all properties the player owns
     *****************************************************************/
    public void removeAllPropertyOwned() {
        this.propertiesOwned = new ArrayList<PropertySpaces>();
    }

    /*****************************************************************
     Method to remove all property cards the player owns
     *****************************************************************/
    public void removeAllPropertyCard() {
        this.propertiesOwnedCards = new ArrayList<PropertyCard>();
    }
}
