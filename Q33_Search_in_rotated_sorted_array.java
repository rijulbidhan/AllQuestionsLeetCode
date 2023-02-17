public class Q33_Search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));
    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        //if you don't find a pivot, this would mean the array is not rotated.
        if (pivot == -1) {
            //just do normal binary search as array is not rotated.
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        //if pivot element is found, then we have founded two ascending sorted arrays.
        //3 cases here.
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }


    static int findPivot(int[] nums) { //this will not work in duplicate elements.
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            //four cases here for finding the pivot element.
            if (mid < end && nums[mid] > nums[mid + 1]) { //if the middle element is greater than the mid+1 element, this means mid is the pivot element, and after this smaller elements lies. So we return mid. And we also added the condition mid < end, because otherwise if mid happened to be the last element of the array, then accessing mid+1 element would give us the error "Index out of bounds" message.
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) { //if mid-1 element is greater than the mid element, this means that mid-1 is the pivot element we are looking for as this is a sorted array before mid-1. So we return mid-1, and we also added the condition mid > start, because otherwise if mid happened to be the starting index, then mid-1 would display us the error "Index out of bounds" message.
                return mid - 1;
            }
            if (nums[mid] <= nums[start]) { //If the starting elements are greater than the middle element, then there is no need for us to be searching in the later part of the array(i.e. after mid).
                end = mid - 1;
            } else { //If nums[start] < nums[mid}, this is a sorted array, it may be possible that more bigger numbers will lie ahead of it. Because if start<mid, if this was the pivot, then it would have been caught in the first two cases. So as it was not caught, so definitely more bigger numbers will lie ahead of it. So I can search in the second part of the array now. So after middle now we are searching.
                start = mid + 1;
            }
        }
        return -1; //element not found.
    }

    static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            //if elements at start, mid, end are equal, then just skip the duplicates.
            if (nums[mid] == nums[start] && nums[mid] == nums[end]){
                //skip the duplicates.
                //NOTE: what if these elements at start and end were the pivots.
                //check if start is pivot
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                //now, check if end is pivot
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right.
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; //no pivot found, i.e. array is not rotated.
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
