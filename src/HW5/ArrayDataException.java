package HW5;

public class ArrayDataException extends RuntimeException {

    private int row;
    private int column;

    public ArrayDataException(int row, int column) {
        super(String.format("Incorrect value in %s row and %s column", row + 1, column + 1));
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
