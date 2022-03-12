import java.util.Arrays;

public class CodeExplanation {
    public static void main(String[] args) {

        int[][] twoDimArray = {
                {0,0,9,9},
                {1,2,3,4},
                {5,6,7,8},
        };
        Character.toLowerCase('A');
        
        int rows = twoDimArray.length;
        int columns = twoDimArray[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns/ 2; j++) {

                int temp = twoDimArray[i][j];

                int currentColumn = columns - 1 - j;
                twoDimArray[i][j] = twoDimArray[i][currentColumn];

                twoDimArray[i][columns - 1 - j] = temp;
            }
        }


        System.out.println(Arrays.toString(twoDimArray[0]));
        System.out.println(Arrays.toString(twoDimArray[1]));
        System.out.println(Arrays.toString(twoDimArray[2]));

    }

}
