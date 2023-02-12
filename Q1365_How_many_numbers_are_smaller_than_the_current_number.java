import java.util.Arrays;

public class Q1365_How_many_numbers_are_smaller_than_the_current_number {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.fill(count, 0);
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[i] > nums[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
}
