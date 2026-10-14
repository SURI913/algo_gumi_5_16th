/*
1961. 숫자 배열 회전 (D2)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=1961&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.util.*;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int N = sc.nextInt();
      int[][] matrix = new int[N][N];

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          matrix[r][c] = sc.nextInt();
        }
      }

      int[][] matrix_90 = new int[N][N];
      int[][] matrix_180 = new int[N][N];
      int[][] matrix_270 = new int[N][N];

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          matrix_90[r][c] = matrix[N - 1 - c][r];             // 행열 바꾸기, 행 뒤집기
          matrix_180[r][c] = matrix[N - 1 - r][N - 1 - c];    // 행 뒤집기, 열 뒤집기
          matrix_270[r][c] = matrix[c][N - 1 - r];            // 행열 바꾸기, 열 뒤집기
        }
      }

      System.out.println("#" + test_case);

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          System.out.print(matrix_90[r][c]);
        }

        System.out.print(" ");

        for (int c = 0; c < N; c++) {
          System.out.print(matrix_180[r][c]);
        }

        System.out.print(" ");

        for (int c = 0; c < N; c++) {
          System.out.print(matrix_270[r][c]);
        }

        System.out.println();
      }
    }
  }
}
