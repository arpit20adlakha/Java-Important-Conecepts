import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomChar {

    public static void main(String[] args) {
        List<Character> randomCharList = new ArrayList<>();
        // 26 + 10

        for(char c = 'a'; c <= 'z'; c++) {
            randomCharList.add(c);
        }

        Random r = new Random(15);
        int number = r.nextInt();    // a, b, c, d, e
        //0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        char answer = randomCharList.get(number - 10);

    }
}
