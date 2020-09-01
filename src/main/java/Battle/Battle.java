package Battle;

import java.util.Scanner;

import static Ship.PlayerShip.placeShipsPlayer;

public class Battle {
    static Scanner scanner = new Scanner(System.in);

    static int[][] FieldComputer = new int[10][10];
    static int[][] FieldPlayer = new int[10][10];
    static String playerName = scanner.nextLine();
    static String computerName = scanner.nextLine();


    public static void playGame() {


        System.out.println("Player name:");
        System.out.println("Player Field");
        placeShipsPlayer(playerName, FieldPlayer);



        System.out.println("Computer name:");
        System.out.println("Computer Field");
        placeShipsPlayer(computerName, FieldComputer);
    }
}
