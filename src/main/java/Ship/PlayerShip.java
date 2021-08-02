package Ship;

import Field.Field;

import java.util.Scanner;


public class PlayerShip implements Location, Ship {

    static Scanner in = new Scanner(System.in);

    public void placeShipsPlayer(String playerName, int[][] fieldShip) {
        Field field = new Field();

        for (int i = 4; i >= 1; i--) {
            setShip(fieldShip, i, playerName);
            field.field(fieldShip);
        }

    }

    private void setShip(int[][] field, int deck, String playerName) {
        int ship = getShipNumber(deck);

        System.out.println(playerName + ", установите " + ship + " палубный корабль");

        int i = 1;
        int x, y;
        while (i <= deck) {
            System.out.print("Введите X координату для вашего " + i + " корабля: ");
            x = in.nextInt();
            while (x < 0 || x > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите X координату для вашего " + i + " корабля: ");
                x = in.nextInt();
            }

            System.out.print("Введите Y координату для вашего " + i + " корабля: ");
            y = in.nextInt();
            while (y < 0 || y > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите Y координату для вашего " + i + " корабля: ");
                y = in.nextInt();
            }

            System.out.println("Выберите направление оси корабля: ");
            System.out.println("1. Вертикально.");
            System.out.println("2. Горизонтально.");
            int rotation = in.nextInt();

            while (rotation < 1 || rotation > 2) {
                System.out.println("Невалидное значение!");
                System.out.print("Выберите валидное направление оси корабля: ");
                rotation = in.nextInt();
            }

            if (!locationShip(x, y, ship, rotation, field)) {
                System.out.println("Невалидное расположение корабля " + i + ", установите новые координаты!");
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
