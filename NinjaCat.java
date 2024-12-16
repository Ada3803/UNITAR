import java.awt.Color;

public class NinjaCat extends Critter {
    private int moveCount;
    private Color color;
    private String displayString;

    public NinjaCat() {
        this.moveCount = 0;
        this.color = Color.BLACK;
        this.displayString = "N";
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return displayString;
    }

    @Override
    public Action getMove(CritterInfo info) {
        moveCount++;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else if (info.getLeft() == Neighbor.EMPTY) {
            return Action.LEFT;
        } else {
            return Action.RIGHT;
        }
    }
}