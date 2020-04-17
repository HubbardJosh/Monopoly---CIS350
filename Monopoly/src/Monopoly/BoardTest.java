package Monopoly;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

    public void testGetPropertyOfCurrPosition() {
        Board testBoard = new Board();

        assertTrue(testBoard.getPropertyOfCurrPosition().propName1.equals("GO"));
    }

    public void testGetPropertyList() {
        Board testBoard = new Board();

        assertTrue(testBoard.getPropertyList().size() == 40);
    }

    public void testRollDice() {
        Board testBoard = new Board();
        int prevPos = testBoard.getModel().getCurrentPlayer().getPosition();

        testBoard.getRollButton().doClick();

        int afterPos = testBoard.getModel().getPreviousPlayer().getPosition();

        assertTrue(afterPos > prevPos);
    }
}