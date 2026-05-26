package algorithms.hourglassessum;


import java.util.List;
import java.util.Objects;

class HourGlassesSum {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> matrix) {
        Integer total = null;
        for (int i = 0; i < matrix.size() - 2; i++) {
            for (int j = 0; j < matrix.size() - 2; j++) {
                final var sum = getSumFormHourGlass(i, j, matrix);
                if (total == null) {
                    total = sum;
                } else if (sum > total) {
                    total = sum;
                }
            }
        }
        return Objects.requireNonNull(total);
    }

    static int getSumFormHourGlass(int row, int column, List<List<Integer>> matrix) {
        int sum = 0;
        int halfRow = row + 1;
        int halfColumn = column + 1;
        sum = sum + matrix.get(halfRow).get(halfColumn);
        for (int c = column; c <= column + 2; c++) {
            for (int r = row; r <= row + 2; r++) {
                if (r != halfRow) {
                    sum = sum + matrix.get(r).get(c);
                }
            }
        }
        return sum;
    }

}