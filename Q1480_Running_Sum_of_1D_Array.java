import java.util.Arrays;

public class Q1480_Running_Sum_of_1D_Array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        return sum;
    }
}
