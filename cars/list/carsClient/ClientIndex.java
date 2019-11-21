package cars.list.carsClient;

public class ClientIndex {
    public static int index = 0;

    public static int getIndex() {
        index ++;
        return index;
    }
}
