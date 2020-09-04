package Ship;

import java.util.Random;

import static Field.Field.field;

public class ComputerShip {
    static int oneDeck = 4;
    static int twoDeck = 3;
    static int threeDeck = 2;
    static int fourDeck = 1;

    private static final Random random = new Random();

    public static void placeShipsComputer(String playerName, int[][] battlefield) {
        field(battlefield);

        setShip(battlefield, oneDeck, playerName);
        field(battlefield);

        setShip(battlefield, twoDeck, playerName);
        field(battlefield);

        setShip(battlefield, threeDeck, playerName);
        field(battlefield);

        setShip(battlefield, fourDeck, playerName);
        field(battlefield);
    }


    private static void setShip(int[][] battlefield, int deck, String playerName) {
        int ship = 0;

        if (deck == 1) {
            ship = 4;
        } else if (deck == 2) {
            ship = 3;
        } else if (deck == 3) {
            ship = 2;
        } else if (deck == 4) {
            ship = 1;
        }

        System.out.println(playerName + ", установите " + ship + " палубный корабль");

        int i = 1;
        int x, y;
        while (i <= deck) {
            x = random.nextInt(10);

            y = random.nextInt(10);

            int rotation = random.nextInt(2);

            if (!location(x, y, ship, rotation)) {
                continue;
            }

            for (int a = 0; a < ship; a++) {
                if (rotation == 1) {
                    battlefield[x + a][y] = 1;
                } else {
                    battlefield[x][y + a] = 1;
                }
            }

            ++i;
        }
    }

    private static boolean location(int x, int y, int deck, int rotation) {

        if (rotation == 1) {
            if (x + deck > 10) {
                return false;
            }
        }

        if (rotation == 2) {
            if (y + deck > 10) {
                return false;
            }
        }

        return true;
    }
}
