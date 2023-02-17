import java.util.Arrays;

public class Q268_Missing_number {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 0};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr) {
        int i=0;
        while(i<arr.length) {
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //search for the missing number
        for(int index=0; index<arr.length; index++) {
            if(arr[index] != index) {
                return index;
            }
        }

        //case 2
        return arr.length;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
