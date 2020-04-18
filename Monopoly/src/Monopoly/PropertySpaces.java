package Monopoly;

import javax.swing.*;
import java.awt.*;

/*****************************************************************
 Class to create a property space and keep track of the space's
    width, height, x value, y value, property names, price, color,
    edge of board it is on, position on board, group it is a part of,
    amount of properties in its group, house count, if it has a hotel,
    if it is mortgaged, who it is owned by, and if it is available to
    be bought
 *****************************************************************/
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
    int propertyGroup;
    int groupTotal = 0;

    private int houseCount = 0;
    private boolean hasHotel = false;

    private boolean isMortgaged = false;

    private Player ownedBy = null;

    private boolean canBeBought;

    /*****************************************************************
     Constructor to instantiate a property space
     *****************************************************************/
    public PropertySpaces (int width, int height, int x, int y, String propName1, String propName2, String propName3, int propPrice, Color propColor, int edge, int position, boolean canBeBought, int propertyGroup) {
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
        this.propertyGroup = propertyGroup;

        if (propertyGroup != 0) {
            if (propertyGroup == 9) {
                this.groupTotal = 4;
            } else if (propertyGroup == 1 || propertyGroup == 8) {
                this.groupTotal = 2;
            } else {
                this.groupTotal = 3;
            }
        }

    }

    /*****************************************************************
     Constructor to instantiate a property space that has an image associated
        to it
     *****************************************************************/
    public PropertySpaces (int x, int y, int width, int height, int propPrice, int position, String propName1, String propName2, String propName3, boolean canBeBought, int propertyGroup) {
        this.x = x;
        this.y = y;
        this.propPrice = propPrice;
        this.position = position;
        this.canBeBought = canBeBought;
        this.propertyGroup = propertyGroup;

        this.width = width;
        this.height = height;
        this.propName1 = propName1;
        this.propName2 = propName2;
        this.propName3 = propName3;
        this.propColor = Color.BLACK;
        this.edge = 0;
    }

    /*****************************************************************
     Method to set if a property is mortgaged

     @param bool
     *****************************************************************/
    public void setMortgaged(boolean bool) {
        this.isMortgaged = bool;
    }

    /*****************************************************************
     Method to get the property group

     @return int
     *****************************************************************/
    public int getPropertyGroup() {
        return this.propertyGroup;
    }

    /*****************************************************************
     Method to get the total count of properties in a group

     @return int
     *****************************************************************/
    public int getGroupTotal() {
        return this.groupTotal;
    }

    /*****************************************************************
     Method to get the mortgage status of a property

     @return boolean
     *****************************************************************/
    public Boolean getMortgaged() {
        return this.isMortgaged;
    }

    /*****************************************************************
     Method to get the buy status of a property

     @return boolean
     *****************************************************************/
    public boolean getCanBeBought() {
        return this.canBeBought;
    }

    /*****************************************************************
     Method to add a house to a property

     Checks to make sure no more than 4 houses can be on a property
        and no less than 0

     @param num
     *****************************************************************/
    public void addHouseCount(int num) {
        if ((num > 0 && num < 5) && ((this.houseCount + num) < 5)) {
            this.houseCount += num;
        } else {
            System.out.println("Invalid house count");
        }
    }

    /*****************************************************************
     Method to get the house count on a property

     @return int
     *****************************************************************/
    public int getHouseCount() {
        return this.houseCount;
    }

    /*****************************************************************
     Method to set a hotel on a property

     @param bool
     *****************************************************************/
    public void setHasHotel(boolean bool) {
        this.hasHotel = bool;
    }

    /*****************************************************************
     Method to get the presence of a hotel on a property

     @return boolean
     *****************************************************************/
    public boolean getHasHotel() {
        return this.hasHotel;
    }

    /*****************************************************************
     Method to set the owner of a player

     @param p
     *****************************************************************/
    public void setOwnedBy(Player p) {
        this.ownedBy = p;
    }

    /*****************************************************************
     Method to get the player that owns a property

     @return Player
     *****************************************************************/
    public Player getOwnedBy() {
        return this.ownedBy;
    }

    /*****************************************************************
     Method to get the full name of a property

     @return String
     *****************************************************************/
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
}
