import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10818 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution sol = new Solution();

        try {
            int N = Integer.parseInt(br.readLine());

            int[] input = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] output = sol.findMinMax(input);

            System.out.println(Arrays.toString(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    public int[] findMinMax(int[] input) {
        int min = Arrays.stream(input).min().orElse(0);
        int max = Arrays.stream(input).max().orElse(0);

        return new int[]{min, max};
    }
}
