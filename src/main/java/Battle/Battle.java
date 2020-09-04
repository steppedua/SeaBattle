package Battle;

import java.util.Scanner;

import static Battle.BattleMapComputer.battleMapComputer;
import static Battle.BattleMapPlayer.battleMapPlayer;
import static Ship.ComputerShip.placeShipsComputer;
import static Ship.PlayerShip.placeShipsPlayer;

public class Battle {

    static Scanner in = new Scanner(System.in);

    static int[][] fieldComputer = new int[10][10];
    static int[][] fieldPlayer = new int[10][10];

    static int[][] battleMapPlayer = new int[10][10];
    static int[][] battleMapComputer = new int[10][10];


    public static void playGame() {

        System.out.println("Имя игрока?");
        String playerName = in.nextLine();
        System.out.println("Имя игрока: " + playerName);
        System.out.println("Карта игрока:");
        placeShipsPlayer(playerName, fieldPlayer);

        String computerName = "Cyborg";
        System.out.println("Имя компьютера: " + computerName);
        System.out.println("Карта компьютера:");
        placeShipsComputer(computerName, fieldComputer);

        System.out.println("Начало сражения");

        while (true) {

            battleMapPlayer(playerName, battleMapPlayer, fieldComputer);
            if (isWin(playerName, computerName)) {
                break;
            }

            battleMapComputer(computerName, battleMapComputer, fieldPlayer);
            if (isWin(playerName, computerName)) {
                break;
            }
        }

        System.out.println("Конец сражения");
    }

    private static boolean isWin(String playerName, String computerName) {
        int countPlayer = 0;
        for (int i = 0; i < battleMapPlayer.length; i++) {
            for (int j = 0; j < battleMapPlayer[1].length; j++) {
                if (battleMapPlayer[i][j] == 2) {
                    countPlayer++;
                }
            }
        }

        int countComputer = 0;
        for (int i = 0; i < battleMapComputer.length; i++) {
            for (int j = 0; j < battleMapComputer[1].length; j++) {
                if (battleMapComputer[i][j] == 2) {
                    countComputer++;
                }
            }
        }

        if (countPlayer >= 20) {
            System.out.println(playerName + ", победил!");
            return true;
        }

        if (countComputer >= 20) {
            System.out.println(computerName + ", победил!");
            return true;
        }
        return false;
    }
}
