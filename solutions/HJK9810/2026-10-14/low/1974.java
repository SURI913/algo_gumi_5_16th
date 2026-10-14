import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    private String[][] board;

    private boolean checkDuplicate(int r, int c) {
        int visited = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int num = Integer.parseInt(board[r + row][c + col]);
                if ((visited & (1 << num)) != 0) return true;
                visited |= (1 << num);
            }
        }

        for (int row = 0; row < 3; row++) {
            visited = 0;
            for (int col = 0; col < 9; col++) {
                int num = Integer.parseInt(board[r + row][col]);
                if ((visited & (1 << num)) != 0) return true;
                visited |= (1 << num);
            }
        }

        for (int col = 0; col < 3; col++) {
            visited = 0;
            for (int row = 0; row < 9; row++) {
                int num = Integer.parseInt(board[row][c + col]);
                if ((visited & (1 << num)) != 0) return true;
                visited |= (1 << num);
            }
        }

        return false;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            sol.board = new String[9][9];
            for (int row = 0; row < 9; row++) {
                sol.board[row] = input.readLine().split(" ");
            }

            boolean isDuplicate = true;
            for(int row = 0; row < 9; row += 3) {
                for (int col = 0; col < 9; col += 3) {
                    if (sol.checkDuplicate(row, col)) {
                        isDuplicate = false;
                        break;
                    }
                }
            }
    
            System.out.printf("#%d %d\n", test_case, isDuplicate ? 1 : 0);
        }
    }
}
