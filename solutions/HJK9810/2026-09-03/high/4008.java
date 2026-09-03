import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  private final char[] OPER = new char[] { '+', '-', '*', '/' };
  private int[] numbers;
  private int[] opers;
  private int[] result;

  private int calc(int first, int second, char order) {
    switch (order) {
      case '+':
        return first + second;
      case '-':
        return first - second;
      case '*':
        return first * second;
      case '/':
      default:
        return first / second;
    }
  }

  private void dfs(int idx, int total, int orderSum) {
    if (orderSum == 0) {
      result[1] = Math.max(total, result[1]);
      result[0] = Math.min(total, result[0]);
    } else {
      for (int index = 0; index < 4; index++) {
        if (opers[index] > 0) {
          opers[index]--;
          int next_total = calc(total, numbers[idx], OPER[index]);
          dfs(idx + 1, next_total, orderSum - 1);
          opers[index]++;
        }
      }
    }
  }
	
  public static void main(String args[]) throws Exception {
    Solution sol = new Solution();
    StringTokenizer st;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
      int N = Integer.parseInt(input.readLine());
      sol.numbers = new int[N];
      sol.opers = new int[4];
      sol.result = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

      st = new StringTokenizer(input.readLine());
      int orderSum = 0;
      for (int idx = 0; idx < 4; idx++) {
        sol.opers[idx] = Integer.parseInt(st.nextToken());
        orderSum += sol.opers[idx];
      }

      st = new StringTokenizer(input.readLine());
      for (int idx = 0; idx < N; idx++) {
        sol.numbers[idx] = Integer.parseInt(st.nextToken());
      }

      sol.dfs(1, sol.numbers[0], orderSum);

      sb.append("#").append(test_case)
        .append(" ").append(sol.result[1] - sol.result[0])
        .append("\n");
		}

    System.out.print(sb.toString());
	}
}
