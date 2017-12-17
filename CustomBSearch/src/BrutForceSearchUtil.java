/**
 * Created by Ivan on 19.09.2017.
 */
public class BrutForceSearchUtil {
    public static int search(int[] arr, int X) throws Exception {
        if (arr == null) throw new Exception("Null array");
        if (X < arr[arr.length - 1]) return -1;
        if (X > arr[0]) return arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < X) return i;
        }
        return -1;
    }
}
