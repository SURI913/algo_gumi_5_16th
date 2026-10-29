import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private final int[][] CROSS_DIR = new int[][] {
        new int[] {-1, -1}, new int[] {-1, 1}, new int[] {1, -1}, new int[] {1, 1},
    };
    private final int[][] DIR = new int[][] {
        new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1},
    };

    private int[][] boards;
    private int N, M;

    private int calcKiler(int row, int col, boolean isPlus) {
        int total = 0;
        int[][] base = isPlus ? DIR : CROSS_DIR;

        for (int count = 1; count < M; count++) {
            for (int[] dir : base) {
                int nr = dir[0] * count + row;
                int nc = dir[1] * count + col;

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                total += boards[nr][nc];
            }
        }

        return total + boards[row][col];
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            
            st = new StringTokenizer(input.readLine());
            sol.N = Integer.parseInt(st.nextToken());
            sol.M = Integer.parseInt(st.nextToken());
            sol.boards = new int[sol.N][sol.N];

            for (int row = 0; row < sol.N; row++) {
                st = new StringTokenizer(input.readLine());
                for (int col = 0; col < sol.N; col++) {
                    sol.boards[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int maxTotal = 0;
            for (int row = 0; row < sol.N; row++) {
                for (int col = 0; col < sol.N; col++) {
                    int plus = sol.calcKiler(row, col, true);
                    int cross = sol.calcKiler(row, col, false);
                    maxTotal = Math.max(maxTotal, Math.max(plus, cross));
                }
            }
            sb.append(maxTotal).append("\n");
        }

        System.out.println(sb.toString());
    }
}
