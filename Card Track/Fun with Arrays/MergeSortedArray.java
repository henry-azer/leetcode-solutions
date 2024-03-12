import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1, 2, 3, 0, 0, 0};
        int[] nums4 = {1, 2, 3};
        merge2(nums3, 3, nums4, 3);
        System.out.println(Arrays.toString(nums3));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, i = m + n - 1;
        while (p2 >= 0) {
            nums1[i--] = (p1 >= 0 && nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }
}
