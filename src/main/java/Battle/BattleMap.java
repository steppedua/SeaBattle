package Battle;


import java.util.Scanner;

public class BattleMap {

    static Scanner in = new Scanner(System.in);

    public static void battleMap(String playerName, int[][] battleMap, int[][] battleField) {

        while (true) {
            System.out.println(playerName + " , осуществите свой ход.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < battleMap.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < battleMap[1].length; j++) {
                    if (battleMap[i][j] == 0) {
                        System.out.print("- ");
                    } else if (battleMap[i][j] == 1) {
                        System.out.print("O ");
                    } else {
                        System.out.print("X ");
                    }

                }
                System.out.println();
            }

            System.out.print("Введите X координату:");
            int x = in.nextInt();
            while (x < 0 || x > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите X координату для вашего выстрела: ");
                x = in.nextInt();
            }

            System.out.print("Введите Y координату:");
            int y = in.nextInt();
            while (y < 0 || y > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите Y координату для вашего для выстрела: ");
                y = in.nextInt();
            }

            if (battleField[y][x] == 1) {
                System.out.println("Попали! Продолжайте!");
                battleMap[y][x] = 2;
            } else {
                System.out.println("Промахнулись! Ход переходит к сопернику");
                battleMap[y][x] = 1;
                break;
            }
        }
    }
}
