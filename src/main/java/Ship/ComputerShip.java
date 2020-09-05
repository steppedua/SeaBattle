package Ship;

import java.util.Random;

import static Field.Field.field;

public class ComputerShip {

    static Random random = new Random();

    public static void placeShipsComputer(String playerName, int[][] field) {
        field(field);

        for (int i = 4; i >= 1; i--) {
            setShip(field, i, playerName);
        }

        field(field);
    }


    private static void setShip(int[][] field, int deck, String playerName) {
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

            int rotation = random.nextInt(2) + 1;

            if (!location(x, y, ship, rotation, field)) {
                continue;
            }

            for (int a = 0; a < ship; a++) {
                if (rotation == 1) {
                    field[x + a][y] = 1;
                } else {
                    field[x][y + a] = 1;
                }
            }

            ++i;
        }
    }

    private static boolean location(int x, int y, int deck, int rotation, int[][] field) {

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
