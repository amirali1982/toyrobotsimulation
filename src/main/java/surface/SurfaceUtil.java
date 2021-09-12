package surface;

public class SurfaceUtil {

    public static void placeObject(Surface surface, int x, int y, Object o) throws ArrayIndexOutOfBoundsException {
        Object[][] space = surface.getSpace();
        space[x][y] = o;
        surface.setSpace(space);
    }

    public static boolean hasObject(Surface surface) {
        for (int x = 0; x < surface.getSpace().length; x++) {
            for (int y = 0; y < surface.getSpace()[0].length; y++) {
                if (surface.getSpace()[x][y] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidCoordinates(Surface surface, int x, int y) {
        return x < surface.getSpace().length && x >= 0 && y < surface.getSpace()[0].length && y >= 0;
    }

    public static void initializeSpace(Surface surface, int x, int y) {
        Object[][] space = new Object[x][y];
        surface.setSpace(space);
    }
}
