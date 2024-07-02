package test;

import ClassWork.Multiplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MultiplicationTest {

    @Test
    public void testMultiplyArray() {
        Multiplication multiplication = new Multiplication();
        int[] input = {2,3,5,2,5,3};
        int[] expectedOutput = {4,6,10,4,10,6};
        int[] actualOutput = multiplication.multiplyByIndex(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}

