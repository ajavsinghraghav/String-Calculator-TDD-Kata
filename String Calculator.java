import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        numbers = numbers.replaceAll("\n", delimiter);

        String[] numberArray = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String number : numberArray) {
            int value = Integer.parseInt(number);
            if (value < 0) {
                negatives.add(value);
            } else {
                sum += value;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }
}
