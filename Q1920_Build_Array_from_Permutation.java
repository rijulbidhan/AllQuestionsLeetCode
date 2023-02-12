import java.util.Arrays;

public class Q1920_Build_Array_from_Permutation {
    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 2, 3, 4};
        System.out.println("The required array is");
        System.out.println(Arrays.toString(buildArray(nums)));
    }

    static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
