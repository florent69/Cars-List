package cars.list.cars;

public class CarIndex {
    public static int index = 0;

    public static int getIndex() {
        index ++;
        return index;
    }
}
