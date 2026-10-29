import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    private int[][] boards;
    private int[] dp;

    private int traking(int curr, int visited, int N) {
        if (curr == N) return 0;
        
        int result = Integer.MAX_VALUE;
        if (dp[visited] < result) return dp[visited];

        for (int idx = 0; idx < N; idx++) {
            if ((visited & (1 << idx)) != 0) continue;
            int cost = boards[curr][idx] + traking(curr + 1, visited | (1 << idx), N);
            result = Math.min(cost, result);
        }

        dp[visited] = result;
        return result;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(input.readLine());
            sol.boards = new int[N][N];
            sol.dp = new int[1 << N];

            Arrays.fill(sol.dp, Integer.MAX_VALUE);

            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(input.readLine());
                for (int col = 0; col < N; col++) {
                    sol.boards[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(test_case).append(" ")
                .append(sol.traking(0, 0, N)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
