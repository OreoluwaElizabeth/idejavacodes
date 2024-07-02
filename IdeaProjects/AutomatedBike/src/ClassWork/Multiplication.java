package ClassWork;

public class Multiplication {

        public int[] multiplyByIndex(int[] numbers) {
            int[] result = new int[numbers.length];
            for(int count = 0; count < numbers.length; count++) {
                result[count] = numbers[count] * 2;
            }
            return result;
        }
    }

