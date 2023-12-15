package programmers;

import java.util.*;

public class P12906 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        // General Code
        long startGeneral = System.currentTimeMillis();
        generalCode(arr);
        long endGeneral = System.currentTimeMillis();
        System.out.println("General Code Execution Time: " + (endGeneral - startGeneral) + " ms");

        // Optimization Code
        long startOptimization = System.currentTimeMillis();
        optimizationCode(arr);
        long endOptimization = System.currentTimeMillis();
        System.out.println("Optimization Code Execution Time: " + (endOptimization - startOptimization) + " ms");

        // Simplification Code
        long startSimplification = System.currentTimeMillis();
        simplificationCode(arr);
        long endSimplification = System.currentTimeMillis();
        System.out.println("Simplification Code Execution Time: " + (endSimplification - startSimplification) + " ms");

        // General Code
        long startGeneralMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        generalCode(arr);
        long endGeneralMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("General Code Memory Usage: " + (endGeneralMemory - startGeneralMemory) / (1024 * 1024) + " MB");

        // Optimization Code
        long startOptimizationMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        optimizationCode(arr);
        long endOptimizationMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Optimization Code Memory Usage: " + (endOptimizationMemory - startOptimizationMemory) / (1024 * 1024) + " MB");

        // Simplification Code
        long startSimplificationMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        simplificationCode(arr);
        long endSimplificationMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Simplification Code Memory Usage: " + (endSimplificationMemory - startSimplificationMemory) / (1024 * 1024) + " MB");
    }

    // General Code
    private static void generalCode(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty() || i != stack.peek()) {
                list.add(i);
                stack.push(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
    }

    // Optimization Code
    private static void optimizationCode(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty() || i != stack.peek()) {
                list.add(i);
                stack.push(i);
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index++] = num;
        }
    }

    // Simplification Code
    private static void simplificationCode(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(arr)
                .filter(i -> stack.isEmpty() || i != stack.peek())
                .forEach(i -> {
                    list.add(i);
                    stack.push(i);
                });

        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
    }
}