package Field;

public class Field {

    public static void Field(int[][] field) {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < field.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < field[1].length; j++) {
                if (field[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
