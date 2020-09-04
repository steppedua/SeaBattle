package Battle;

import java.util.Random;

public class BattleMapComputer {

    private static final Random random = new Random();

    public static void battleMapComputer(String computerName, int[][] battleMap, int[][] battleField) {

        while (true) {
            System.out.println(computerName + " , осуществите свой ход.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < battleMap.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < battleMap[1].length; j++) {
                    if (battleMap[i][j] == 0) {
                        System.out.print("- ");
                    } else if (battleMap[i][j] == 1) {
                        System.out.print("O ");
                    } else if (battleMap[i][j] == 2) {
                        System.out.print("X ");
                    }

                }
                System.out.println();
            }


            int x = random.nextInt(10);

            int y = random.nextInt(10);

            if (battleField[y][x] == 1) {
                battleMap[y][x] = 2;
            } else {
                System.out.println("Компьютер промахнулся! Ход переходит к игроку");
                battleMap[y][x] = 1;
                break;
            }
        }
    }
}
