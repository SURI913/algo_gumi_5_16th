import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    private int[] boards;

    private boolean isPrime(int row) {
        for (int idx = 0; idx < row; idx++) {
            if (boards[idx] == boards[row] || Math.abs(boards[idx] - boards[row]) == row - idx)
                return false;
        }
        return true;
    }

    private int traking(int row, int N) {
        if (row == N) return 1;

        int count = 0;
        for (int idx = 0; idx < N; idx++) {
            boards[row] = idx;
            if (isPrime(row)) {
                count += traking(row + 1, N);
                boards[row] = idx;
            }
        }

        return count;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(input.readLine());
            sol.boards = new int[N];

            int result = sol.traking(0, N);
            sb.append("#").append(test_case).append(" ")
                .append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
