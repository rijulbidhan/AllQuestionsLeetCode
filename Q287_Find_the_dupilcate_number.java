public class Q287_Find_the_dupilcate_number {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }

    static int findDuplicate(int[] nums) {
        int i=0;
        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        //searching the duplicate element.
        for(int index=0; index<nums.length; index++) {
            if(nums[index] != index+1) {
                return nums[index];
            }
        }
        return -1; //no duplicate element found.
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
