import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
  private ArrayList<String> codes;
  private String[] orders;

  private int insert(int offset) {
    int x = Integer.parseInt(orders[offset]);
    int y = Integer.parseInt(orders[offset + 1]);

    for (int idx = 0; idx < y; idx++) {
      codes.add(x + idx, orders[offset + 2 + idx]);
    }

    return offset + 2 + y;
  }

  private int add(int offset) {
    int y = Integer.parseInt(orders[offset]);
    for (int idx = 0; idx < y; idx++) {
      codes.add(orders[offset + 1 + idx]);
    }

    return offset + 1 + y;
  }

  private int delete(int offset) {
    int x = Integer.parseInt(orders[offset]);
    int y = Integer.parseInt(orders[offset + 1]);

    for (int idx = 0; idx < y; idx++) {
      codes.remove(x);
    }

    return offset + 2;
  }

	public static void main(String args[]) throws Exception {
    Solution sol = new Solution();
    StringTokenizer st;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    // int T = Integer.parseInt(input.readLine());
    StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {
      int N = Integer.parseInt(input.readLine());
      sol.codes = new ArrayList<>();
      st = new StringTokenizer(input.readLine());
      for (int idx = 0; idx < N; idx++) {
        sol.codes.add(st.nextToken());
      }

      int M = Integer.parseInt(input.readLine());
      sol.orders = input.readLine().split(" ");
      
      int offset = 0;
      for (int count = 0; count < M; count++) {
        switch (sol.orders[offset]) {
          case "I":
            offset = sol.insert(offset + 1);
            break;
          case "D":
            offset = sol.delete(offset + 1);
            break;
          case "A":
          default:
            offset = sol.add(offset + 1);
            break;
        }
      }

      sb.append("#").append(test_case).append(" ");
      for (int idx = 0; idx < 10; idx++) {
        sb.append(sol.codes.get(idx)).append(" ");
      }
      sb.append("\n");
		}
    System.out.print(sb.toString());
	}
}
