package Battle;

public interface BattleMap {

    default void battleMapShow(String name, int[][] battleMap) {
        System.out.println(name + " , осуществите свой ход.");
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
    }
}
