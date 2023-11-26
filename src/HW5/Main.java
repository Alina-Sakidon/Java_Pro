package HW5;


public class Main {
    public static void main(String[] args) throws ArraySizeException, ArrayDataException {

        Object distances[][] = {
                {10, 10, 5, 10},
                {50, 0, 70, 110},
                {100, 70, 0, 200},
                {20, 110, 200, 100}
        };
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        arrayValueCalculator.doCalc(distances);
    }
}

