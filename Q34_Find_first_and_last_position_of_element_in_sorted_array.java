import java.util.Arrays;

public class Q34_Find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 7, 7, 7, 9, 11};
        System.out.println(Arrays.toString(searchRange2(arr, 7)));
    }

    //this is the brute force approach for this question.
    static int[] searchRange1(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        if(nums.length == 1 && nums[0] == target) {
            ans[0] = 0;
            ans[1] = 0;
        }
        if(nums.length > 1)  {
            for(int i=0; i<nums.length; i++) {
                if(nums[i] == target) {
                    ans[0] = i;
                    break;
                }
            }
            for(int j=nums.length-1; j>=0; j--) {
                if(nums[j] == target) {
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    //binary search approach
    static int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1, -1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    //this function just returns the index value of the target.
    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target < nums[mid]) {
                end = mid - 1;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else{ 
                ans = mid;
                if(findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
} 
