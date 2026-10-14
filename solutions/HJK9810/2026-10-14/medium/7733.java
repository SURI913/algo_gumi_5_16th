import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution {
    private final int[] dr = {1, -1, 0, 0};
    private final int[] dc = {0, 0, 1, -1};

    private int[][] board;
    private int N;

    private int countCheeze(int day) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int count = 0;
        boolean[][] visited = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] <= day) visited[row][col] = true;
                if (visited[row][col]) continue;

                count++;
                queue.add(new int[] {row, col});
                visited[row][col] = true;

                while (!queue.isEmpty()) {
                    int[] poped = queue.pollFirst();

                    for (int idx = 0; idx < 4; idx++) {
                        int nr = dr[idx] + poped[0];
                        int nc = dc[idx] + poped[1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (visited[nr][nc] || board[nr][nc] <= day) continue;
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
        }

        return count;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++) {
            sol.N = Integer.parseInt(input.readLine());
            sol.board = new int[sol.N][sol.N];

            for (int row = 0; row < sol.N; row++) {
                st = new StringTokenizer(input.readLine());
                for (int col = 0; col < sol.N; col++) {
                    sol.board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCount = 0;
            int day = 0;
            while (true) {
                int count = sol.countCheeze(day);

                if (count == 0) break;
                maxCount = Math.max(count, maxCount);
                day++;
            }

            System.out.printf("#%d %d\n", test_case, maxCount);
        }
    }
}
