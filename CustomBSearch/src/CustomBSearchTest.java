import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 19.09.2017.
 */
public class CustomBSearchTest {
    private final int ITERATIONS = 100;

    public static void main(String[] args) {
        CustomBSearchTest bSearchTest = new CustomBSearchTest();

        bSearchTest.runSpeedTest(100000, 0, 10);
        bSearchTest.runSpeedTest(100000, 0, 100000);
        bSearchTest.runSpeedTest(100000, -100000, 100000);

        bSearchTest.errorTest();
    }

    public void errorTest() {
        int[] testArray = generateArray(100, 0, 10);

        try {
            assert (10 == CustomBSearchUtil.bsearch(testArray, 11));
            assert (0 == CustomBSearchUtil.bsearch(testArray, -1));
            CustomBSearchUtil.bsearch(null, 7);
        } catch (Exception e) {

        }
        System.out.println("error test passed");
    }

    public void runSpeedTest(int length, int minValue, int maxValue) {
        System.out.println("speed test length " + length + " min value " + minValue + " max value " + maxValue);
        double velocity = 0;
        long testTime = 0;
        long brutForceTestTime = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            int[] testArray = generateArray(length, minValue, maxValue);
            int key = generateInt(minValue, maxValue);
            try {
                brutForceTestTime = System.nanoTime();
                int brutForceBSearchResult = BrutForceSearchUtil.search(testArray, key);
                brutForceTestTime = System.nanoTime() - brutForceTestTime+1;

                testTime = System.nanoTime();
                int customBSearchResult = CustomBSearchUtil.bsearch(testArray, key);
                testTime = System.nanoTime() - testTime+1;

                velocity += 1 - (testTime / brutForceTestTime);
                assert (customBSearchResult == brutForceBSearchResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        velocity = (velocity / ITERATIONS) * 100;
        System.out.println("average velocity " + velocity + "%");
        System.out.println("test passed");
    }

    public int[] generateArray(int length, int minValue, int maxValue) {
        List<Integer> arrayList = new ArrayList<>(length);
        maxValue -= minValue;
        for (int index = 0; index < length; index++)
            arrayList.add(generateInt(minValue, maxValue));
        Collections.sort(arrayList, Collections.reverseOrder());
        Integer[] tmpArray = arrayList.toArray(new Integer[arrayList.size()]);
        return Arrays.stream(tmpArray).mapToInt(Integer::intValue).toArray();
    }

    public int generateInt(int minValue, int maxValue) {
        return (int) Math.round((Math.random() * maxValue) + minValue);
    }
}
