import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Test {
    private MainClass mainClass;

    @BeforeEach
    public void init() {
        mainClass = new MainClass();
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6,71,123,4,1','1'",
            "'3,5,7,9,1,4,13,54,3,74', '13,54,3,74'",
            "'1,43,6,123,4,78,3,6','78,3,6'",
            "'4,6,2,4,6,7,98,43,4,123,3,5', '123,3,5'"
    })

    public void testArrayToReturn(String strInput, String strResult) {
        String[] str1 = strInput.split(",");
        int[] arrInput = new int[str1.length];

        String[] str2 = strResult.split(",");
        int[] arrResult = new int[str2.length];

        for (int i = 0; i < str1.length; i++) {
            arrInput[i] = Integer.parseInt(str1[i]);
        }

        for (int i = 0; i < str2.length; i++) {
            arrResult[i] = Integer.parseInt(str2[i]);
        }

        Assertions.assertArrayEquals(arrResult, MainClass.arrayToReturn(arrInput));
    }

    @org.junit.jupiter.api.Test
    public void testArrayToReturnException() {
        final int[] arrInput = {1, 2, 3, 5, 6, 7, 1234};
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                mainClass.arrayToReturn(arrInput);
            }
        });
    }

    @org.junit.jupiter.api.Test
    public void testArrayToCheck_1() {
        int[] arrInput = {1, 234, 5, 1234, 4, 3};
        Assertions.assertTrue(mainClass.arrayToCheck(arrInput));
    }

    @org.junit.jupiter.api.Test
    public void testArrayToCheck_2() {
        int[] arrInput = {3, 234, 5, 1234, 6, 3, 1};
        Assertions.assertTrue(mainClass.arrayToCheck(arrInput));
    }

    @org.junit.jupiter.api.Test
    public void testArrayToCheck_3() {
        int[] arrInput = {3, 234, 5, 1234, 6, 3, 71};
        Assertions.assertFalse(mainClass.arrayToCheck(arrInput));
    }
}
