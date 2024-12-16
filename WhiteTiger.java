import java.awt.Color;

public class WhiteTiger extends Critter {
    private boolean hasInfected;
    private int moveCount;

    public WhiteTiger() {
        this.hasInfected = false;
        this.moveCount = 0;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        if (hasInfected) {
            return "TGR";
        } else {
            return "tgr";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        moveCount++;
        if (info.frontThreat()) {
            hasInfected = true;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}