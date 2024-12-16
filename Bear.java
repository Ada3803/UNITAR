import java.awt.Color;
import java.util.Random;

public class Bear extends Critter {
    private boolean polar;
    private int moveCount;

    public Bear(boolean polar) {
        this.polar = polar;
        this.moveCount = 0;
    }

    @Override
    public Color getColor() {
        if (polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public String toString() {
        moveCount++;
        if (moveCount % 2 == 1) {
            return "/";
        } else {
            return "\\";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}