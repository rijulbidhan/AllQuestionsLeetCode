import java.util.ArrayList;
import java.util.List;


public class Q1431_Kids_with_the_greatest_number_of_candies {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        System.out.println(kidsWithCandies(candies, 3));
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);

        for (int candy : candies) {
            ans.add(candy + extraCandies >= max(candies));
        }
        return ans;
    }

    static int max(int[] candies) {
        int maximum = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (candy > maximum) {
                maximum = candy;
            }
        }
        return maximum;
    }
}
