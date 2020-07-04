import java.util.Arrays;

public class MainClass extends Throwable{

    private static final int numForCheck_1 = 1;
    private static final int numForCheck_2 = 4;

    public static int[] arrayToReturn(int[] inputArray) {
        int count = 0;
        int position = 0;
        int[] outputArray;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == numForCheck_2) {
                count++;
                position = i;
            }
        }
        if (count == 0) {
            throw new RuntimeException("В массиве нет числа '4'!");
        } else {
            outputArray = Arrays.copyOfRange(inputArray, position + 1, inputArray.length);
        }
        return outputArray;
    }

    public static boolean arrayToCheck(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == numForCheck_1 || inputArray[i] == numForCheck_2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 8, 5};
        System.out.println(Arrays.toString(arrayToReturn(array)));
    }
}
