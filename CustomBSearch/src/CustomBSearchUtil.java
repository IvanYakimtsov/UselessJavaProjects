/**
 * Created by Ivan on 19.09.2017.
 */
public class CustomBSearchUtil {
    public static int bsearch(int[] arr, int x) throws Exception {
        if (arr == null) throw new Exception("Null array");
        if (x < arr[arr.length - 1]) return -1;
        if (x > arr[0]) return arr[0];
        return find(arr, x);
    }

    private static int find(int[] array, int x) {
        int low = 0;
        int high = array.length;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (x <= array[mid]) {
                low = mid + 1;
            } else if (array[mid] < x) {
                high = mid;
            }
        }
        return low;

    }
}
