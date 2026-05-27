package algorithms.candycrushamazontest;

import java.util.List;

public class CandyCrushAmazon {

    List<Integer> execute(List<Integer> column, int minToRemove) {
        boolean hasItemRemoved = false;
        for (int i = 0; i < column.size(); i++) {
            int counter = 0;
            for (int j = i; (j < column.size()); j++) {
                if (!column.get(i).equals(column.get(j))) {
                    break;
                } else counter++;
            }
            if (counter >= minToRemove) {
                System.out.println(column);
                int end = i + counter;
                for (int j = i; (j < end); j++) {
                    if (j < column.size()) {
                        hasItemRemoved = true;
                        column.remove(j);
                        j--;
                        end--;
                    }
                }
            }
        }

        if (hasItemRemoved)
            return execute(column, minToRemove);
        else {
            System.out.println(column);
            return column;
        }
    }
}
