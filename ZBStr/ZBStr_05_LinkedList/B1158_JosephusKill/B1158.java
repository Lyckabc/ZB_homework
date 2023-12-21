package B1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken().trim());
            int K = Integer.parseInt(tokenizer.nextToken().trim());

            sol.JosephusKill(N, K);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    public void JosephusKill(int N, int K) {
        //String healer = new String();
        Queue<Integer> Killer = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            Killer.offer(i);
        }

        System.out.print("<");
        while (!Killer.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                int tmp = Killer.poll();
                Killer.offer(tmp);
            }
            System.out.print(Killer.poll());
            if (Killer.size() != 0) System.out.print(", ");
        }
        System.out.print(">");
    }
}