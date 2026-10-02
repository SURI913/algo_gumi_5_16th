import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private int[][] boards;

    private int calcSum(int row, int col, int N) {
        int total = 0;

        for (int idx = 0; idx < N; idx++) {
            total += boards[idx][col];
            total += boards[row][idx];
        }

        return total - boards[row][col];
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(input.readLine());
            sol.boards = new int[N][N];

            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(input.readLine());
                for (int col = 0; col < N; col++) {
                    sol.boards[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int maxScore = 0;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int score = sol.calcSum(row, col, N);
                    maxScore = Math.max(maxScore, score);
                }
            }

            System.out.printf("#%d %d\n", test_case, maxScore);
        }
    }
}
