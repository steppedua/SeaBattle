package Ship;

import java.util.Scanner;

import static Field.Field.field;


public class PlayerShip {

    static int oneDeck = 4;
    static int twoDeck = 3;
    static int threeDeck = 2;
    static int fourDeck = 1;
    static Scanner in = new Scanner(System.in);

    public static void placeShipsPlayer(String playerName, int[][] battlefield) {
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
            System.out.print("Введите X координату для вашего " + i + ". корабля: ");
            x = in.nextInt();
            while (x < 0 || x > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите X координату для вашего " + i + ". корабля: ");
                x = in.nextInt();
            }

            System.out.print("Введите Y координату для вашего " + i + ". корабля: ");
            y = in.nextInt();
            while (y < 0 || y > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите Y координату для вашего " + i + ". корабля: ");
                y = in.nextInt();
            }

            System.out.println("Выберите направление оси корабля:");
            System.out.println("1. Вертикально.");
            System.out.println("2. Горизонтально.");
            int direction = in.nextInt();

            for (int a = 0; a < ship; a++) {
                if (direction == 1) {
                    battlefield[x + a][y] = 1;
                } else {
                    battlefield[y][x + a] = 1;
                }
            }

            ++i;
        }
    }
}
