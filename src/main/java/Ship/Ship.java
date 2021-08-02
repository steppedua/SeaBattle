package Ship;

public interface Ship {

    default int getShipNumber(int deck) {
        int ship;

        switch (deck) {
            case 1:
                ship = 4;
                break;
            case 2:
                ship = 3;
                break;
            case 3:
                ship = 2;
                break;
            case 4:
                ship = 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + deck);
        }
        return ship;
    }
}
