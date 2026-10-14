import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    private static final int MONTH_SIZE = 12;
    private static final int PAY_SIZE = 4;

    private int findMinPayByCombine(int[] months, int[] pays) {
        int minResult = Integer.MAX_VALUE;
        Stack<int[]> stack = new Stack<>();

        stack.add(new int[] {0, 0});

        while (!stack.isEmpty()) {
            int[] poped = stack.pop();
            int month = poped[0];
            int total = poped[1];

            if (month >= MONTH_SIZE) {
                minResult = Math.min(minResult, total);
                continue;
            }

            if (months[month] == 0) {
                stack.add(new int[] {month + 1, total});
                continue;
            }

            stack.add(new int[] {month + 1, total + pays[0] * months[month]});
            stack.add(new int[] {month + 1, total + pays[1]});
            stack.add(new int[] {month + 3, total + pays[2]});
        }

        return minResult;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(input.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int[] pays = new int[PAY_SIZE];
            int[] months = new int[MONTH_SIZE];

            st = new StringTokenizer(input.readLine());
            for (int idx = 0; idx < PAY_SIZE; idx++) {
                pays[idx] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(input.readLine());
            for (int idx = 0; idx < MONTH_SIZE; idx++) {
                months[idx] = Integer.parseInt(st.nextToken());
            }

            int combineMinResult = sol.findMinPayByCombine(months, pays);
            int result = Math.min(combineMinResult, pays[PAY_SIZE - 1]);
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
