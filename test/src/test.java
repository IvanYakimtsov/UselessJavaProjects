import java.io.*;

public class test {
    public static void main(String[] args) {
     rec(1);
    }

    public static void rec(int x){
        if(x==5){
            System.out.println(x);
        }
        if(x<5){
            System.out.println(x);
            x++;
            rec(x);
        }

    }

    public static int find(int[] arr, int x,int low, int height) {
     //   int i = -1;

        while (low < height) {
            int mid = (low + height) / 2;
            if(x == arr[mid]){
               return mid;
            } else  if(x < arr[mid]){
                height = mid;
            } else low = mid + 1;

        }
        return -1;
    }
}

