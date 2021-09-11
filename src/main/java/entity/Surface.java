package entity;

public class Surface {
    private String name;
    private int maxX;
    private int maxY;
    private Object[][] space;

    public void placeObject(int x, int y, Object o) throws ArrayIndexOutOfBoundsException {
        space[x][y] = o;
    }

    public boolean hasObject() {
        for (int x = 0; x <= maxX; x++) {
            for (int y = 0; y <= maxY; y++) {
                if (space[x][y] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValidCoordinates(int x, int y) {
        return x <= maxX && x >= 0 && y <= maxY && y >= 0;
    }

    public void initializeSpace() {
        this.space = new Object[(this.maxX + 1)][(this.maxY + 1)];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public Object[][] getSpace() {
        return space;
    }


}
