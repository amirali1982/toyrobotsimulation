package entity;

public class ToyRobot {
    private int x;
    private int y;
    private CardinalDirection direction;
    public static final String REPORT_FORMAT = "I'm currently at %d,%d,%s";

    public String getReport() {
        if (this.getDirection() != null) {
            return String.format(REPORT_FORMAT, this.x, this.y, this.getDirection());
        }
        return "";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CardinalDirection getDirection() {
        return direction;
    }

    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }
}
