public class Q852_Peak_index_in_a_mountain_array {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 4, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    //Linear Search
    static int maximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    //Binary Search Approach
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]) {
                //this means you are in the decreasing part of the array.
                //this might be the answer, but you have to check left as well. This is why end != mid-1.
                end = mid;
            } else {
                //you are in the incresing/ascending part of the array, i.e., arr[mid] < arr[mid+1]
                start = mid + 1; //because we know that mid+1 element > mid element.
            }
        }
        //In the end, start == end, and it is pointing to the largest number because of the two checks above.
        //start and end are always trying to find max element in the above two checks.
        //Hence, when they are pointing to just one element, that is the maximum one because that is what the checks say.
        //More elaboration: at every point of time of start and end, they have the best possible answer till that point of time.
        //and if we are saying that only one item is remaining, because of the above line, hence that is the best possible answer.
        return start; //or return end; as start == end
    }
}
