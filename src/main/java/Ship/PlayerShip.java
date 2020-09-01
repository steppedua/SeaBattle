package Ship;

import java.util.Scanner;

import static Field.Field.Field;

public class PlayerShip {

    static int oneDeck = 4;
    static int twoDeck = 3;
    static int threeDeck = 2;
    static int fourDeck = 1;
    static int numberShips = 10;
    static Scanner in = new Scanner(System.in);

    public static void placeShipsPlayer(String playerName, int[][] battlefield) {
        while (numberShips >= 1) {
            Field(battlefield);

            System.out.println("Please enter OX coordinate:");
            int x = in.nextInt();
            System.out.println("Please enter OY coordinate:");
            int y = in.nextInt();

            System.out.println("Choose direction:");
            System.out.println("1. Vertical.");
            System.out.println("2. Horizontal.");
            int direction = in.nextInt();

            for (int i = 0; i < oneDeck; i++) {
                if (direction == 1) {
                    battlefield[x][y + i] = 1;
                } else {}
            }

            for (int i = 0; i < twoDeck; i++) {
                if (battlefield[x][y]) {
                }
            }

            for (int i = 0; i < threeDeck; i++) {
                if (battlefield[x][y]) {
                }
            }

            for (int i = 0; i < fourDeck; i++) {
                if (battlefield[x][y]) {
                }
            }

            numberShips--;
        }
    }
}
