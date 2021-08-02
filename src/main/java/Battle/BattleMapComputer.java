package Battle;

import java.util.Random;

public class BattleMapComputer implements BattleMap {

    private static final Random random = new Random();

    public void battleMapComputer(String computerName, int[][] battleMap, int[][] battleField) {

        while (true) {
            battleMapShow(computerName, battleMap);

            int x = random.nextInt(10);

            int y = random.nextInt(10);

            if (battleField[x][y] == 1) {
                System.out.println("Компьютер попал!");
                battleMap[x][y] = 2;
            } else {
                System.out.println("Компьютер промахнулся! Ход переходит к игроку");
                battleMap[x][y] = 1;
                break;
            }
        }
    }
}
