package Battle;

import java.util.Scanner;

import static Ship.PlayerShip.placeShipsPlayer;

public class Battle {

    static Scanner in = new Scanner(System.in);
    static int[][] fieldComputer = new int[10][10];
    static int[][] fieldPlayer = new int[10][10];

    public static void playGame() {

        System.out.println("Имя игрока?");
        String playerName = in.nextLine();
        System.out.println("Имя игрока: " + playerName);
        System.out.println("Карта игрока:");
        placeShipsPlayer(playerName, fieldPlayer);

//        System.out.println("Имя компьютера?");
//        String computerName = in.nextLine();
//        System.out.println("Имя компьютера: " + computerName);
//        System.out.println("Карта компьютера:");
//        placeShipsComputer(computerName, fieldComputer);
    }
}
