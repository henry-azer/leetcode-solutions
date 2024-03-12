import java.util.Arrays;
import java.util.LinkedList;

public class DuplicateZeros {


    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros2(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        int length = arr.length;

        for (int num : arr) {
            if (num == 0) {
                zeros += 1;
            }
        }

        for (int i = length - 1; i >= 0; i -= 1) {
            if (i + zeros < length) {
                arr[i + zeros] = arr[i];
            }
            if (arr[i] == 0) {
                zeros--;
                if (i + zeros < length) {
                    arr[i + zeros] = 0;
                }
            }
        }
    }

    public static void duplicateZeros2(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j : arr) {
            list.add(j);
            if (j == 0) list.add(0);
        }
        for (int i = 0; i < arr.length; i += 1) {
            arr[i] = list.removeFirst();
        }
    }
}
