import java.util.Scanner;

class Solution {
  private int value;

  private void inorder(int[] tree, int node, int N) {
    if (node > N) return;

    inorder(tree, node * 2, N);
    tree[node] = value;
    value += 1;
    inorder(tree, node  * 2 + 1, N);
  }

	public static void main(String args[]) throws Exception {
    Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
      int N = sc.nextInt();
      int[] tree = new int[N + 1];

      sol.value = 1;
      sol.inorder(tree, 1, N);

      System.out.printf("#%d %d %d\n", test_case, tree[1], tree[N / 2]);
		}

    sc.close();
	}
}
