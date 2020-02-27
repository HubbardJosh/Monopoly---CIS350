package Monopoly;

import java.util.ArrayList;

public class MonopolyModel {
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    private Player currentPlayer;

    private Dice dice;

    private ArrayList<PropertySpaces> properties = new ArrayList<PropertySpaces>();
    private ArrayList<Player> playerList = new ArrayList<Player>();

    MonopolyModel() {

        p1 = new Player(1);
        p2 = new Player(2);
        p3 = new Player(3);
        p4 = new Player(4);


        // comment out an add to reduce number of players
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);

        currentPlayer = p1;

        dice = new Dice();
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player getPreviousPlayer() {

        if (playerList.size() == 2) {
            return getNextPlayer();
        } else if (playerList.size() == 3) {
            if (currentPlayer == p1) {
                return p3;
            } else if (currentPlayer == p2) {
                return p1;
            } else if (currentPlayer == p3) {
                return p2;
            }
        } else if (playerList.size() == 4) {
            if (currentPlayer == p1) {
                return p4;
            } else if (currentPlayer == p2) {
                return p1;
            } else if (currentPlayer == p3) {
                return p2;
            } else if (currentPlayer == p4) {
                return p3;
            }
        }

        return this.currentPlayer;
    }

    public Player getNextPlayer() {

        if (playerList.size() == 2) {
            if (currentPlayer == p1) {
                return p2;
            } else if (currentPlayer == p2) {
                return p1;
            }
        } else if (playerList.size() == 3) {
            if (currentPlayer == p1) {
                return p2;
            } else if (currentPlayer == p2) {
                return p3;
            } else if (currentPlayer == p3) {
                return p1;
            }
        } else if (playerList.size() == 4) {
            if (currentPlayer == p1) {
                return p2;
            } else if (currentPlayer == p2) {
                return p3;
            } else if (currentPlayer == p3) {
                return p4;
            } else if (currentPlayer == p4) {
                return p1;
            }
        }

        return this.currentPlayer;
    }

    public void nextPlayer() {
        if (playerList.size() == 2) {
            if (currentPlayer.equals(p1)) {
                currentPlayer = p2;
            } else if (currentPlayer.equals(p2)) {
                currentPlayer = p1;
            }
        } else if (playerList.size() == 3) {
            if (currentPlayer.equals(p1)) {
                currentPlayer = p2;
            } else if (currentPlayer.equals(p2)) {
                currentPlayer = p3;
            } else if (currentPlayer.equals(p3)) {
                currentPlayer = p1;
            }
        } else if (playerList.size() == 4) {
            if (currentPlayer.equals(p1)) {
                currentPlayer = p2;
            } else if (currentPlayer.equals(p2)) {
                currentPlayer = p3;
            } else if (currentPlayer.equals(p3)) {
                currentPlayer = p4;
            } else {
                currentPlayer = p1;
            }
        } else {
            currentPlayer = p1;
        }
    }

    public Dice getDice() {
        return this.dice;
    }

    public void updatePlayerLocation (Player p) {
        if (properties.size() == 0 && p.getAllProperties().size() > 0) {
            properties = p.getAllProperties();
        }
        System.out.println(p.getPosition());
        p.changePosition(dice.getRollAmount());

        if (p.getPosition() == 30) {
            getCurrentPlayer().changeJailStatus();
            p.setPosition(10);
        }

        if (p.getPosition() == 4) {
            if (p.getMoney() >= 200) {
                p.changeMoney(-200);
            } else {
                // ask to mortgage >= 1 properties to be able to afford this
                // if not enough assets to pay, all player's properties are set to unowned
                System.out.println("Not enough money for Income Tax. Need to mortgage properties");
            }
        }

        if (p.getPosition() == 38) {
            if (p.getMoney() >= 100) {
                p.changeMoney(-100);
            } else {
                // ask to mortgage >= 1 properties to be able to afford this
                // if not enough assets to pay, all player's properties are set to unowned
                System.out.println("Not enough money for Luxury Tax. Need to mortgage properties");
            }

        }

        System.out.println("Current position on board: " + p.getPosition());

//        nextPlayer();
    }

    public void buyProperty() {
        if (properties.size() != 0 && currentPlayer.getBuyStatus()) {
            // player can buy properties
            for (int i = 0; i < properties.size(); i++) {
                if (properties.get(i).position == currentPlayer.getPosition() && properties.get(i).getOwnedBy() == null) {
                    //  player is on an available property
                    if (properties.get(i).propPrice <= currentPlayer.getMoney() && properties.get(i).getCanBeBought()) {
                        // player has enough money to buy property
                        System.out.println("Bought: " + properties.get(i).propName1 + " " + properties.get(i).propName2);
                        currentPlayer.changeMoney(-properties.get(i).propPrice);    // subtract from player's money
                        currentPlayer.addPropertyCard(properties.get(i));   // add property card to player's property cards
                        properties.get(i).setOwnedBy(currentPlayer);    // set property owner to current player
                    }
                }
            }
        }
    }


}


