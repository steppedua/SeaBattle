package Ship;

import Field.Field;

import java.util.Random;

public class ComputerShip implements Location, Ship {

    static Random random = new Random();

    public void placeShipsComputer(String playerName, int[][] fieldShip) {
        Field field = new Field();
        field.field(fieldShip);

        for (int i = 4; i >= 1; i--) {
            setShip(fieldShip, i, playerName);
        }

        field.field(fieldShip);
    }


    private void setShip(int[][] field, int deck, String playerName) {
        int ship = getShipNumber(deck);

        System.out.println(playerName + ", установите " + ship + " палубный корабль");

        int i = 1;
        int x, y;
        while (i <= deck) {
            x = random.nextInt(10);

            y = random.nextInt(10);

            int rotation = random.nextInt(2) + 1;

            if (!locationShip(x, y, ship, rotation, field)) {
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
}
