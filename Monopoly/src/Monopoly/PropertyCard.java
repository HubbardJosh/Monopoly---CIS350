package Monopoly;

/*****************************************************************
 Creates a "card" that will display the rent, house, mortgage, and
    hotel information.
 *****************************************************************/
public class PropertyCard {
    private PropertySpaces propToCreateCard;
    private int rent = 0;
    private int rentOneHouse = 0;
    private int rentTwoHouses = 0;
    private int rentThreeHouses = 0;
    private int rentFourHouses = 0;
    private int rentHotel = 0;
    private int mortgageVal = 0;
    private int houseCost = 0;
    private int hotelCost = 0;
    private int totalBuy = 0;
    private Dice d = new Dice();

    /*****************************************************************
     Constructor to create a card for a property

     @param propToCreateCard  PropertySpaces
     *****************************************************************/
    PropertyCard(PropertySpaces propToCreateCard) {
        this.propToCreateCard = propToCreateCard;
        setValues(propToCreateCard);
    }

    /*****************************************************************
     Helper method to set the values for the specific property

     @param prop
     *****************************************************************/
    private void setValues(PropertySpaces prop) {
        propToCreateCard = prop;
        if (prop.propName1.equals("MEDITERRANEAN")) {
            rent = 2;
            rentOneHouse = 10;
            rentTwoHouses = 30;
            rentThreeHouses = 90;
            rentFourHouses = 160;
            rentHotel = 250;
            mortgageVal = 30;
            houseCost = 50;
            hotelCost = 50;
            totalBuy = 250;
        } else if (prop.propName1.equals("BALTIC")) {
            rent = 4;
            rentOneHouse = 20;
            rentTwoHouses = 60;
            rentThreeHouses = 180;
            rentFourHouses = 320;
            rentHotel = 450;
            mortgageVal = 30;
            houseCost = 50;
            hotelCost = 50;
            totalBuy = 250;
        } else if (prop.propName1.equals("ORIENTAL") || prop.propName1.equals("VERMONT")) {
            rent = 6;
            rentOneHouse = 30;
            rentTwoHouses = 90;
            rentThreeHouses = 270;
            rentFourHouses = 400;
            rentHotel = 550;
            mortgageVal = 50;
            houseCost = 50;
            hotelCost = 50;
            totalBuy = 250;
        } else if (prop.propName1.equals("CONNECTICUT")) {
            rent = 8;
            rentOneHouse = 40;
            rentTwoHouses = 100;
            rentThreeHouses = 300;
            rentFourHouses = 450;
            rentHotel = 600;
            mortgageVal = 60;
            houseCost = 50;
            hotelCost = 50;
            totalBuy = 250;
        } else if (prop.propName1.equals("ST. CHARLES") || prop.propName1.equals("STATES")) {
            rent = 10;
            rentOneHouse = 50;
            rentTwoHouses = 150;
            rentThreeHouses = 450;
            rentFourHouses = 625;
            rentHotel = 750;
            mortgageVal = 70;
            houseCost = 100;
            hotelCost = 100;
            totalBuy = 500;
        } else if (prop.propName1.equals("VIRGINIA")) {
            rent = 12;
            rentOneHouse = 60;
            rentTwoHouses = 180;
            rentThreeHouses = 500;
            rentFourHouses = 700;
            rentHotel = 900;
            mortgageVal = 70;
            houseCost = 100;
            hotelCost = 100;
            totalBuy = 500;
        } else if (prop.propName1.equals("ST. JAMES") || prop.propName1.equals("TENNESSEE")) {
            rent = 14;
            rentOneHouse = 70;
            rentTwoHouses = 200;
            rentThreeHouses = 550;
            rentFourHouses = 750;
            rentHotel = 950;
            mortgageVal = 90;
            houseCost = 100;
            hotelCost = 100;
            totalBuy = 500;
        } else if (prop.propName1.equals("NEW YORK")) {
            rent = 16;
            rentOneHouse = 80;
            rentTwoHouses = 220;
            rentThreeHouses = 600;
            rentFourHouses = 800;
            rentHotel = 1000;
            mortgageVal = 100;
            houseCost = 100;
            hotelCost = 100;
            totalBuy = 500;
        } else if (prop.propName1.equals("KENTUCKY") || prop.propName1.equals("INDIANA")) {
            rent = 18;
            rentOneHouse = 90;
            rentTwoHouses = 250;
            rentThreeHouses = 700;
            rentFourHouses = 875;
            rentHotel = 1050;
            mortgageVal = 110;
            houseCost = 150;
            hotelCost = 150;
            totalBuy = 750;
        } else if (prop.propName1.equals("ILLINOIS")) {
            rent = 20;
            rentOneHouse = 100;
            rentTwoHouses = 300;
            rentThreeHouses = 750;
            rentFourHouses = 925;
            rentHotel = 1100;
            mortgageVal = 120;
            houseCost = 150;
            hotelCost = 150;
            totalBuy = 750;
        } else if (prop.propName1.equals("ATLANTIC") || prop.propName1.equals("VENTNOR")) {
            rent = 22;
            rentOneHouse = 110;
            rentTwoHouses = 330;
            rentThreeHouses = 800;
            rentFourHouses = 975;
            rentHotel = 1150;
            mortgageVal = 130;
            houseCost = 150;
            hotelCost = 150;
            totalBuy = 750;
        } else if (prop.propName1.equals("MARVIN")) {
            rent = 24;
            rentOneHouse = 120;
            rentTwoHouses = 360;
            rentThreeHouses = 850;
            rentFourHouses = 1025;
            rentHotel = 1200;
            mortgageVal = 140;
            houseCost = 150;
            hotelCost = 150;
            totalBuy = 750;
        } else if (prop.propName1.equals("PACIFIC") || prop.propName1.equals("NORTH")) {
            rent = 26;
            rentOneHouse = 130;
            rentTwoHouses = 390;
            rentThreeHouses = 900;
            rentFourHouses = 1100;
            rentHotel = 1275;
            mortgageVal = 150;
            houseCost = 200;
            hotelCost = 200;
            totalBuy = 1000;
        } else if (prop.propName1.equals("PENNSYLVANIA") && prop.propName2.equals("AVENUE")) {
            rent = 28;
            rentOneHouse = 150;
            rentTwoHouses = 450;
            rentThreeHouses = 1000;
            rentFourHouses = 1200;
            rentHotel = 1400;
            mortgageVal = 160;
            houseCost = 200;
            hotelCost = 200;
            totalBuy = 1000;
        } else if (prop.propName1.equals("PARK")) {
            rent = 35;
            rentOneHouse = 175;
            rentTwoHouses = 500;
            rentThreeHouses = 1100;
            rentFourHouses = 1300;
            rentHotel = 1500;
            mortgageVal = 175;
            houseCost = 200;
            hotelCost = 200;
            totalBuy = 1000;
        } else if (prop.propName1.equals("BOARD")) {
            rent = 50;
            rentOneHouse = 200;
            rentTwoHouses = 600;
            rentThreeHouses = 1400;
            rentFourHouses = 1700;
            rentHotel = 2000;
            mortgageVal = 200;
            houseCost = 200;
            hotelCost = 200;
            totalBuy = 1000;
        } else if (propToCreateCard.propName2.equals("RAILROAD")) {
            rent = 25;
            rentOneHouse = 25;
            rentTwoHouses = 50;
            rentThreeHouses = 100;
            rentFourHouses = 200;
            rentHotel = 0;
            mortgageVal = 100;
            houseCost = 0;
            hotelCost = 0;
            totalBuy = 0;
        } else if (propToCreateCard.propName1.equals("ELECTRIC") || propToCreateCard.propName1.equals("WATER")) {
            rent = d.getRollAmount()*4;
            rentOneHouse = d.getRollAmount()*4;
            rentTwoHouses = d.getRollAmount()*10;
            rentThreeHouses = 0;
            rentFourHouses = 0;
            rentHotel = 0;
            mortgageVal = 0;
            houseCost = 0;
            hotelCost = 0;
            totalBuy = 0;
        }
    }

