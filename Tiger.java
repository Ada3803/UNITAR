import java.awt.Color;
import java.util.Random;

public class Tiger extends Critter {
    private int moveCount;
    private Color currentColor;
    private Random random;

    public Tiger() {
        this.moveCount = 0;
        this.random = new Random();
        setRandomColor();
    }

    private void setRandomColor() {
        int randomIndex = random.nextInt(3);
        if (randomIndex == 0) {
            currentColor = Color.RED;
        } else if (randomIndex == 1) {
            currentColor = Color.GREEN;
        } else {
            currentColor = Color.BLUE;
        }
    }

    @Override
    public Color getColor() {
        return currentColor;
    }

    @Override
    public String toString() {
        return "TGR";
    }

    @Override
    public Action getMove(CritterInfo info) {
        moveCount++;
        if (moveCount % 3 == 0) {
            setRandomColor();
        }
        if (info.frontThreat()) {
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