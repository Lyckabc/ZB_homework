package ZBStr.ZBStr_02_Queue;
//import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1021 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution sol = new Solution();

        try {
//            System.out.printf("작성할 큐 N(사이즈)와 뽑을 M(개수)를 적어주세요: ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

//            System.out.printf("뽑을 숫자(들)를 적어주세요: ");

            int[] cranenum = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                cranenum[i] = Integer.parseInt(st.nextToken());
            }

            LinkedList<Integer> groupN = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                groupN.offer(i);
            }

            int Minimumpoll = sol.RotationQueue(groupN, cranenum);
            System.out.println(Minimumpoll);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    public int RotationQueue(LinkedList<Integer> groupN, int[] cranenum) {
        int cranesize = cranenum.length;
        int count = 0;

        for (int i = 0; i < cranesize; i++) {
            int target_idx = groupN.indexOf(cranenum[i]);
            float half_idx = (float) Math.ceil((float) groupN.size() / 2) - 1;
            System.out.println("target_idx : " + target_idx);
            System.out.println("half_idx : " + half_idx);
            System.out.println("groupN.size() : " + groupN.size());

            if (target_idx > half_idx) {
                for (int j = 0; j < groupN.size() - target_idx; j++) {
                    int tmp = groupN.pollLast();
                    groupN.offerFirst(tmp);
                    count++;
                }
            } else {
                for (int j = 0; j < target_idx; j++) {
                    int tmp = groupN.pollFirst();
                    groupN.offerLast(tmp);
                    count++;
                }
            }
            groupN.pollFirst();
        }
        return count;
    }
}