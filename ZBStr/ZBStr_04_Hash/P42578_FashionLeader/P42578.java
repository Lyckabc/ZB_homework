package P42578;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class P42578 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        Iterator<Integer> iter = map.values().iterator();

        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }

        return answer - 1;
    }
}