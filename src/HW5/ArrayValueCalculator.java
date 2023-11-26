package HW5;

import java.util.Arrays;

public class ArrayValueCalculator {

    public void doCalc(Object[][] arrayInt) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        if (arrayInt.length != 4 || Arrays.stream(arrayInt).anyMatch(row -> row.length != 4)) {
            throw new ArraySizeException();
        }
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = 0; j < arrayInt[i].length; j++) {
                sum += parseObjectToInt(arrayInt[i][j], i, j);
            }
        }
        System.out.println(sum);
    }

    private int parseObjectToInt(Object value, int row, int column) throws ArrayDataException {
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            throw new ArrayDataException(row, column);
        }
    }
}
