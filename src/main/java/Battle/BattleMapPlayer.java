package Battle;


import java.util.Scanner;

public class BattleMapPlayer implements BattleMap {

    private static final Scanner in = new Scanner(System.in);

    public void battleMapPlayer(String playerName, int[][] battleMap, int[][] battleField) {

        while (true) {
            battleMapShow(playerName, battleMap);

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

            if (battleField[x][y] == 1) {
                System.out.println("Попали! Продолжайте!");
                battleMap[x][y] = 2;
            } else {
                System.out.println("Промахнулись! Ход переходит к компьютеру");
                battleMap[x][y] = 1;
                break;
            }
        }
    }
}
