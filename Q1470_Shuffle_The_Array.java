import java.util.Arrays;

public class Q1470_Shuffle_The_Array {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }

    static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int pointer1 = 0;
        int pointer2 = n;
        for(int i=0; i<2*n; i++) {
            if(i%2 == 0) {
                ans[i] = nums[pointer1];
                pointer1++;
            }
            else {
                ans[i] = nums[pointer2];
                pointer2++;
            }
        }
        return ans;
    }
}