    /*****************************************************************
     Method to get the property of a given card

     @return PropertySpaces
     *****************************************************************/
    public PropertySpaces getPropOfCard() {
        return this.propToCreateCard;
    }

    /*****************************************************************
     Method to get the rent amount for a property

     @return this.rent
     *****************************************************************/
    public int getRent() {
        return this.rent;
    }

    /*****************************************************************
     Method to get the rent amount for a property with one house

     @return this.rentOneHouse
     *****************************************************************/
    public int getRentOneHouse() {
        return this.rentOneHouse;
    }

    /*****************************************************************
     Method to get the rent amount for a property with two houses

     @return this.rentTwoHouses
     *****************************************************************/
    public int getRentTwoHouses() {
        return this.rentTwoHouses;
    }

    /*****************************************************************
     Method to get the rent amount for a property with three houses

     @return this.rentThreeHouses
     *****************************************************************/
    public int getRentThreeHouses() {
        return this.rentThreeHouses;
    }

    /*****************************************************************
     Method to get the rent amount for a property with four houses

     @return this.rentFourHouses
     *****************************************************************/
    public int getRentFourHouses() {
        return this.rentFourHouses;
    }

    /*****************************************************************
     Method to get the rent amount for a property with a hotel

     @return this.rentHotel
     *****************************************************************/
    public int getRentHotel() {
        return this.rentHotel;
    }

    /*****************************************************************
     Method to get a property's mortgage value

     @return this.mortgageVal
     *****************************************************************/
    public int getMortgageVal() {
        return this.mortgageVal;
    }
}
