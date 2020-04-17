package Monopoly;

import javax.swing.*;
import java.awt.*;

public class PropertySpaces extends JPanel {
    int width;
    int height;
    int x;
    int y;
    String propName1;
    String propName2;
    String propName3;
    int propPrice;
    Color propColor;
    int edge;   // edges: 0 == bottom, 1 == left, 2 == top, 3 == right
    int position;

    private int houseCount = 0;
    private boolean hasHotel = false;

    private boolean isMortgaged = false;

    private Player ownedBy = null;

    private boolean canBeBought;

    public PropertySpaces (int width, int height, int x, int y, String propName1, String propName2, String propName3, int propPrice, Color propColor, int edge, int position, boolean canBeBought) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.propName1 = propName1;
        this.propName2 = propName2;
        this.propName3 = propName3;
        this.propPrice = propPrice;
        this.propColor = propColor;
        this.edge = edge;
        this.position = position;
        this.canBeBought = canBeBought;
    }

    public PropertySpaces (int x, int y, int width, int height, int propPrice, int position, String propName1, String propName2, String propName3, boolean canBeBought) {
        this.x = x;
        this.y = y;
        this.propPrice = propPrice;
        this.position = position;
        this.canBeBought = canBeBought;

        this.width = width;
        this.height = height;
        this.propName1 = propName1;
        this.propName2 = propName2;
        this.propName3 = propName3;
        this.propColor = Color.BLACK;
        this.edge = 0;
    }

    public void setMortgaged(boolean bool) {
        this.isMortgaged = bool;
    }

    public Boolean getMortgaged() {
        return this.isMortgaged;
    }

    public boolean getCanBeBought() {
        return this.canBeBought;
    }

    public void setHouseCount(int num) {
        this.houseCount += num;
    }

    public int getHouseCount() {
        return this.houseCount;
    }

    public void setHasHotel(boolean bool) {
        this.hasHotel = bool;
    }

    public boolean getHasHotel() {
        return this.hasHotel;
    }

    public void setOwnedBy(Player p) {
        this.ownedBy = p;
    }

    public Player getOwnedBy() {
        return this.ownedBy;
    }

    public String getFullPropertyName() {
        String fullName = "";

        if (!this.propName1.equals("")) {
            fullName = this.propName1;
        }
        if (!this.propName2.equals("")) {
            fullName = (fullName + " " + propName2);
        }
        if (!this.propName3.equals("")) {
            fullName = (fullName + " " + propName2 + " " + propName3);
        }

        return fullName;
    }

    public void drawCard() {
        PropertyCard c = new PropertyCard(this);
    }
}
