package Battle;

import Ship.ComputerShip;
import Ship.PlayerShip;

import java.util.Scanner;


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
        new PlayerShip().placeShipsPlayer(playerName, fieldPlayer);

        String computerName = "Cyborg";
        System.out.println("Имя компьютера: " + computerName);
        System.out.println("Карта компьютера:");
        new ComputerShip().placeShipsComputer(computerName, fieldComputer);

        System.out.println("Начало сражения");

        while (true) {

            new BattleMapPlayer().battleMapPlayer(playerName, battleMapPlayer, fieldComputer);
            if (new Battle().isWin(playerName, computerName)) {
                break;
            }

            new BattleMapComputer().battleMapComputer(computerName, battleMapComputer, fieldPlayer);
            if (new Battle().isWin(playerName, computerName)) {
                break;
            }
        }

        System.out.println("Конец сражения");
    }

    private boolean isWin(String playerName, String computerName) {
        int countPlayer = getCount(battleMapPlayer);

        int countComputer = getCount(battleMapComputer);

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

    private int getCount(int[][] battleMapPlayer) {
        int countPlayer = 0;
        for (int i = 0; i < battleMapPlayer.length; i++) {
            for (int j = 0; j < battleMapPlayer[1].length; j++) {
                if (battleMapPlayer[i][j] == 2) {
                    countPlayer++;
                }
            }
        }
        return countPlayer;
    }
}
