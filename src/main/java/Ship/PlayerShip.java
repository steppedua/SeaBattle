package Ship;

import java.util.Scanner;

import static Field.Field.field;


public class PlayerShip {

    static Scanner in = new Scanner(System.in);

    public static void placeShipsPlayer(String playerName, int[][] field) {
        field(field);

        for (int i = 4; i >= 1; i--) {
            setShip(field, i, playerName);
            field(field);
        }

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

            if (!location(x, y, ship, rotation, field)) {
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
