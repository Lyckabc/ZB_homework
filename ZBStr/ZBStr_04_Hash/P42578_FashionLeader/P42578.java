package P42578;

import java.util.HashMap;
import java.util.LinkedList;

public class P42578 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int answer = 0;
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1]) ) {
                map.put(clothes[i][1], new List<>());
            }
            map.get(clothes[i][1]).add(clothes[i][0]);

        }
        return answer;
    }
}