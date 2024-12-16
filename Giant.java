import java.awt.Color;

public class Giant extends Critter {
    private int moveCount;
    private String[] displayStrings = {"fee", "fie", "foe", "fum"};
    private int currentStringIndex;

    public Giant() {
        this.moveCount = 0;
        this.currentStringIndex = 0;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        moveCount++;
        if (moveCount % 6 == 0) {
            currentStringIndex = (currentStringIndex + 1) % 4;
        }
        return displayStrings[currentStringIndex];
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}