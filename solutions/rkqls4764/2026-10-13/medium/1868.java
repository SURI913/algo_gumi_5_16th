/*
1868. 파핑파핑 지뢰찾기 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc&categoryId=AV5LwsHaD1MDFAXc&categoryType=CODE&problemTitle=1868&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

  public static int N;
  public static int[][] map;
  public static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];  // 지뢰: 1, 빈칸: 0

      for (int i = 0; i < N; i++) {
        String line = br.readLine();
        for (int j = 0; j < N; j++) {
          char input = line.charAt(j);
          if (input == '*') {
            map[i][j] = -1;
          }
        }
      }

      // 폭탄 주변 칸 체크
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == -1) {
            for (int[] d : directions) {
              int nextR = i + d[0];
              int nextC = j + d[1];

              if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
                continue;
              }

              if (map[nextR][nextC] == -1) {
                continue;
              }

              map[nextR][nextC]++;
            }
          }
        }
      }

      visited = new boolean[N][N];
      int cnt = 0;

      // 주변에 폭탄이 없는 칸(그룹)의 수 세기
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == 0 && !visited[i][j]) {
            cnt++;
            bfs(i, j);
          }
        }
      }

      // 0이 아닌 방문하지 않은 숫자 칸 더하기
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] != -1 && !visited[i][j]) {
            cnt++;
          }
        }
      }

      bw.write("#" + t + " " + cnt + "\n");
    } 

    bw.flush();
  }

  public static void bfs(int r, int c) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] { r, c });
    visited[r][c] = true;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      for (int[] d : directions) {
        int nextR = cur[0] + d[0];
        int nextC = cur[1] + d[1];

        if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
          continue;
        }

        if (map[nextR][nextC] == -1 || visited[nextR][nextC]) {
          continue;
        }

        visited[nextR][nextC] = true;

        if (map[nextR][nextC] == 0) {
          queue.offer(new int[] { nextR, nextC });
        }
      }
    }
  }
}
