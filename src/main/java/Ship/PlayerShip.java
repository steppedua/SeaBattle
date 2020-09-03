package Ship;

import java.util.Scanner;

import static Field.Field.field;


public class PlayerShip {

    static int oneDeck = 4;
    static int twoDeck = 3;
    static int threeDeck = 2;
    static int fourDeck = 1;
    static Scanner in = new Scanner(System.in);

    public static void placeShipsPlayer(String playerName, int[][] battlefield) {
        field(battlefield);

        setShip(battlefield, oneDeck, playerName);
        field(battlefield);

        setShip(battlefield, twoDeck, playerName);
        field(battlefield);

        setShip(battlefield, threeDeck, playerName);
        field(battlefield);

        setShip(battlefield, fourDeck, playerName);
        field(battlefield);
    }


    private static void setShip(int[][] battlefield, int deck, String playerName) {
        int ship = 0;

        if (deck == 1) {
            ship = 4;
        } else if (deck == 2) {
            ship = 3;
        } else if (deck == 3) {
            ship = 2;
        } else if (deck == 4) {
            ship = 1;
        }

        System.out.println(playerName + ", установите " + ship + " палубный корабль");

        int i = 1;
        int x, y;
        while (i <= deck) {
            System.out.print("Введите X координату для вашего " + i + ". корабля: ");
            x = in.nextInt();
            while (x < 0 || x > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите X координату для вашего " + i + ". корабля: ");
                x = in.nextInt();
            }

            System.out.print("Введите Y координату для вашего " + i + ". корабля: ");
            y = in.nextInt();
            while (y < 0 || y > 9) {
                System.out.println("Невалидное значение!");
                System.out.print("Введите Y координату для вашего " + i + ". корабля: ");
                y = in.nextInt();
            }

            System.out.println("Выберите направление оси корабля:");
            System.out.println("1. Вертикально.");
            System.out.println("2. Горизонтально.");
            int rotation = in.nextInt();

            if (!isLocation(x, y, deck, rotation, battlefield)) {
                System.out.println("Невалидное расположение корабля номер" + i + ", установите новые координаты!");
                continue;
            }

            for (int a = 0; a < ship; a++) {
                if (rotation == 1) {
                    battlefield[x + a][y] = 1;
                } else {
                    battlefield[y][x + a] = 1;
                }
            }

            ++i;
        }
    }

    private static boolean isLocation(int x, int y, int deck, int rotation, int[][] battleMap) {

        if (rotation == 1) {
            if (y + deck > battleMap.length) {
                return false;
            }
        }

        if (rotation == 2) {
            if (x + deck > battleMap[0].length) {
                return false;
            }
        }
        while (deck != 0) {
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;

                if (rotation == 1) {
                    yi = i;
                } else {
                    xi = i;
                }

                if (x + 1 + xi < battleMap.length && x + 1 + xi >= 0) {
                    if (battleMap[x + 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }

                if (x - 1 + xi < battleMap.length && x - 1 + xi >= 0) {
                    if (battleMap[x - 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }
                if (y + 1 + yi < battleMap.length && y + 1 + yi >= 0) {
                    if (battleMap[x + xi][y + 1 + yi] != 0) {
                        return false;
                    }
                }
                if (y - 1 + yi < battleMap.length && y - 1 + yi >= 0) {
                    if (battleMap[x + xi][y - 1 + yi] != 0) {
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }
}
