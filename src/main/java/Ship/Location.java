package Ship;

public interface Location {

    default boolean locationShip(int x, int y, int deck, int rotation, int[][] field) {

        if (rotation == 1 && x + deck > 10) {
            return false;
        } else if (rotation == 2 && y + deck > 10) {
            return false;
        }

        if (field[x][y] == 1) {
            return false;
        }

        return true;
    }
}
