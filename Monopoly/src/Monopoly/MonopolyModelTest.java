package Monopoly;

import junit.framework.TestCase;

public class MonopolyModelTest extends TestCase {

    public void testGetPlayerList() {
        MonopolyModel testModel = new MonopolyModel();

        assertTrue(testModel.getPlayerList().size() == 4);
    }

    public void testGetCurrentPlayer() {
        MonopolyModel testModel = new MonopolyModel();

        assertTrue(testModel.getCurrentPlayer() == testModel.getPlayerList().get(0));
    }

    public void testGetPreviousPlayer1() {
        MonopolyModel testModel = new MonopolyModel();

        assertTrue(testModel.getPreviousPlayer().getPlayerNum() == 4);
    }

    public void testGetPreviousPlayer2() {
        MonopolyModel testModel = new MonopolyModel();

        while(testModel.getCurrentPlayer().getPlayerNum() != 2) {
            testModel.nextPlayer();
        }

        assertTrue(testModel.getPreviousPlayer().getPlayerNum() == 1);
    }

    public void testGetPreviousPlayer3() {
        MonopolyModel testModel = new MonopolyModel();

        while(testModel.getCurrentPlayer().getPlayerNum() != 3) {
            testModel.nextPlayer();
        }

        assertTrue(testModel.getPreviousPlayer().getPlayerNum() == 2);
    }

    public void testGetPreviousPlayer4() {
        MonopolyModel testModel = new MonopolyModel();

        while(testModel.getCurrentPlayer().getPlayerNum() != 4) {
            testModel.nextPlayer();
        }

        assertTrue(testModel.getPreviousPlayer().getPlayerNum() == 3);
    }

    public void testGetNextPlayer1() {
        MonopolyModel testModel = new MonopolyModel();

        assertTrue(testModel.getNextPlayer().getPlayerNum() == 2);
    }

    public void testGetNextPlayer2() {
        MonopolyModel testModel = new MonopolyModel();

        while(testModel.getCurrentPlayer().getPlayerNum() != 2) {
            testModel.nextPlayer();
        }

        assertTrue(testModel.getNextPlayer().getPlayerNum() == 3);
    }

    public void testGetNextPlayer3() {
        MonopolyModel testModel = new MonopolyModel();

        while(testModel.getCurrentPlayer().getPlayerNum() != 3) {
            testModel.nextPlayer();
        }

        assertTrue(testModel.getNextPlayer().getPlayerNum() == 4);
    }

    public void testGetNextPlayer4() {
        MonopolyModel testModel = new MonopolyModel();

        while(testModel.getCurrentPlayer().getPlayerNum() != 4) {
            testModel.nextPlayer();
        }

        assertTrue(testModel.getNextPlayer().getPlayerNum() == 1);
    }

    public void testNextPlayer() {
        MonopolyModel testModel = new MonopolyModel();
        testModel.nextPlayer();

        assertTrue(testModel.getCurrentPlayer() == testModel.getPlayerList().get(1));
    }

    public void testGetDice() {
        MonopolyModel testModel = new MonopolyModel();
        int rolled = testModel.getDice().getRollAmount();

        assertTrue(rolled > 1 && rolled < 13);
    }

    public void testUpdatePlayerLocation1() {
        MonopolyModel testModel = new MonopolyModel();
        int numToMove = testModel.getDice().getRollAmount();
        testModel.getCurrentPlayer().changePosition(numToMove);

        assertTrue(testModel.getCurrentPlayer().getPosition() == numToMove);
    }

    public void testUpdatePlayerLocation2() {
        MonopolyModel testModel = new MonopolyModel();
        int startMoney = testModel.getCurrentPlayer().getMoney();
        boolean passedGo = false;
        while (testModel.getCurrentPlayer().getPosition() != 4) {
            startMoney = testModel.getCurrentPlayer().getMoney();
            if (testModel.getCurrentPlayer().getPosition() > 4) {
                passedGo = true;
            } else {
                passedGo = false;
            }
            testModel.updatePlayerLocation(testModel.getCurrentPlayer());
        }

        if (passedGo) {
            assertTrue(testModel.getCurrentPlayer().getMoney() == (startMoney));
        } else {
            assertTrue(testModel.getCurrentPlayer().getMoney() == (startMoney - 200));
        }

    }

//    public void testUpdatePlayerLocation3() {
//        MonopolyModel testModel = new MonopolyModel();
//        int startMoney = testModel.getCurrentPlayer().getMoney();
//        while (testModel.getCurrentPlayer().getPosition() != 38) {
//            startMoney = testModel.getCurrentPlayer().getMoney();
//            testModel.updatePlayerLocation(testModel.getCurrentPlayer());
//        }
//
//        assertTrue(testModel.getCurrentPlayer().getMoney() == (startMoney - 100));
//    }

    public void testBuyProperty() {
        MonopolyModel testModel = new MonopolyModel();
        testModel.getCurrentPlayer().setPosition(1);
        testModel.buyProperty();
        assertFalse(testModel.getCurrentPlayer().getPropertyCards().size() == 1);
    }

    public void testRent() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());
//        testModel.getCurrentPlayer().getAllProperties().get(1).addHouseCount(1);


        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 4));
    }

    public void testRent2() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).addHouseCount(1);


        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 20));
    }

    public void testRent3() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).addHouseCount(2);


        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 60));
    }

    public void testRent4() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).addHouseCount(3);


        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 180));
    }

    public void testRent5() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).addHouseCount(4);


        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 320));
    }

    public void testRent6() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).addHouseCount(4);
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setHasHotel(true);


        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 450));
    }

    public void testRent7() {
//        MonopolyModel testModel = new MonopolyModel();
        Board testModel = new Board();
        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(1));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(1).setOwnedBy(testModel.getModel().getCurrentPlayer());

        testModel.getModel().getPlayerList().get(0).addPropCard(testModel.getModel().getCurrentPlayer().getAllProperties().get(0));
        testModel.getModel().getPlayerList().get(0).addPropertySpace(testModel.getModel().getCurrentPlayer().getAllProperties().get(0));
        testModel.getModel().getPlayerList().get(0).getAllProperties().get(0).setOwnedBy(testModel.getModel().getCurrentPlayer());



        int priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
        while (testModel.getModel().getPlayerList().get(2).getPosition() != 3) {
            priorMoney = testModel.getModel().getPlayerList().get(2).getMoney();
            testModel.getRollButton().doClick();
//            testModel.getModel().updatePlayerLocation(testModel.getModel().getPlayerList().get(2));
        }

        assertTrue(priorMoney == (testModel.getModel().getPlayerList().get(2).getMoney() + 8));
    }
}