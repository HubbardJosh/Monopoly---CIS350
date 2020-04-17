package Monopoly;

import java.awt.*;
import java.util.ArrayList;

public class Player {

    private int playerNum;
    private Color playerColor;
    private int money = 10000;
    private ArrayList<PropertySpaces> propertiesOwned = new ArrayList<>();
    private ArrayList<PropertyCard> propertiesOwnedCards = new ArrayList<>();
    private int getOutOfJailCardCount = 0;
    private int position = 0;
    private boolean inJail = false;
    private int totalDistance = 0;
    private boolean canBuyProperties = false;

    private ArrayList<PropertySpaces> allProperties = new ArrayList<PropertySpaces>();

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

    public void populateAllProperties (ArrayList<PropertySpaces> props) {
        this.allProperties = props;
    }

    public ArrayList<PropertySpaces> getAllProperties() {
        return this.allProperties;
    }

    public int getPlayerNum() {
        return this.playerNum;
    }

    public Color getPlayerColor() {
        return this.playerColor;
    }

    public int getMoney() {
        return this.money;
    }

    public void changeMoney(int amount) {
        if (amount < 0 && (-this.money) <= amount) { // subtracting money
            this.money += amount;
        } else {    // adding money
            this.money += amount;
        }
    }

    public ArrayList<PropertySpaces> getPropertyCards() {
        return this.propertiesOwned;
    }

    public void addPropertySpace(PropertySpaces card) {
        this.propertiesOwned.add(card);
    }

    public boolean checkIfHasCard(PropertySpaces card) {
        return (propertiesOwned.contains(card));
    }

    public int howManyOutOfJailCards() {
        return getOutOfJailCardCount;
    }

    public void addOutOfJailCard() {
        this.getOutOfJailCardCount += 1;
    }

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

            /*
            only limiting how many times players get payed for passing GO
            so that I can demonstrate bankruptcy and passing all owned
            properties to another player
             */
            if (this.totalDistance < 100) {
                this.changeMoney(200);

                System.out.println("Money: $" + this.getMoney());
            }

        }

//        if (this.propertiesOwned.size() != this.propertiesOwnedCards.size()) {
//            this.setPropertiesOwnedCards();
//        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        if (position == 30) {
            this.position = 10;
            this.inJail = true;
        } else {
            this.position = position;
            this.inJail = false;
        }

    }

    public boolean checkJailStatus() {
        return this.inJail;
    }

    public void changeJailStatus() {
        if (this.inJail) {
            this.inJail = false;
        } else {
            this.inJail = true;
        }
    }

    public boolean getBuyStatus() {
        return this.canBuyProperties;
    }

    public void changeBuyStatus() {
        if (this.canBuyProperties) {
            this.canBuyProperties = false;
        } else {
            this.canBuyProperties = true;
        }
    }

    private void setPropertiesOwnedCards() {
        if (propertiesOwned.size() > 0) {
            for (int i = 0; i < propertiesOwned.size(); i++) {
                propertiesOwnedCards.add(new PropertyCard(propertiesOwned.get(i)));
            }
        }
    }

    public void setPropertyCards() {
        for (int i = 0; i < allProperties.size(); i++) {
            propertiesOwnedCards.add(new PropertyCard(allProperties.get(i)));
        }
    }

    public ArrayList<PropertyCard> getAllPropertyCards() {
        return this.propertiesOwnedCards;
    }

    public void addPropCard(PropertySpaces prop) {
        this.propertiesOwnedCards.add(new PropertyCard(prop));
    }

    public PropertyCard getPropCard(PropertySpaces prop) {
        if (propertiesOwnedCards.size() > 0 && propertiesOwnedCards.contains(prop)) {
            return propertiesOwnedCards.get(propertiesOwnedCards.indexOf(prop));
        }

        return null;
    }

    public void removePropertyOwned(PropertySpaces prop) {
        this.propertiesOwned.remove(prop);
    }

    public void removeAllPropertyOwned() {
//        if (this.propertiesOwned.size() > 0) {
//            for (PropertySpaces x : this.propertiesOwned) {
//                this.propertiesOwned.remove(x);
//            }
//        }

        this.propertiesOwned = new ArrayList<PropertySpaces>();
    }

    public void removePropertyCard(PropertyCard card) {
        this.propertiesOwnedCards.remove(card);
    }

    public void removeAllPropertyCard() {
//        if (this.propertiesOwnedCards.size() > 0) {
//            for (PropertyCard x : this.propertiesOwnedCards) {
//                this.propertiesOwnedCards.remove(x);
//            }
//        }
        this.propertiesOwnedCards = new ArrayList<PropertyCard>();
    }
}
